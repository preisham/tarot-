package tarot;

import javax.swing.*;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random; 
import java.util.Collections;



public class TarotGameGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel welcomePanel;
    private JPanel shufflePanel;
    private JPanel wheelPanel;
    private JPanel readingPanel;

    public TarotGameGUI() {
        setTitle("Tarot Game");
        setSize(875,990);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panels
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        welcomePanel = createWelcomePanel();
        shufflePanel = createShufflePanel();
        wheelPanel = createWheelPanel();
        readingPanel = createReadingPanel();

        mainPanel.add(welcomePanel, "welcome");
        mainPanel.add(shufflePanel, "shuffle");
        mainPanel.add(wheelPanel, "wheel");
        mainPanel.add(readingPanel, "reading");

        add(mainPanel);
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel();
        BorderLayout border = new BorderLayout(); 
        panel.setLayout(border);
       

        JLabel label = new JLabel("");

       ImageIcon img = new ImageIcon(this.getClass().getResource("/Frame 1.png")); 
       label.setIcon(img); 
       label.setBounds(120,50,100,100);
     
        JButton romance = new JButton("romance");
        JButton wellness = new JButton("wellness");
        JButton fortune = new JButton("fortune");
        
       romance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "shuffle");
        

            }
        });
       wellness.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               cardLayout.show(mainPanel, "shuffle");
           }
       });
       fortune.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               cardLayout.show(mainPanel, "shuffle");
           }
       });
    
       JPanel panel2 = new JPanel();
       panel2.setBackground(Color.WHITE);
       panel2.setSize(100,500);
       BorderLayout layout = new BorderLayout();
       layout.setHgap(100);
       layout.setVgap(100);
        panel.add(label, BorderLayout.PAGE_START);
        panel2.add(romance, BorderLayout.EAST);
        panel2.add(wellness, BorderLayout.CENTER);
        panel2.add(fortune, BorderLayout.WEST);
        panel.add(panel2);
        
        return panel;
    }

    private JPanel createShufflePanel() {
 
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Shuffling Tarot Cards...");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "wheel");
            }
            
        
        });

        panel.add(label, BorderLayout.CENTER);
        panel.add(shuffleButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createWheelPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // TODO: Add tarot card wheel and selection functionality

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "reading");
            }
        });

        panel.add(selectButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createReadingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // TODO: Add tarot card reading functionality

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "welcome");
             
            }
        });

        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TarotGameGUI game = new TarotGameGUI();
                game.setVisible(true);
            }
        });
    }
}
