/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Move;
import Controller.XOEngine;
import Model.Algorithms;
import Model.IBoard;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class GamePanel extends JPanel {
    private BufferedImage boardImage; // Image for the board
    private BufferedImage xImage; // Image for X
    private BufferedImage oImage; // Image for O
    private IBoard board;

    public IBoard getBoard() {
        return board;
    }
    public void loadImages()
    {
        try {
            File file = new File("src/Utils/background.png");
            File file2 = new File("src/Utils/x.png");
            File file3 = new File("src/Utils/o.png");

            boardImage = ImageIO.read(file); // Load your board image here
            xImage = ImageIO.read(file2); // Load your X image here
            oImage = ImageIO.read(file3); // Load your O image here
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ASD ASDASDASD");
        }
    }
    public GamePanel(IBoard board,Algorithms algo)
    {
        this.board =board;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int mouseX = e.getX();
                int mouseY = e.getY();

                // Determine the cell based on the mouse coordinates
                int cellWidth = getWidth() / 3;
                int cellHeight = getHeight() / 3;
                int row = mouseY / cellHeight;
                int col = mouseX / cellWidth;
                Move move = new Move(row,col);
                board.setNextMove(move);
                XOEngine engine = XOEngine.getInstance();
                if(engine.move(board.getNextMove(), board))
                {
                    if(algo!= null)
                    {
                        algo.run(board.getPlayerTurn(), board, Double.POSITIVE_INFINITY);
                    }
                }
                repaint();
            }
        });
    }
    public GamePanel(IBoard board)
    {
        this(board,null);
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the board image
        if (boardImage != null) {
            g.drawImage(boardImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Draw X and O images based on the board state
        if (xImage != null && oImage != null) {
            int cellWidth = getWidth() / 3;
            int cellHeight = getHeight() / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getBoardStates()[i][j].tostring().equals("X")) {
                        g.drawImage(xImage, j * cellWidth, i * cellHeight, cellWidth, cellHeight, this);
                    } else if (board.getBoardStates()[i][j].tostring().equals("O")) {
                        g.drawImage(oImage, j * cellWidth, i * cellHeight, cellWidth, cellHeight, this);
                    }
                }
            }
        }
    }
}

