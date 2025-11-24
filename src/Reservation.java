public class Reservation extends Services {
	
	private static int totalNumOfReservations;
	private String hotelName;
	private Room room;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	private int Laundry;
	private int Spa;
	private String city;
	public int ID;
	
	
	
	
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected String getServiceType() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addLaundry(int Laundry) {
        this.Laundry += Laundry;
    }

    public void addSpa(int Spa) {
        this.Spa += Spa;
    }
	
    public int servicePrice() {
		int serviceCost = Laundry*20 + Spa*100;
		return serviceCost;
	}
	
	
	
	
	
	public int calculateTotalPrice() {
		int total = (reservationEnd - reservationStart)*room.getDailyCost();
		if(reservationMonth.equals("June") || reservationMonth.equals("July") || reservationMonth.equals("August")) {
			total *= 2;
		}
		
		total += Services.calculateService();
		return total;
	}
	
	public int calculateBookingPrice() {
		int booking = (reservationEnd - reservationStart)*room.getDailyCost();
		if(reservationMonth.equals("June") || reservationMonth.equals("July") || reservationMonth.equals("August")) {
			booking *= 2;
		}
		return booking;
	}

	
	public String displayInfo() {
		return("Reservation for a " + ID+
				room.getRoomType()+" room in " + getHotelName() + " starts on " +
				getReservationMonth() + " " + getReservationStart() + " and ends on " +
				getReservationMonth() + " " + getReservationEnd() +".\n");		
		//("Reservation has total cost of $" + calculateTotalPrice());
		
	}

	@Override
	public String toString() {
	    return "Reservation for a " + ID +
	           room.getRoomType() + " room in " + getHotelName() +
	           " starts on " + getReservationMonth() + " " + getReservationStart() +
	           " and ends on " + getReservationMonth() + " " + getReservationEnd() +
	           ".\n";
	}

	
	
	public Reservation(int ID, String city, String hotelName, String reservationMonth, int reservationStart, int reservationEnd, String roomType) {
		super();
		this.city = city;
		this.hotelName = hotelName;
		switch(roomType) {
        case "Single":
            this.room = new Room.Single();
            break;
        case "Double":
            this.room = new Room.Double();
            break;
        case "Club":
            this.room = new Room.Club();
            break;
        case "Family":
            this.room = new Room.Family();
            break;
        case "Family With View":
            this.room = new Room.FamilyView();
            break;
        case "Suite":
            this.room = new Room.Suite();
            break;
        default:
            this.room = new Room.Single();
            break;
    }
		this.reservationMonth = reservationMonth;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.Laundry = 0;
        this.Spa = 0;
        this.ID = ID;
        Reservation.setTotalNumOfReservations(Reservation.getTotalNumOfReservations() + 1);
	}
	
	
	
	
	
	public int getID() {
        return ID;
    }
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getReservationMonth() {
		return reservationMonth;
	}

	public void setReservationMonth(String reservationMonth) {
		this.reservationMonth = reservationMonth;
	}

	public int getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(int reservationStart) {
		this.reservationStart = reservationStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(int reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public static int getTotalNumOfReservations() {
		return totalNumOfReservations;
	}

	public static void setTotalNumOfReservations(int totalNumOfReservations) {
		Reservation.totalNumOfReservations = totalNumOfReservations;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

}
