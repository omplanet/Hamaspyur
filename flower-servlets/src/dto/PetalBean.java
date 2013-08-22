package dto;

public class PetalBean {
	private int id;
	private String name;
	private String description;
	private int colorCode;
	
	private String seedIconUrl;
	private int notificationsIconURL;
	private int notificationsCount;
	
	private int seedId1;
	private int seedId2;

	private int accessLevel;
	
	private int memberId;

	public PetalBean() {}

	public PetalBean(int id, String name, String description, int colorCode, String seedIconUrl,
			int notificationsIconURL, int notificationsCount, int seedId1,
			int seedId2, int accessLevel, int memberId) {
		super();
		this.id = id;
		this.name = name;
		this.colorCode = colorCode;
		this.seedIconUrl = seedIconUrl;
		this.notificationsIconURL = notificationsIconURL;
		this.notificationsCount = notificationsCount;
		this.seedId1 = seedId1;
		this.seedId2 = seedId2;
		this.accessLevel = accessLevel;
		this.memberId = memberId;
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
	
	public int getColor() {
		return colorCode;
	}

	public void setColor(int colorCode) {
		this.colorCode = colorCode;
	}

	public String getSeedIconUrl() {
		return seedIconUrl;
	}

	public void setSeedIconUrl(String seedIconUrl) {
		this.seedIconUrl = seedIconUrl;
	}

	public int getNotificationsIconURL() {
		return notificationsIconURL;
	}

	public void setNotificationsIconURL(int notificationsIconURL) {
		this.notificationsIconURL = notificationsIconURL;
	}

	public int getNotificationsCount() {
		return notificationsCount;
	}

	public void setNotificationsCount(int notificationsCount) {
		this.notificationsCount = notificationsCount;
	}

	public int getSeedId1() {
		return seedId1;
	}

	public void setSeedId1(int seedId1) {
		this.seedId1 = seedId1;
	}

	public int getSeedId2() {
		return seedId2;
	}

	public void setSeedId2(int seedId2) {
		this.seedId2 = seedId2;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	};
}
