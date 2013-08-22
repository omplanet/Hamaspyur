package com.hamaspyur.flower.server;

import com.hamaspyur.flower.dto.HoneycombBean;

public class FlowerServiceImpl {
//	return FlowerServiceImpl.getFlower("3", "4", "5");

	protected static String getFlower(String levelStr, String positionStr, String zoomStr)  {
		
//		String levelStr = request.getParameter("level");
//		String positionStr = request.getParameter("position");
//		String zoomStr = request.getParameter("zoom");

		System.out.println("doGet:\n level = " + levelStr + ", position = " + positionStr + ", zoom = " + zoomStr);
		
		int level = (levelStr == null) ? 1 : new Integer(levelStr);
		int position = (positionStr == null) ? 0 : new Integer(positionStr);
		int zoom = (zoomStr == null) ? 3 : new Integer(zoomStr);
		HoneycombBean honeycomb = new HoneycombBean();
		
		FruitSVG svg = new FruitSVG(honeycomb, level, position, zoom);
		StringBuffer content = svg.generateContent();
		System.out.print(content);

		return content.toString();
	}
}
