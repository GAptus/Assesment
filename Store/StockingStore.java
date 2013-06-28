package Store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StockingStore {
	
	public ArrayList<Product> readItemsFromFile(String filename, String productType) {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Product> linesFromFile = new ArrayList<Product>();
		
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.err.println("The file name entered does not exist or is in the wrong directory");
		}
		finally {
			try {
				while (br.readLine() != null) {
					String lineRead = br.readLine();
					String[] parts = lineRead.split(",");
					
					try {
						linesFromFile.add(createProducts(parts, productType));
					} catch (ProductDoesNotExistException e) {
						System.err.println("The type of Product entered is either incorrect or does not exist!");
					}

				}
				
				br.close();
				fr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		return linesFromFile;
	}
	
	private Product createProducts(String[] p, String productType) throws ProductDoesNotExistException {
		if (productType.equals("Desktop")) {
			try {
				return new Desktop(p[0], p[1], Double.parseDouble(p[2]), Integer.parseInt(p[3])
							, p[4], p[5], Integer.parseInt(p[6]), Integer.parseInt(p[6]));
			} catch (NumberFormatException e) {
				System.err.println("Problem with Desktop file! Check the numbers!");
			}
		}
		if (productType.equals("Laptop")) {
			try {
				return new Laptop(p[0], p[1], Double.parseDouble(p[2]),p[3], Double.parseDouble(p[4]), Double.parseDouble(p[5]), Integer.parseInt(p[6]), Integer.parseInt(p[7]), p[8]);
			} catch (NumberFormatException e) {
				System.err.println("Problem with the Laptop file! Check the numbers!");
			}
		}
		if (productType.equals("Monitor")) {
			try {
				return new Monitor(p[0], p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]), p[4], p[5], Integer.parseInt(p[6]));
			} catch (NumberFormatException e) {
				System.err.println("Problem with Monitor file! Check the numbers!");
			}
		}
		if (productType.equals("Mouse"))  {
			try {
				return new Mouse(p[0], p[1],Double.parseDouble(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4]), p[5]);
			} catch (NumberFormatException e) {
				System.err.println("Problem with Mouse file! Check the numbers!");
			}
		}
		if (productType.equals("Keyboard")) {
			try {
				return new Keyboard(p[0], p[1], Double.parseDouble(p[2]), p[3], p[4]);
			} catch (NumberFormatException e) {
				System.err.println("Problem with Keyboard file! Check the numbers!");
			}
		}
		throw new ProductDoesNotExistException();
	}
}
