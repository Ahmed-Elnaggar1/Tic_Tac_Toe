/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BoardBuilder;
import Model.IBoard;
import View.GamePanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class GameController {

    private JFrame gameFrame, Parent;
    private static GamePanel gamePanel;
    private static JLabel statusBar;

    public GameController(GamePanel gamePanel, JFrame parent) {
        this.gamePanel = gamePanel;
        this.Parent = parent;
        statusBar = new JLabel();
        gamePanel.loadImages();
        gameFrame = new JFrame("Tic Tac Toe Game");
        statusBar.setText(gamePanel.getBoard().getStaus());
        gameFrame.add(statusBar, BorderLayout.SOUTH);
        gameFrame.getContentPane().add(gamePanel);
        gameFrame.setJMenuBar(this.createMenuBar());
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null); // Center the frame on the screen
        gameFrame.setVisible(true);
        gameFrame.setSize(500, 500);
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

    public static void updateStatus() {
        statusBar.setText(gamePanel.getBoard().getStaus());

    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Game");
        JMenuItem menuItem1 = new JMenuItem("New Game");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gameController.pause();
                gamePanel.setBoard(new BoardBuilder().initiallizeBoard());
            }
        });
        // Create the second menu item
        JMenuItem menuItem2 = new JMenuItem("Undo");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when Button 2 is clicked
                //JOptionPane.showMessageDialog(MenuBarExample.this, "Button 2 Clicked");
                //gameController.resume();
                gamePanel.undo();
            }
        });
        /*JMenuItem menuItem3 = new JMenuItem("New Game");
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when Button 2 is clicked
                //JOptionPane.showMessageDialog(MenuBarExample.this, "Button 2 Clicked");
                 //gameFrame.dispose();
                  //startGame();
            }
        });*/
        //Add menu items to the first menu
        // menu1.add(menuItem3);
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        // Add the first menu to the menu bar
        menuBar.add(menu1);
        // Set the menu bar for the JFrame
        //frame.setJMenuBar(menuBar);
        return menuBar;
    }
}
