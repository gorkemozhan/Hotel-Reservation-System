
public class Laundry extends Services{

	
	private int clothingPieces;
	private double laundryCost;
	
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected String getServiceType() {
		// TODO Auto-generated method stub
		return null;
	}

	protected static double calculateService(double laundryCost, int clothingPieces) {
		laundryCost = clothingPieces * 20;
		return laundryCost;
	}
	
	public void addLaundry(int clothinPieces) {
        this.clothingPieces += clothinPieces;
    }
	
	public String displayInfo() {
		return("Reservation ID # "+ (int) laundryCost + " has "+ clothingPieces + " pieces assigned for Laundry Service.\n");
	}


	public Laundry(int clothingPieces, double laundryCost) {
		super();
		this.clothingPieces = clothingPieces;
		this.laundryCost = laundryCost;
	}

	public int getClothingPieces() {
		return clothingPieces;
	}

	public void setClothingPieces(int clothingPieces) {
		this.clothingPieces = clothingPieces;
	}

	public double getLaundryCost() {
		return laundryCost;
	}

	public void setLaundryCost(double laundryCost) {
		this.laundryCost = laundryCost;
	}

	
}
