package View;

import javax.swing.*;
import java.awt.*;
 

public class test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           /* JFrame frame = new JFrame("Centered Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(10, 10, 10, 10); // Insets for padding

            // Add buttons with horizontal center alignment
            JButton button1 = new JButton("Button 1");
            button1.setPreferredSize(new Dimension(150, 50)); // Set preferred size
            panel.add(button1, gbc);
            JButton button2 = new JButton("Button 2");
            button2.setPreferredSize(new Dimension(150, 50)); // Set preferred size
            panel.add(button2, gbc);
            JButton button3 = new JButton("Button 3");
            button3.setPreferredSize(new Dimension(150, 50)); // Set preferred size
            panel.add(button3, gbc);

            // Center the buttons vertically
            panel.add(Box.createVerticalGlue(), gbc);

            // Set preferred size for the panel
            panel.setPreferredSize(new Dimension(500, 500)); // Adjust dimensions as needed

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);*/
           PlayerModeScreen m = new PlayerModeScreen();
           //LevelScreen l = new LevelScreen();
        });
    }
}
