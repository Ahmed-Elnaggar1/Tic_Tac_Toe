package Controller;

import Model.CellState;
import Model.OState;
import Model.XState;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class XOControl extends JPanel {
    
    private final int SIZE =3; 
    private BufferedImage boardImage; // Image for the board
    private BufferedImage xImage; // Image for X
    private BufferedImage oImage; // Image for O
    CellState PlayerTurn = new XState();
    int movesAvailable = SIZE*SIZE;

    private int[][] boardState; // Representing the state of each cell: 0 for empty, 1 for X, 2 for O

    public XOControl() {
        // Load images (board, X, O)
        // Assuming you have board.png, x.png, and o.png in the same directory
        // Load the images using ImageIO.read() method

        // For demonstration purpose, I'll initialize them to null
        try {
            File file = new File("src/Utils/background.png");
            File file2 = new File("src/Utils/x.png");
            File file3 = new File("src/Utils/o.png");
            
            boardImage = ImageIO.read(file); // Load your board image here
            xImage = ImageIO.read(file2); // Load your X image here
            oImage = ImageIO.read(file3); // Load your O image here
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize the board state
        boardState = new int[3][3]; // 3x3 board

        // Add mouse listener
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

                // Update the board state and repaint
                if (boardState[row][col] == 0 && PlayerTurn instanceof XState) {
                    boardState[row][col] = 1; // Assuming player 1 is X
                    PlayerTurn = new OState();
                } else if (boardState[row][col] == 0 && PlayerTurn instanceof OState){
                    boardState[row][col] = 2; // Assuming player 2 is O
                    PlayerTurn = new XState();
                }
                repaint();
            }
        });
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
                    if (boardState[i][j] == 1) {
                        g.drawImage(xImage, j * cellWidth, i * cellHeight, cellWidth, cellHeight, this);
                    } else if (boardState[i][j] == 2) {
                        g.drawImage(oImage, j * cellWidth, i * cellHeight, cellWidth, cellHeight, this);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tic Tac Toe");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new XOControl());
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
        });
    }
}
