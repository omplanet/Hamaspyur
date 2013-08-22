package com.hamaspyur.flower.dto;

public class SeedBean {
	private int id;
	private String name;
	private String description;
	private int colorCode;
	
	private String seedIconUrl;
	private String notificationsIconURL;
	private int notificationsCount;
	
	private int accessLevel;

	private int teamId;

	public SeedBean() {};
	
	public SeedBean(int id, String name, String description, int colorCode, int accessLevel,
			String seedIconUrl, String notificationsIconURL,
			int notificationsCount, int teamId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.colorCode = colorCode;
		this.accessLevel = accessLevel;
		this.seedIconUrl = seedIconUrl;
		this.notificationsIconURL = notificationsIconURL;
		this.notificationsCount = notificationsCount;
		this.teamId = teamId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getColorCode() {
		return colorCode;
	}

	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getSeedIconUrl() {
		return seedIconUrl;
	}

	public void setSeedIconUrl(String seedIconUrl) {
		this.seedIconUrl = seedIconUrl;
	}

	public String getNotificationsIconURL() {
		return notificationsIconURL;
	}

	public void setNotificationsIconURL(String notificationsIconURL) {
		this.notificationsIconURL = notificationsIconURL;
	}

	public int getNotificationsCount() {
		return notificationsCount;
	}

	public void setNotificationsCount(int notificationsCount) {
		this.notificationsCount = notificationsCount;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
}
