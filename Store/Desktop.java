package Store;

public class Desktop extends Product {
	
	private String description;
	private String size;
	private int numUSBPorts;
	private String processor;
	private String graphicsCard;
	private int ramSize;
	private int hardDriveSize;
	
	public Desktop(String number, String name, double price, int numUSBPorts, String processor, String graphicsCard, int ramSize, int hardDriveSize) {
		super(number, name, price);
		this.numUSBPorts = numUSBPorts;
		this.processor = processor;
		this.graphicsCard = graphicsCard;
		this.ramSize = ramSize;
		this.hardDriveSize = hardDriveSize;
		this.description = "Product Number: " + super.getProductNumber() + "\n"
						+ super.getProductName() + "--------" + super.getProductPrice() + "\n"
						+ "Number of USB ports: " + numUSBPorts + "\n"
						+ "Processor: " + processor + "\n"
						+ "Graphics card: " + graphicsCard + "\n"
						+ "RAM: " + ramSize + "\n"
						+ "Hard Drive size (gb): " + hardDriveSize;
	}
	
	public String toString() {
		return super.getProductNumber() + "," + super.getProductName() + "," + super.getProductPrice()  + "," + size 
				+ "," + numUSBPorts + "," + processor + "," + graphicsCard  + "," + ramSize + "," + hardDriveSize;
	}
	
	public String getDescription() {
		return description;
	}

	public String getSize() {
		return size;
	}

	public int getNumUSBPorts() {
		return numUSBPorts;
	}

	public String getProcessor() {
		return processor;
	}

	public String getGraphicsCard() {
		return graphicsCard;
	}

	public int getRamSize() {
		return ramSize;
	}

	public int getHardDriveSize() {
		return hardDriveSize;
	}
}
