package Store;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Store {
	
	public ArrayList<String> searchKeyword(String keyword) throws ProductDoesNotExistException;
	
	public ArrayList<String> findProductsByOption(String option) throws ProductDoesNotExistException;
	
}
