package Store;

public class Mouse extends Product {

	private String description;
	private int dpi;
	private int numButtons;
	private String connectivity;
	
	public Mouse(String number, String name, double price, int dpi, int numButtons, String connectivity) {
		super(number, name, price);
		this.dpi = dpi;
		this.numButtons = numButtons;
		this.connectivity = connectivity; 
		this.description = "Product Number: " + super.getProductNumber() + "\n"
							+ super.getProductName() + "-------" + super.getProductPrice() + "\n"
							+ "DPI: " + dpi + "\n"
							+ "Number of buttons: " + numButtons + "\n"
							+ "Connectivity: " + connectivity;
	}
	
	public String toString() {
		return super.getProductNumber() + "," + super.getProductName() + "," + super.getProductPrice() + "," + dpi + "," + numButtons + "," + connectivity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getDpi() {
		return dpi;
	}

	public int getNumButtons() {
		return numButtons;
	}

	public String getConnectivity() {
		return connectivity;
	}
}
