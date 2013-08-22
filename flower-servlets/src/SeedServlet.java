

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HoneycombBean;

import java.io.PrintWriter;

/**
 * Servlet implementation class SeedServlet
 */
@WebServlet("/seed")
public class SeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String levelStr = request.getParameter("level");
		String positionStr = request.getParameter("position");
		String zoomStr = request.getParameter("zoom");

		System.out.println("doGet:\n level = " + levelStr + ", position = " + positionStr + ", zoom = " + zoomStr);
		
		int level = (levelStr == null) ? 1 : new Integer(levelStr);
		int position = (positionStr == null) ? 0 : new Integer(positionStr);
		int zoom = (zoomStr == null) ? 3 : new Integer(zoomStr);
		HoneycombBean honeycomb = new HoneycombBean();
		
		FruitSVG svg = new FruitSVG(honeycomb, level, position, zoom);
		StringBuffer content = svg.generateContent();
		pw.println(content);
		System.out.print(content);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
