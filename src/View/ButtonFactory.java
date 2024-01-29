/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class ButtonFactory {

    public static JButton createButton(JButton button, JFrame frame) {
        String text = button.getText();

        Font buttonFont = new Font("Blackadder ITC", Font.BOLD, 19);
        button.setFont(buttonFont);
        button.setPreferredSize(new Dimension(100, 100));
        button.setBackground(Color.PINK);
        if ("Easy Level".equals(text)) {
            button.addActionListener((ActionEvent e) -> {

            });
        } else if ("Medium Level".equals(text)) {
            button.addActionListener((ActionEvent e) -> {

            });
        } else if ("Hard Level".equals(text)) {
            button.addActionListener((ActionEvent e) -> {

            });
        } else if ("Single Player".equals(text)) {
            button.addActionListener((ActionEvent e) -> {

            });
        } else if ("MultiPlayer".equals(text)) {
            button.addActionListener((ActionEvent e) -> {

            });
        }
        button.setPreferredSize(new Dimension(150, 50));
        return button;
    }
}
