package Store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SwingBuilder {
	
	Store store = new StoreImpl();
	
	JFrame welcomeFrame;
	JFrame indexFrame;
	JFrame searchFrame;
	JFrame displayFrame;
	JFrame keywordsFrame;
	
	public JFrame buildWelcomeFrame() {
		welcomeFrame = new JFrame("Welcome");
		JPanel welcomePanel = new JPanel();
		
		
		JLabel welcomeLabel = new JLabel("Welcome to the store!");
		JButton enterStoreButton = new JButton("Press to enter store!");
		
		enterStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomeFrame.dispose();
				buildIndexFrame();
			}
		});
		
		welcomePanel.add(welcomeLabel);
		welcomePanel.add(enterStoreButton);
		
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		welcomeFrame.getContentPane().add(welcomePanel);
		welcomeFrame.pack();
		welcomeFrame.setVisible(true);
		
		return welcomeFrame;
	}
	
	public JFrame buildIndexFrame() {
		indexFrame = new JFrame("Please pick a option!");
		
		JPanel indexPanel = new JPanel();
		final JTextField searchBox = new JTextField("Enter your keyword to search", 30);
		JButton searchButton = new JButton("Search");
		JButton displayAllButton = new JButton("Display all");
		String[] displayChoices = {"Desktops", "Laptops", "Monitors", "Keyboards", "Mice", "All"};
		final JComboBox<String> displayOptions = new JComboBox<String>(displayChoices);
		
		displayAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
				try {
					displaySelected(displayOptions.getSelectedItem().toString());
				} catch (ProductDoesNotExistException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
				displayKeywordResults(searchBox.getText());
			}
		});
		
		indexPanel.add(searchBox);
		indexPanel.add(searchButton);
		indexPanel.add(displayOptions);
		indexPanel.add(displayAllButton);
		
		indexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		indexFrame.setSize(200, 200);
		indexFrame.setVisible(true);
		
		indexFrame.getContentPane().add(indexPanel);
		
		return indexFrame;
	}
	
	public JFrame displaySelected(String option) throws ProductDoesNotExistException {
		displayFrame = new JFrame(option);
		JPanel displayPanel = new JPanel();
		final JButton returnToIndex = createReturnButton(displayFrame);
		
		ArrayList<String> tempStore = store.findProductsByOption(option);
		System.out.println(tempStore.size());
		
		for (int i = 0; i < tempStore.size(); i++) {
			displayPanel.add(new JLabel(tempStore.get(i)));
		}
		displayPanel.add(returnToIndex);
		
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.getContentPane().add(displayPanel);
		displayFrame.pack();
		displayFrame.setVisible(true);

		
		return displayFrame;
	}
	
	public JFrame displayKeywordResults(String keyword) {
		keywordsFrame = new JFrame("Search results for: " + keyword);
		JPanel keywordPanel = new JPanel();
		final JButton returnToIndex = createReturnButton(keywordsFrame);
		
		
		try {
			for (int i = 0; i < store.searchKeyword(keyword).size(); i++) {
				keywordPanel.add(new JLabel(store.searchKeyword(keyword).get(i)));
			}
		} catch (ProductDoesNotExistException e) {
			keywordPanel.add(new JLabel("Your entered keyword has produced no matches!"));
		}
		finally {
			keywordPanel.add(returnToIndex);
		}
		
		
		keywordsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keywordsFrame.getContentPane().add(keywordPanel);
		keywordsFrame.pack();
		keywordsFrame.setVisible(true);
		
		
		return keywordsFrame;
	}
	
	public JButton createReturnButton(final JFrame currentFrame) {
		JButton returnButton = new JButton("Return to index");
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				buildIndexFrame();
			}
		});
		
		return returnButton;
	}
	
}
