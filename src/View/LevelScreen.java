/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class LevelScreen {

    private JFrame levelFrame = new JFrame();
    private JPanel backgroundPanel;
    private JButton EasyBtn;
    private JButton MediumBtn;
    private JButton HardBtn;

    public LevelScreen() {
        // Initializing variables
        levelFrame = new JFrame("Levels");
        backgroundPanel = new JPanel();
        EasyBtn = new JButton("Easy Level");
        MediumBtn = new JButton("Medium Level");
        HardBtn = new JButton("Hard Level");

        levelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        backgroundPanel.setLayout(new GridBagLayout());
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10); // Insets for padding

        ButtonFactory.createButton(EasyBtn, levelFrame);
        ButtonFactory.createButton(MediumBtn, levelFrame);
        ButtonFactory.createButton(HardBtn, levelFrame);

        // Add Buttons
        backgroundPanel.add(EasyBtn, gbc);
        backgroundPanel.add(MediumBtn, gbc);
        backgroundPanel.add(HardBtn, gbc);

        // Set preferred size for the panel
        backgroundPanel.setPreferredSize(new Dimension(500, 500)); // Adjust dimensions as needed

        levelFrame.getContentPane().add(backgroundPanel);
        levelFrame.pack();
        levelFrame.setLocationRelativeTo(null); // Center the frame on the screen
        levelFrame.setVisible(true);
    }
}
