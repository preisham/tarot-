package tarot;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomImageDisplay extends JFrame {
	  private ArrayList<ImageIcon> tarotCards;
	    private JLabel imageLabel;
	    private JButton displayButton;
	 public RandomImageDisplay() {
	    	tarotCards = new ArrayList<>();

	        for (int i = 1; i <= 22; i++) {
	            String imagePath = "/Users/preisham/eclipse-workspace/tarot/images/Tarot!/" + "T" + i + ".jpg"; 
	            ImageIcon image = new ImageIcon(imagePath);
	            tarotCards.add(image);
	        }

	    
	        setTitle("tarot!");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());
	        imageLabel = new JLabel();
	        imageLabel.setBackground(Color.WHITE);
	        displayButton = new JButton("draw");
	        displayButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                displayRandomImage();
	            }
	        });

	        add(imageLabel);
	        add(displayButton);
	    }
	 private void displayRandomImage() {
	        if (!tarotCards.isEmpty()) {
	            // Select a random image from the ArrayList
	            Random rand = new Random();
	            int randomIndex = rand.nextInt(tarotCards.size());
	            ImageIcon randomImage = tarotCards.get(randomIndex);

	            // Display the random image
	            imageLabel.setIcon(randomImage);
	            pack(); // Adjust the frame size to fit the image
	        }
	    }

}
