/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.IBoard;
import View.GamePanel;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class GameController {

    JFrame gameFrame,Parent;
    GamePanel gamePanel;
    public GameController(GamePanel gamePanel,JFrame parent) {
        this.gamePanel = gamePanel;
        this.Parent = parent;
        gamePanel.loadImages();
        gameFrame = new JFrame("Tic Tac Toe Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().add(gamePanel);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null); // Center the frame on the screen
        gameFrame.setVisible(true);
         gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gameFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(gameFrame, "Are you sure you want to close this game?",
                        "End Game?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    gameFrame.dispose();
                    Parent.setVisible(true);
                }
            }
        });
        
    }
    
}
