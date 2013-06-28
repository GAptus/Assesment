package Store;

import java.io.IOException;

public interface CheckoutBasket {
	
	public void addToBasket(Product p);
	
	public boolean removeFromBasket(Product p);
	
	public void checkoutBasket() throws IOException;
}
