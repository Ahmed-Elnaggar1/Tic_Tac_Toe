/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class PlayerModeScreen {

    private JFrame playerModeFrame;
    private JPanel backgroundPanel;
    private JButton singlePlayerButton;
    private JButton multiPlayerButton;

    public PlayerModeScreen() {
        // Initializing variables
        playerModeFrame = new JFrame("Player Mode");
        backgroundPanel = new JPanel();
        singlePlayerButton = new JButton("Single Player");
        multiPlayerButton = new JButton("MultiPlayer");

        playerModeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        backgroundPanel.setLayout(new GridBagLayout());
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10); // Insets for padding

        ButtonFactory.createButton(singlePlayerButton, playerModeFrame);
        ButtonFactory.createButton(multiPlayerButton, playerModeFrame);
        
        // Add SinglePlayerButton
        backgroundPanel.add(singlePlayerButton, gbc);
        
        // Add MultiPlayerButton
        backgroundPanel.add(multiPlayerButton, gbc);
        
        // Set preferred size for the panel
        backgroundPanel.setPreferredSize(new Dimension(500, 500)); // Adjust dimensions as needed

        playerModeFrame.getContentPane().add(backgroundPanel);
        playerModeFrame.pack();
        playerModeFrame.setLocationRelativeTo(null); // Center the frame on the screen
        playerModeFrame.setVisible(true);
    }
}
