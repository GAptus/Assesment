package Store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StoreImpl implements Store {
	
	private List<Product> productsForSale = new ArrayList<Product>();
	
	public StoreImpl() {
		stock();
	}
	
	private void stock() {
		StockingStore stockMyStore = new StockingStore();
		
		productsForSale.addAll(stockMyStore.readItemsFromFile("Desktops", "Desktop"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Keyboards", "Keyboard"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Laptops", "Laptop"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Mice", "Mouse"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Monitors", "Monitor"));
	}
	
	public ArrayList<String> findProductsByOption(String option) throws ProductDoesNotExistException {
		if (option.equals("Desktops")) {
			System.out.println(displayDesktops().size());
			return displayDesktops();
		}
		if (option.equals("Laptops")) {
			return displayLaptops();
		}
		if (option.equals("Monitors")) {
			return displayMonitors();
		}
		if (option.equals("Keyboards")) {
			return displayKeyboards();
		}
		if (option.equals("Mice")) {
			return displayMice();
		}
		if (option.equals("All")) {
			return displayAllProducts();
		}
		else {
			throw new ProductDoesNotExistException();
		}
	}
	
	public ArrayList<String> searchKeyword(String keyword) throws ProductDoesNotExistException {
		ArrayList<String> productsByKeyword = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p.getDescription().contains(keyword)) {
				productsByKeyword.add(p.getDescription());
			}
		}
		
		if (productsByKeyword.size() == 0) {
			throw new ProductDoesNotExistException();
		}
		
		return productsByKeyword;
	}
	
	private ArrayList<String> displayAllProducts() {
		
		ArrayList<String> allProducts = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			allProducts.add(p.getDescription());
		}
		
		return allProducts;
	}

	private ArrayList<String> displayMonitors() {
		
		ArrayList<String> allMonitor = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Monitor) {
				Monitor m = (Monitor) p;
				allMonitor.add(m.getDescription());
			}
		}
		
		return allMonitor;
	}

	private ArrayList<String> displayLaptops() {
		
		ArrayList<String> allLaptops = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Laptop) {
				Laptop l = (Laptop) p;
				allLaptops.add(l.getDescription());
			}
		}
		
		return allLaptops;
	}

	private ArrayList<String> displayDesktops() {
		
		ArrayList<String> allDesktops = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Desktop) {
				Desktop d = (Desktop) p;
				allDesktops.add(d.getDescription());
			}
		}
		
		return allDesktops;
	}

	private ArrayList<String> displayKeyboards() {
		
		ArrayList<String> allKeyboards = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Keyboard) {
				Keyboard k = (Keyboard) p;
				allKeyboards.add(k.getDescription());
			}
		}
		
		return allKeyboards;
	}

	private ArrayList<String> displayMice() {
		
		ArrayList<String> allMice = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Mouse) {
				Mouse m = (Mouse) p;
				allMice.add(m.getDescription());
			}
		}
		
		return allMice;
	}
	
	private Product searchByProductNumber(String productNumber) throws ProductDoesNotExistException {
			for (Product p : productsForSale) {
				if (p.getProductNumber().equals(productNumber)) {
					return p;
				}
			}
			throw new ProductDoesNotExistException();
	}
	
	class Basket implements CheckoutBasket {
		List<Product> basketList = new ArrayList<Product>();

		public void addToBasket(Product p) {
			basketList.add(p);
		}

		public void checkoutBasket() throws IOException {
			FileWriter fw = new FileWriter("Receipt");
			
			for (Product p : basketList) {
				fw.write(p.getProductName() + "   " + p.getProductPrice());
			}
			
			fw.close();
		}

		public boolean removeFromBasket(Product p) {
			
			for (Product removeP : basketList) {
				if (p.equals(removeP)) {
					basketList.remove(removeP);
					return true;
				}
			}
			return false;
		}
		
		
	}
}
