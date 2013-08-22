import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public class ChatServlet extends HttpServlet {

	private static final String _tokenKey = "token_list";
	private static final String _messageKey = "message_list";
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		String message_type = req.getParameter("type");
		String user_name = user.getNickname();
		
		String userId = user.getUserId();
		
		if( message_type.compareTo("message") == 0 ) {
			String message = req.getParameter("text");
			String chat_message = chatMessage( user_name, message );
			sendChannelMessageToAll( user_name, chat_message );	
			addMessageToCache(chat_message);
		}
		else if( message_type.compareTo("get_token") == 0 ) {
			// generate and give token to user
			ChannelService channelService = ChannelServiceFactory.getChannelService();
			String token = channelService.createChannel(userId);
			addToCacheList( _tokenKey, userId );
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print( tokenMessage( user_name, token ) );
		}
		else if( message_type.compareTo("leave") == 0 ) {
			removeFromCacheList( _tokenKey, userId );
		}
	}

	private String chatMessage(String user_name, String message) {
		Map pack = new HashMap<String, String>();
		pack.put("type", "'message'");
		pack.put("user", "'" + user_name + "'");
		pack.put("text", "'" + message + "'");
		return responseToJson(pack);
	}
	
	private String tokenMessage(String user_name, String token) {
		Map pack = new HashMap<String, String>();
		pack.put("type", "'token'");
		pack.put("user", "'" + user_name + "'");
		pack.put("token", "'" + token + "'");
		
		String messages = messageArrayJson();
		
		if( messages.length() > 0 ) {
			pack.put( "messages", messages );
		}
		
		return responseToJson(pack);
	}
	
	private void sendChannelMessageToAll( String author, String message ) {
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		List<String> keys = getListFromCacahe( _tokenKey );
		
		for( String k : keys ) {
			channelService.sendMessage(new ChannelMessage(k, message));
		}
	}
	
	public static String responseToJson( Map pack ) {
		String response = "{";
		if( pack != null ) {
			for( Object entry : pack.entrySet() ){
				response += ((Map.Entry)entry ).getKey() + ":" + ((Map.Entry)entry ).getValue() + ",";
			}

			// Remove trail comma
			response = response.substring( 0, response.length() - 1 );
			response += "}";
		}
		
		return response;
	}
	
	private String messageArrayJson() {
		List<String> messages = getListFromCacahe( _messageKey );
		
		if( messages == null )
			return "";
		
		String ret = "[";
		
		for( String mess : messages ) {
			ret += mess + ",";
		}
		
		// Remove trail comma
		ret = ret.substring( 0, ret.length() - 1 );
		ret += "]";
		
		return ret;
	}
	
	private void addMessageToCache( String message ) {
		List messages = (List )keycache.get( _messageKey );
		
		if( messages == null )
			messages = new LinkedList<String>();
		
		if( messages.size() > 50 )
			messages.remove( 0 );
		messages.add( message );
		keycache.put( _messageKey, messages );
	}
	
	private static MemcacheService keycache = MemcacheServiceFactory.getMemcacheService();
	
	public static void addToCacheList( String key, String str ) {
		// Add to string list in cache 
		//
		if( !keycache.contains( key ) ) {
			List names = new LinkedList<String>();		
			names.add( str );
			keycache.put( key, names );
		}
		else {
			List names = (List )keycache.get( key );
			if( !names.contains( str ) ) {
				names.add(str);
				keycache.put( key, names );
			}
		}
	}
	
	private List<String> getListFromCacahe( String key ) {
		return (List )keycache.get( key );	
	}
	
	private static void removeFromCacheList( String key, String str ) {
		List names = (List )keycache.get( key );
		names.remove( str );
		keycache.put( key, names );
	}
}
