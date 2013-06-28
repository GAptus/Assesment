package Store;

import javax.swing.*;

public class StoreTest {
	
	public static void main(String[] args) {
	
		Store myStore = new StoreImpl();

	
		SwingBuilder myBuilder = new SwingBuilder();
		JFrame myFrame = myBuilder.buildWelcomeFrame();
		
		
	}
}
