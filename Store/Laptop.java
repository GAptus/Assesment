package Store;

public class Laptop extends Product {
	
	private String description;
	private double weight;
	private	double screenSize;
	private int hardDriveSize;
	private int numUSBPorts;
	private String processor;
	
	public Laptop(String number, String name, double price, String description, double weight,
			double screenSize, int hardDriveSize, int numUSBPorts, String processor) {
		super(number, name, price);
		this.weight = weight;
		this.screenSize = screenSize;
		this.hardDriveSize = hardDriveSize;
		this.numUSBPorts = numUSBPorts;
		this.processor = processor;
		this.description = "Product Number: " + super.getProductNumber() + "\n"
						+ super.getProductName() + "-------" + super.getProductPrice() + "\n"
						+ "Weight(Kg): " + weight + "\n"
						+ "Screen size (inches): " + screenSize + "\n"
						+ "Hard Drive (Gb): " + hardDriveSize + "\n"
						+ "Number of USB ports: " + numUSBPorts + "\n"
						+ "Processor: " + processor;
	}
	
	public String toString() {
		return super.getProductNumber() + "," + super.getProductName() + "," + super.getProductPrice() + "," + weight
				 + "," + screenSize + "," + hardDriveSize + "," + numUSBPorts + "," + processor;
	}
	
	public String getDescription() {
		return description;
	}

	public double getWeight() {
		return weight;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public int getHardDriveSize() {
		return hardDriveSize;
	}

	public int getNumUSBPorts() {
		return numUSBPorts;
	}

	public String getProcessor() {
		return processor;
	}
}
