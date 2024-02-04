/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CellState;
import Model.EmptyState;
import Model.IBoard;
import Model.OState;
import Model.StateFactory;
import Model.XState;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class XOEngine {

    private static XOEngine instance = null;
    private XOEngine()
    {
//        instance = new XOEngine();
    }
    public static XOEngine getInstance()
    {
        if(instance == null)
        {
            instance = new XOEngine();
        }
        return instance;
    }
    public boolean move(Move move, IBoard board) {
        if (board.isGameOver()) {
            throw new IllegalStateException("TicTacToe is over. No moves can be played.");
        }
        // boardState = Board.getBoard();
        if (!isValidMove(move, board)) {
            return false;
        }
        // Update the board state and repaint
         if (board.getBoardStates()[move.getX()][move.getY()] instanceof EmptyState && board.getPlayerTurn() instanceof XState) {
            board.getBoardStates()[move.getX()][move.getY()] = StateFactory.getState('X'); // Assuming player 1 is X
        } else if (board.getBoardStates()[move.getX()][move.getY()] instanceof EmptyState && board.getPlayerTurn() instanceof OState) {
             board.getBoardStates()[move.getX()][move.getY()] = StateFactory.getState('O');// Assuming player 2 is O
        }
        board.getBoardStates()[move.getX()][move.getY()] = board.getPlayerTurn();
        board.getMovesAvailable().remove(move.getY() * IBoard.BOARD_WIDTH + move.getX());
        // Check for a winner.
        checkDiagonalTopRight(board);
        System.out.println(board.isGameOver() + " " + board.getWinner());
        checkDiagonalTopLeft(board);
        System.out.println(board.isGameOver() + " " + board.getWinner());
        checkColumn(board);
        System.out.println(board.isGameOver() + " " + board.getWinner());

        checkRow(board);
        System.out.println(board.isGameOver() + " " + board.getWinner());
        board.setMoveCount(board.getMoveCount() + 1);
        changeTurns(move, board);
        return true;
    }
    public boolean move(int index,IBoard board)
    {
        int x = index%IBoard.BOARD_WIDTH;
        int y = index/IBoard.BOARD_HEIGHT;
        return move(new Move(x,y),board);
    }

    private boolean isValidMove(Move move, IBoard board) {
        return board.getBoardStates()[move.getX()][move.getY()] instanceof EmptyState;
    }

    private void changeTurns(Move move, IBoard board) {
        if (board.getMoveCount() == IBoard.BOARD_WIDTH * IBoard.BOARD_HEIGHT) {
            board.setGameOver(true);
        }
        if (board.getPlayerTurn() instanceof XState) {
            board.setPlayerTurn(StateFactory.getState('O'));
        } else {
            board.setPlayerTurn(StateFactory.getState('X'));
        }
    }

    private void checkDiagonalTopRight(IBoard board) {
        for (int i = 1; i < IBoard.BOARD_WIDTH; i++) {
            if ((board.getBoardStates()[IBoard.BOARD_WIDTH - 1 - i][i].notEquals(board.getBoardStates()[IBoard.BOARD_WIDTH - i][i - 1]))) {
                break;
            }
            if (i == IBoard.BOARD_WIDTH - 1) {
                board.setWinner(board.getPlayerTurn());
                board.setGameOver(true);
            }
        }

    }

    private void checkDiagonalTopLeft(IBoard board) {
        for (int i = 1; i < IBoard.BOARD_WIDTH; i++) {
            if (board.getBoardStates()[i][i].notEquals(board.getBoardStates()[i - 1][i - 1])) {
                break;
            }
            if (i == IBoard.BOARD_WIDTH - 1) {
                board.setWinner(board.getPlayerTurn());
                board.setGameOver(true);
            }
        }
    }

    private void checkRow(IBoard board) {
        for (int row = 0; row < IBoard.BOARD_WIDTH; row++) {
            for (int i = 1; i < IBoard.BOARD_WIDTH; i++) {
                if (board.getBoardStates()[row][i].notEquals(board.getBoardStates()[row][i - 1])) {
                    break;
                }
                if (i == IBoard.BOARD_WIDTH - 1) {
                    board.setWinner(board.getPlayerTurn());
                    board.setGameOver(true);
                }
            }
        }

    }

    private void checkColumn(IBoard board) {
        for (int column = 0; column < IBoard.BOARD_WIDTH; column++) {
            for (int i = 1; i < IBoard.BOARD_WIDTH; i++) {
                if (board.getBoardStates()[i][column].notEquals(board.getBoardStates()[i - 1][column]) ) {
                    break;
                }
                if (i == IBoard.BOARD_WIDTH - 1) {
                    board.setWinner(board.getPlayerTurn()); 
                    board.setGameOver(true);
                }
            }
        }

    }

}
