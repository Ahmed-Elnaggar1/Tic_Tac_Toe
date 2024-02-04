/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.GameController;
import Model.Board;
import Model.BoardBuilder;
import Model.Defensive;
import Model.IBoard;
import Model.MiniMax;
import Model.RandomStrategy;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
        if ("Random Level".equals(text)) {
            button.addActionListener((ActionEvent e) -> {
                GameController control = new GameController(new GamePanel(new BoardBuilder().initiallizeBoard(),new RandomStrategy()),frame);
                frame.setVisible(false);
            });
        } else if ("Defensive Level".equals(text)) {
            button.addActionListener((ActionEvent e) -> {
                GameController control = new GameController(new GamePanel(new BoardBuilder().initiallizeBoard(),new Defensive()),frame);
                frame.setVisible(false);
            });
        } else if ("Smart Level".equals(text)) {
            button.addActionListener((ActionEvent e) -> {
                GameController control = new GameController(new GamePanel(new BoardBuilder().initiallizeBoard(),new MiniMax()),frame);
                frame.setVisible(false);
            });
        } else if ("Single Player".equals(text)) {
            button.addActionListener((ActionEvent e) -> {
                LevelScreen l = new LevelScreen(frame);
                l.Start();
                frame.setVisible(false);
            });
        } else if ("MultiPlayer".equals(text)) {
            button.addActionListener((ActionEvent e) -> {
                GameController control = new GameController(new GamePanel(new BoardBuilder().initiallizeBoard()),frame);
                frame.setVisible(false);
            });
        }
        button.setPreferredSize(new Dimension(150, 50));
        return button;
    }
}
