package com.hamaspyur.flower.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class HoneycombBean {
	private String name;
	private ArrayList<ArrayList<SeedBean>> honeycomb;
	
	public HoneycombBean() {
		//TODO
		this.name = "testHoneycomeb";
		this.honeycomb = testHoneycomeb;
	}
	
	public HoneycombBean(String name, ArrayList<ArrayList<SeedBean>> honeycomb) {
		super();
		this.name = name;
		this.honeycomb = honeycomb;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public ArrayList<SeedBean> getSeedLevel(int level) throws Exception {
		if (level == 0) throw new Exception("HoneycombBean.getSeedsByLevel() level = 0.");
		else if (level >= honeycomb.size()) throw new Exception("HoneycombBean.getSeedsByLevel() level is out of bound: " + level);
		else if (honeycomb.get(level) == null) throw new Exception("HoneycombBean.getSeedsByLevel() the seed level is null: " + level);
		
		return honeycomb.get(level);
	}
	
	public SeedBean getSeed(int level, int position) throws Exception {
		return getSeedLevel(level).get(position);
	}
	
	public SeedBean getCentralSeed() {
		return honeycomb.get(0).get(0);
	}

	public ArrayList<ArrayList<SeedBean>> getHoneycomb() {
		return honeycomb;
	}

	public void setHoneycomb(ArrayList<ArrayList<SeedBean>> honeycomb) {
		this.honeycomb = honeycomb;
	}
	
	//TEST DATA
	private static ArrayList<ArrayList<SeedBean>> testHoneycomeb = new ArrayList<ArrayList<SeedBean>>(
		// (level == 1) ? (count = 1) : (count = (level - 1) * 6
		Arrays.asList(
					//level == 0, count = 0
					new ArrayList<SeedBean> (
					),
					//level == 1, count = 1
					new ArrayList<SeedBean> (
							Arrays.asList(
										new SeedBean(1, "Core Team", "", 1, 0, null, null, 2, 0)
										)
					),
					//level = 2, count = 6
					new ArrayList<SeedBean> (
							Arrays.asList(
										new SeedBean(2010, "Team 2.1", "", 2, 0, null, null, 0, 0),
										new SeedBean(2020, "Team 2.2", "", 2, 0, null, null, 0, 0),
										new SeedBean(2030, "Team 2.3", "", 2, 0, null, null, 6, 0),
										new SeedBean(2040, "Team 2.4", "", 2, 0, null, null, 0, 0),
										new SeedBean(2050, "Team 2.5", "", 2, 0, null, null, 0, 0),
										new SeedBean(2060, "Team 2.6", "", 2, 0, null, null, 3, 0)
										)
					),
					//level = 3, count = 12
					new ArrayList<SeedBean> (
							Arrays.asList(
										new SeedBean(3010, "3.1", "", 3, 0, null, null, 0, 0),
										new SeedBean(3020, "Team 3.2", "", 2, 0, null, null, 0, 0),
										new SeedBean(3030, "3.3", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 3.4", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "3.5", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 3.6", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "3.7", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "3.8", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "3.9", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "3.10", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "3.11", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 3.12", "", 2, 0, null, null, 0, 0)
										)
					),
					//level = 4, count = 18
					new ArrayList<SeedBean> (
							Arrays.asList(
										new SeedBean(0, "4.1", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.2", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "4.3", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 3.4", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "4.5", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.6", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "4.7", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "4.8", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "4.9", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "4.10", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "4.11", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.12", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.13", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.14", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.15", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "Team 4.16", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.17", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 4.18", "", 2, 0, null, null, 3, 0)
										)
					),
					//level = 5, count = 24
					new ArrayList<SeedBean> (
							Arrays.asList(
										new SeedBean(0, "5.1", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.2", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "5.3", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.4", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "5.5", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.6", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "5.7", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "5.8", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "5.9", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "5.10", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "5.11", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.12", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.13", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.14", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.15", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "Team 5.16", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.17", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.18", "", 2, 0, null, null, 3, 0),
										new SeedBean(0, "Team 5.19", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.20", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.21", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "Team 5.22", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.23", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 5.24", "", 2, 0, null, null, 3, 0)
										)
					),
					//level = 6, count = 30
					new ArrayList<SeedBean> (
							Arrays.asList(
										new SeedBean(0, "6.1", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.2", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "6.3", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.4", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "6.5", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.6", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "6.7", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "6.8", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "6.9", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "6.10", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "6.11", "", 3, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.12", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.13", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.14", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.15", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "Team 6.16", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.17", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.18", "", 2, 0, null, null, 3, 0),
										new SeedBean(0, "Team 6.19", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.20", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.21", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "Team 6.22", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.23", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.24", "", 2, 0, null, null, 3, 0),
										new SeedBean(0, "Team 6.25", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.26", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.27", "", 2, 0, null, null, 6, 0),
										new SeedBean(0, "Team 6.28", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.29", "", 2, 0, null, null, 0, 0),
										new SeedBean(0, "Team 6.30", "", 2, 0, null, null, 3, 0)
										)
					)
					
					
		)
	);
	
}
		
								/*
								//level = 4, count = 18
								array('4.1', $urlSeed, $colorSeed3),
								array('Team 4.2', $urlSeed, $colorSeed2),
								array('4.3', $urlSeed, $colorSeed3),
								array('Team 4.4', $urlSeed, $colorSeed2),
								array('4.5', $urlSeed, $colorSeed3),
								array('4.6', $urlSeed, $colorSeed3),
								array('4.7', $urlSeed, $colorSeed3),
								array('4.8', $urlSeed, $colorSeed3),
								array('4.9', $urlSeed, $colorSeed3),
								array('4.10', $urlSeed, $colorSeed3),
								array('4.11', $urlSeed, $colorSeed3),
								array('Team 4.12', $urlSeed, $colorSeed2),
								array('4.13', $urlSeed, $colorSeed3),
								array('4.14', $urlSeed, $colorSeed3),
								array('Team 4.15', $urlSeed, $colorSeed2),
								array('4.16', $urlSeed, $colorSeed3),
								array('4.17', $urlSeed, $colorSeed3),
								array('4.18', $urlSeed, $colorSeed3),
								//level = 5, count = 24
								array('5.1', $urlSeed, $colorSeed3),
								array('5.2', $urlSeed, $colorSeed3),
								array('Team 5.3', $urlSeed, $colorSeed2),
								array('Team 5.4', $urlSeed, $colorSeed2),
								array('Team 5.5', $urlSeed, $colorSeed2),
								array('5.6', $urlSeed, $colorSeed3),
								array('5.7', $urlSeed, $colorSeed3),
								array('Team 5.8', $urlSeed, $colorSeed2),
								array('5.9', $urlSeed, $colorSeed3),
								array('5.10', $urlSeed, $colorSeed3),
								array('Team 5.11', $urlSeed, $colorSeed2),
								array('Team 5.12', $urlSeed, $colorSeed2),
								array('5.13', $urlSeed, $colorSeed3),
								array('5.14', $urlSeed, $colorSeed3),
								array('Team 5.15', $urlSeed, $colorSeed2),
								array('5.16', $urlSeed, $colorSeed3),
								array('Team 5.17', $urlSeed, $colorSeed2),
								array('5.18', $urlSeed, $colorSeed3),
								array('Team 5.19', $urlSeed, $colorSeed2),
								array('5.20', $urlSeed, $colorSeed3),
								array('Team 5.21', $urlSeed, $colorSeed2),
								array('5.22', $urlSeed, $colorSeed3),
								array('5.23', $urlSeed, $colorSeed3),
								array('5.24', $urlSeed, $colorSeed3),
								//level = 6, count = 30
								array('Team 6.1', $urlSeed, $colorSeed2),
								array('6.2', $urlSeed, $colorSeed3),
								array('6.3', $urlSeed, $colorSeed3),
								array('6.4', $urlSeed, $colorSeed3),
								array('6.5', $urlSeed, $colorSeed3),
								array('6.6', $urlSeed, $colorSeed3),
								array('6.7', $urlSeed, $colorSeed3),
								array('6.8', $urlSeed, $colorSeed3),
								array('6.9', $urlSeed, $colorSeed3),
								array('6.10', $urlSeed, $colorSeed3),
								array('Team 6.11', $urlSeed, $colorSeed2),
								array('6.12', $urlSeed, $colorSeed3),
								array('6.13', $urlSeed, $colorSeed3),
								array('6.14', $urlSeed, $colorSeed3),
								array('6.15', $urlSeed, $colorSeed3),
								array('6.16', $urlSeed, $colorSeed3),
								array('6.17', $urlSeed, $colorSeed3),
								array('6.18', $urlSeed, $colorSeed3),
								array('Team 6.19', $urlSeed, $colorSeed2),
								array('Team 6.20', $urlSeed, $colorSeed2),
								array('Team 6.21', $urlSeed, $colorSeed2),
								array('6.22', $urlSeed, $colorSeed3),
								array('6.23', $urlSeed, $colorSeed3),
								array('Team 6.24', $urlSeed, $colorSeed2),
								array('Team 6.25', $urlSeed, $colorSeed2),
								array('Team 6.26', $urlSeed, $colorSeed2),
								array('6.27', $urlSeed, $colorSeed3),
								array('6.28', $urlSeed, $colorSeed3),
								array('6.29', $urlSeed, $colorSeed3),
								array('6.30', $urlSeed, $colorSeed3),
				);

	*/