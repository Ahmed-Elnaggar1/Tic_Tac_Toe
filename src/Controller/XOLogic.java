/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BoardSingleton;
import Model.CellState;
import Model.OState;
import Model.XOFlyWeight;
import Model.XState;
import java.util.HashSet;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class XOLogic {

    private boolean gameOver = false;
    public static final int BOARD_WIDTH = 3;
    public static final int BOARD_HEIGHT = 3;
    private BoardSingleton Board = BoardSingleton.getInstance();
    private int[][] boardState;
    private CellState winner = null;
    private CellState PlayerTurn = new XState();
    private XOFlyWeight State = new XOFlyWeight();
    int moveCount = 0;
    public static HashSet<Integer> movesAvailable=new HashSet<>();

    public int getMoveCount() {
        return moveCount;
    }

    public CellState getWinner() {
        return winner;
    }
    private static XOLogic logic = null;
    private XOLogic()
    {
        
    }
    public static XOLogic getInstance()
    {
        if(logic == null)
        {
            logic = new XOLogic();
        }
        return logic;
    }
    public boolean move(int x, int y) {
        if (this.gameOver) {
            throw new IllegalStateException("TicTacToe is over. No moves can be played.");
        }
        boardState = Board.getBoard();
        if (boardState[x][y] != 0) {
            return false;
        }
        // Update the board state and repaint
        if (boardState[x][y] == 0 && PlayerTurn instanceof XState) {
            boardState[x][y] = 1; // Assuming player 1 is X
        } else if (boardState[x][y] == 0 && PlayerTurn instanceof OState) {
            boardState[x][y] = 2; // Assuming player 2 is O
        }
        this.movesAvailable.remove(y*BOARD_WIDTH+x);
        // Check for a winner.
        checkDiagonalTopRight(x, y, PlayerTurn);
        System.out.println(this.gameOver + " " + this.winner);
        checkDiagonalTopLeft(x, y, PlayerTurn);
        System.out.println(this.gameOver + " " + this.winner);
        checkColumn(PlayerTurn);
        System.out.println(this.gameOver + " " + this.winner);

        checkRow(PlayerTurn);
        System.out.println(this.gameOver + " " + this.winner);

        moveCount++;
        if (moveCount == BOARD_WIDTH * BOARD_HEIGHT) {
            gameOver = true;
        }
        PlayerTurn = (PlayerTurn instanceof XState) ? State.getState('O') : State.getState('X');
        return true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public CellState getPlayerTurn() {
        return PlayerTurn;
    }

    private void checkDiagonalTopRight(int x, int y, CellState Player) {
        for (int i = 1; i < BOARD_WIDTH; i++) {
            if ((boardState[BOARD_WIDTH - 1 - i][i] != boardState[BOARD_WIDTH - i][i - 1]) || boardState[BOARD_WIDTH - 1 - i][i] == 0) {
                break;
            }
            if (i == BOARD_WIDTH - 1) {
                winner = Player;
                gameOver = true;
            }
        }

    }

    private void checkDiagonalTopLeft(int x, int y, CellState Player) {
        for (int i = 1; i < BOARD_WIDTH; i++) {
            if (boardState[i][i] != boardState[i - 1][i - 1] || boardState[BOARD_WIDTH - 1 - i][i] == 0) {
                break;
            }
            if (i == BOARD_WIDTH - 1) {
                winner = Player;
                gameOver = true;
            }
        }
    }

    private void checkRow(CellState Player) {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int i = 1; i < BOARD_WIDTH; i++) {
                if (boardState[row][i] != boardState[row][i - 1] || boardState[row][i] == 0) {
                    break;
                }
                if (i == BOARD_WIDTH - 1) {
                    winner = Player;
                    gameOver = true;
                }
            }
        }

    }

    private void checkColumn(CellState Player) {
        for (int column = 0; column < BOARD_WIDTH; column++) {
            for (int i = 1; i < BOARD_WIDTH; i++) {
                if (boardState[i][column] != boardState[i - 1][column] || boardState[i][column] == 0) {
                    break;
                }
                if (i == BOARD_WIDTH - 1) {
                    winner = Player;
                    gameOver = true;
                }
            }
        }

    }

    public void initializeBoard() {
        for (int i = 0; i < BOARD_WIDTH * BOARD_WIDTH; i++) {
            movesAvailable.add(i);
        }
    }

    public static HashSet<Integer> getMovesAvailable() {
        return movesAvailable;
    }
}
