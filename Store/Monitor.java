package Store;

public class Monitor extends Product {
	
	private String description;
	private double screenSize;
	private String resolution;
	private String aspectRatio;
	private int numUSBPorts;
	
	public Monitor(String number, String name, double price, double screenSize, String resolution, String aspectRatio, int numUSBPorts) {
		super(number, name, price);
		this.screenSize = screenSize;
		this.resolution = resolution;
		this.aspectRatio = aspectRatio;
		this.numUSBPorts = numUSBPorts;
		this.description = "Product Number: " + super.getProductNumber() + "\n"
							+ super.getProductName() + "--------" + super.getProductPrice() + "\n"
							+ "Screen size(inches): " + screenSize + "\n"
							+ "Resolution: " + resolution + "\n"
							+ "Aspect ration: " + aspectRatio + "\n"
							+ "Number of USB ports: " + numUSBPorts;
	}
	
	public String toString() {
		return super.getProductNumber() + "," + super.getProductName() + "," + super.getProductPrice() + "," + screenSize + "," + resolution
				 + "," + aspectRatio + "," + numUSBPorts;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getScreenSize() {
		return screenSize;
	}

	public String getResolution() {
		return resolution;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public int getNumUSBPorts() {
		return numUSBPorts;
	}
}
