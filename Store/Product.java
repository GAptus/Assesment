package Store;

public abstract class Product {
	
	private String productNumber;
	private String productName;
	private double productPrice;
	
	Product(String productNumber, String productName, double productPrice) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}
	
	public abstract String getDescription();
}
