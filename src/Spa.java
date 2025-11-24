
public class Spa extends Services {

	private int days=0;
	private double spaCost;
	
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static int addSpa(int days) {
        days += 1;
        return days;
    }
	
	protected static double calculateService(double spaCost, int days) {
		spaCost = days*100;
		return spaCost;
	}
	
	protected String getServiceType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String displayInfo() {
		return("Reservation ID # "+ (int) spaCost + " has "+ days + " days of Spa Services.\n");
	}

	public Spa(int days, double spaCost) {
		super();
		this.days = days;
		this.spaCost = spaCost;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getSpaCost() {
		return spaCost;
	}

	public void setSpaCost(double spaCost) {
		this.spaCost = spaCost;
	}

	

}
