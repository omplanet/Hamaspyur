package com.hamaspyur.flower.server;
import com.hamaspyur.flower.dto.*;
import com.hamaspyur.flower.util.ColorCodes;


public class FruitSVG {
	//SVG Params
	private static final String urlBase = "seed";
	private static final String sendMessageIconURL = "http://hamaspyur.org/fl/communication.png";

	private static final int maxZooomLevel = 6;

	private static final int deltaX = 30;
	private static final int deltaY = 26;
	
	private static final int seedRotation = -60;
	
	//Seed Params
	private final HoneycombBean honeycomb;
	private final int honeycombLevel;
	private final int honeycombPosition;
	private final int zoomLevel;

	private int width;
	private int height;
	
	private int startX;
	private int startY;
	
	private String title;

	private StringBuffer content = new StringBuffer();
	
//	public FruitSVG(HoneycombBean honeycomb, int seedId, int zoomLevel) {
//
//		this.honeycombLevel = 0;
//		this.honeycombPosition = 0;
//		
//		this.title = "Seed [" + honeycombLevel +", " + honeycombPosition +"]" + " from " + honeycomb;
//	}
	
	public FruitSVG(HoneycombBean honeycomb, int honeycombLevel, int honeycombPosition, int zoomLevel) {
		//Init Params
		this.honeycomb = honeycomb;
		this.honeycombLevel = honeycombLevel;
		this.honeycombPosition = honeycombPosition;
		
		zoomLevel = (zoomLevel <= maxZooomLevel) ? zoomLevel : maxZooomLevel;
		this.zoomLevel = zoomLevel;
		
		this.title = "Seed [" + honeycombLevel +", " + honeycombPosition +"]" + " from " + honeycomb;
	}
	
	public StringBuffer generateContent() {
		System.out.println("Generating new SeedSVG\n level = " + honeycombLevel + ", position = " + honeycombPosition + ", zoom = " + zoomLevel);		
		
		if(zoomLevel == 1) addSeed();
		else if(zoomLevel == 2) addFlower();
		else if(zoomLevel > 2) addFruit();
		
		//BUTTONS
		addZoomButtons();
		addMessageButton();
		
		//CLOSE CONTENT
		content.append( "</g>\n");
		content.append( "</svg>");
		
		return content;
	}

	//FOR DEBUG
	private void addRect() {
		content.append( "<rect x=\"0\" y=\"0\" rx=\"5\" ry=\"5\" width=\"" + width + "\" height=\"" + height + "\"\n" +
						"style=\"fill:red;stroke:#5c3816;stroke-width:1;opacity:0.7\"/>\n" +
						"\n");
	}
	
	//ADD 3 TYPE OF CONTENTES - SEED, FLOWER or FRUIT////////////////////////////////////////////////////////////////////
	
	private void addSeed() {
		width = 330;
		height = width;
		
		//HEADER
		content.append(	"<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\" ?>\n" +
						"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
						"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.2\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xml:space=\"preserve\"\n" +
						"style=\"shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd\" width=\"100%\" height=\"100%\" viewBox=\"0 0 " + width + " " + height + "\">\n");
		
		//DEFS
		addSeedDefs();
		
		//DEBUG RECT
		addRect();
		
		//OPEN CONTENT
		content.append( "<!-- START of Content -->\n" +
						"<g id=\"gContent\"><title>" + title + "</title>\n");
		
		addSeedPetals();
	}
	
	private void addFlower() {
		width = zoomLevel * deltaX * 4 - 2 * deltaX;
		height = width;
		
		startX = width / 2;
		startY = height / 2;
		
		//HEADER
		content.append(	"<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\" ?>\n" + 
						"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
						"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.2\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xml:space=\"preserve\"\n" +
						"style=\"shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd\"\n" +
						"width=\"100%\" height=\"100%\" viewBox=\"0 0 " + width + " " + height + "\">\n");
		
		//DEFS
		addFruitDefs();
		
		//DEBUG RECT
		addRect();
		
		//OPEN CONTENT
		content.append( "<!-- START of Content -->\n" +
						"<g id=\"gContent\"><title>" + title + "</title>\n");
		
		addFruitCells();
	}
	
	private void addFruit() {
		width = zoomLevel * deltaX * 4 - 2 * deltaX;
		height = width;
		
		startX = width / 2;
		startY = height / 2;
		
		//HEADER
		content.append(	"<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\" ?>\n" + 
						"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
						"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.2\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xml:space=\"preserve\"\n" +
						"style=\"shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd\"\n" +
						"width=\"100%\" height=\"100%\" viewBox=\"0 0 " + width + " " + height + "\">\n");
		
		//DEFS
		addFruitDefs();
		
		//DEBUG RECT
		addRect();
		
		//OPEN CONTENT
		content.append( "<!-- START of Content -->\n" +
						"<g id=\"gContent\"><title>" + title + "</title>\n");
		
		addFruitCells();
	}
	
