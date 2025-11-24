
public class Room {
	private String roomType;
	private int dailyCost;
	private int roomSize;
	private boolean hasBath;
	
	public Room(String roomType, int dailyCost, int roomSize, boolean hasBath) {
		this.roomType = roomType;
		this.dailyCost = dailyCost;
		this.roomSize = roomSize;
		this.hasBath = hasBath;
	}
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(int dailyCost) {
		this.dailyCost = dailyCost;
	}


	public int getRoomSize() {
		return roomSize;
	}


	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}


	public boolean isHasBath() {
		return hasBath;
	}


	public void setHasBath(boolean hasBath) {
		this.hasBath = hasBath;
	}
	
	
	
	
	public static class Single extends Room {
		Single() {
			super("Single", 100, 15, false);
		}
	}
	public static class Double extends Room {
		 Double() {
			 super("Double", 180, 30, false);
		 }
	}
	public static class Club extends Room {
		 Club() {
			 super("Club", 250, 45, true);
		 }
	}
	public static class Family extends Room {
		 Family() {
			 super("Family", 400, 50, false);
		 }
	}
	public static class FamilyView extends Room {
		 FamilyView() {
			 super("Family With View", 450, 50, true);
		 }
	}
	public static class Suite extends Room {
		 Suite() {
			 super("Suite", 650, 80, true);
		 }
	}
	
	
}