	//ADD DEF FUNCTIONS////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void addSeedDefs() {
		content.append(	"<defs>\n" + 
						"	<style type=\"text/css\">\n" + 
						"	<![CDATA[\n" + 
						"\n" + 
						"		.strSpiral {stroke:#77f;stroke-width:0.2;stroke-dasharray:1 0.1}\n" +
						"		.strInnerFlower   {stroke:#5c3816;stroke-width:2;stroke-dasharray:2 2}\n" +
						"		.strExtFlower   {stroke:#5c3816;stroke-width:3;}\n" +
						"		.strPetalGroup2   {stroke:#5c3816;stroke-width:3}\n" +
						"		.strPetalGroup1   {stroke:#5c3816;stroke-width:3}\n" +
						"		.strSubPetal    {stroke:#5c3816;stroke-width:3;stroke-dasharray:2 2}\n" +
						"\n");
		
		addZoomBoxStyle();
		
		content.append(
						"\n" +
						"	]]>\n" +
						"	</style>\n" +
						"</defs>\n");
	}
	
	private void addFlowerDefs() {}
	
	private void addFruitDefs() {
		content.append(	"<defs>\n" + 
						"	<style type=\"text/css\">\n" + 
						"	<![CDATA[\n" + 
						"\n" + 
						"		.fil0 {fill:none}\n" +
						"		.fil1 {fill:#FFE711;fill-opacity:0.3}\n" +
						"		.fil2 {fill:#FFE711;fill-opacity:0.3}\n" +
						"		.fil3 {fill:transparent; fill-opacity:0.3}\n" +
						"\n");
								
		addZoomBoxStyle();
		
		content.append(
						"\n" +
						"	]]>\n" +
						"	</style>\n" +
						"</defs>\n");
	}
	
	private void addZoomBoxStyle() {
		content.append(
				"		.zoomBoxStyle {fill:#DAA312;fill-opacity:0.5}\n" +
				"		.zoomSignStyle {fill:white;}\n");
	}
	
	//ADD CONTENT PARTS FUNCTIONS//////////////////////////////////////////////////////////////////////////////////
	
	private void addSeedPetals() {
		
	}
	
	private void addFruitCells() {
		//SEEDS
		int x = 0;
		int y = 0;
		
		addCell(x, y, 0, 0); //add the first seed
		
		for(int L = 1; L < zoomLevel; L++) {
			int position = 0;
			for(int i = L-1; i < L; i++) addCell(++x, y, L, position++);  // move right
			for(int i = 0; i<L-1; i++) addCell(x, ++y, L, position++); // move down right. Note N-1
			for(int i = 0; i<L; i++) addCell(--x, ++y, L, position++); // move down left
			for(int i = 0; i<L; i++) addCell(--x, y, L, position++); // move left
			for(int i = 0; i<L; i++) addCell(x, --y, L, position++); // move up left
			for(int i = 0; i<L; i++) addCell(++x, --y, L, position++); // move up right
			for(int i = 0; i<L; i++) addCell(++x, y, L, position++);  // move right
		}
	}
	
	private void addCell(int x, int y, int L, int position) {	
		try {
			SeedBean seed = getSeed(L+1, position);
			String url = getSeedURL(L+1, position);
			String col = getSeedColor(seed);
//			int notifValue = getSeedNotificationsCount(L+1, position);
			String name = getSeedName(seed);
			
			int translateX = ((startX + deltaX * y) + deltaX * x * 2);
			int translateY = startY + deltaY * y * 2;
			content.append(
			"	<g fill=\"" + col + "\" id=\"gSeed\" transform=\"translate(" + translateX + ", " + translateY + ")\">\n" +
			"		<a xlink:href=\"" + url + "\" xlink:show=\"replace\">\n" +
			"			<circle fill=\"" + col + "\" cx=\"0\" cy=\"0\" r=\"" + deltaX + "\"/>\n" +
			"			<text x=\"0\" y=\"" + deltaX / 6 + "\" text-anchor=\"middle\" font-size=\"" + deltaX / 3 + "\" font-family=\"Arial\" font-weight=\"bold\" fill=\"" + ColorCodes.COLOR_TEXT_1.toString() + "\">\n" +
			"				" + name + "\n" +
			"			</text>\n" +
			"		</a>\n" +
			"	</g>\n" +
			"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addZoomButtons() {
		try {
			if( (zoomLevel > 1) || (zoomLevel < maxZooomLevel) ) {
				content.append("<!-- START of Zoom -->\n" +
						"	<g id=\"gZoom\" transform=\"translate(" + width + ", " + height + ")\">\n");
				
				if(zoomLevel > 1) {
					content.append(
						"		<a xlink:href=\"" + getNextFruitURL(zoomLevel - 1) + "\" xlink:show=\"replace\">\n" +
						"			<rect x=\"" + (-width/5) + "\" y=\"" + (-height/10) + "\" rx=\"" + (width/40) + "\" ry=\"" + (width/40) + "\" width=\"" + (width/10) + "\" height=\"" + (height/10) + "\"  class=\"zoomBoxStyle\"/>\n" +
						"			<rect x=\"" + (-width/60 - width/15 - width/10) + "\" y=\"" + (-height/120 - height/20) + "\" rx=\"0\" ry=\"0\" width=\"" + (width/15) + "\" height=\"" + (height/60) + "\"  class=\"zoomSignStyle\" />\n" +
						"		</a>\n");
				}
				
				if(zoomLevel < maxZooomLevel) {
					content.append(
						"		<a xlink:href=\"" + getNextFruitURL(zoomLevel + 1) + "\" xlink:show=\"replace\">\n" +
						"			<rect x=\"" + (-width/10) + "\" y=\"" + (-height/10) + "\" rx=\"" + (width/40) + "\" ry=\"" + (width/40) + "\" width=\"" + (width/10) + "\" height=\"" + (height/10) + "\"  class=\"zoomBoxStyle\"/>\n" +
						"			<rect x=\"" + (-width/120 - width/20) + "\" y=\"" + (-height/60 - height/15) + "\" rx=\"0\" ry=\"0\" width=\"" + (width/60) + "\" height=\"" + (height/15) + "\"  class=\"zoomSignStyle\" />\n" +
						"			<rect x=\"" + (-width/60 - width/15) + "\" y=\"" + (-height/120 - height/20) + "\" rx=\"0\" ry=\"0\" width=\"" + (width/15) + "\" height=\"" + (height/60) + "\"  class=\"zoomSignStyle\" />\n" +
						"		</a>\n");
				}
				
				content.append(
						"	</g>\n" +
						"<!-- END of Zoom -->\n");
			}
		} catch (Exception e) {
			System.out.println("Exception: addZoomButtons zoomLevel = " + zoomLevel);
			e.printStackTrace();
		}
	}
	
	private void addMessageButton() {
		try {
			content.append("<!-- START of Send Message -->\n" +
					"	<g id=\"gMessage\" transform=\"translate(0, " + height + ")\">\n" +
					"		<a xlink:href=\"" + getSendMessageURL() + "\" xlink:show=\"replace\">\n" +
					"			<image x=\"" + (width/20) + "\" y=\"" + (-height/10) + "\" width=\"" + (width/10) + "\" height=\"" + (height/10) + "\" xlink:href=\"" + sendMessageIconURL + "\"/>\n" +
					"		</a>\n" +
					"	</g>\n" +
					"<!-- END of Send Message -->\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private SeedBean getSeed(int level, int position) throws Exception {
		//Translate coordinates
		int relativeLevel = level;
		int relativePosition = position;
		
		SeedBean seed = honeycomb.getSeed(level, position);
		
		return seed;
	}
	
	private String getSeedName(SeedBean seed) {
		String name = seed.getName();
		
		return name;
	}
	
	private String getSeedDescription(SeedBean seed) {
		String desc = seed.getDescription();
		
		return desc;
	}
	
	private String getSeedColor(SeedBean seed) {
		int colorCode= seed.getColorCode();
		
		return ColorCodes.values()[colorCode].toString();
	}
	
	private int getSeedNotificationsCount(SeedBean seed) {
		int value= seed.getNotificationsCount();

		return value;
	}
		
	private String getSeedURL(int level, int position) {
		String url = "#";
		try {
			url = urlBase
					+ "&#63;level=" + level
					+ "&amp;position=" + position
					+ "&amp;zoom=1";
		} catch (Exception e) {
			System.out.println("ERROR: getSeedURL -> level = " + level);
			e.printStackTrace();
		}
		
		return url;
	}
	
	private String getSendMessageURL() {
		String url = urlBase;
		
		return url;
	}
	
	private String getNextFruitURL(int zoom) throws Exception {
		String url = "#";
		try {
			url = urlBase
					+ "&#63;level=" + honeycombLevel
					+ "&amp;position=" + honeycombPosition
					+ "&amp;zoom=" + zoom;
		} catch (Exception e) {
			System.out.println("ERROR: getNextFruitURL -> zoom = " + zoom);
			e.printStackTrace();
		}
		
		return url;
	}
}
