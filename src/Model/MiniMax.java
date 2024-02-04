/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.XOEngine;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class MiniMax implements Algorithms {

    private static double maxPly;

    @Override
    public void run(CellState player, IBoard board, double maxPly) {
        if (maxPly < 1) {
            throw new IllegalArgumentException("Maximum depth must be greater than 0.");
        }

        MiniMax.maxPly = maxPly;
        miniMax(player, board, 0);
    }
    /**
     * The meat of the algorithm.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int miniMax (CellState player, IBoard board, int currentPly) {
        if (currentPly++ == maxPly || board.isGameOver()) {
            return score(player, board);
        }

        if (board.getPlayerTurn() == player) {
            return getMax(player, board, currentPly);
        } else {
            return getMin(player, board, currentPly);
        }

    }

    /**
     * Play the move with the highest score.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMax (CellState player, IBoard board, int currentPly) {
        double bestScore = Double.NEGATIVE_INFINITY;
        int indexOfBestMove = -1;

        for (Integer theMove : board.getMovesAvailable()) {

            IBoard modifiedBoard = board.Copy(board);
            XOEngine.getInstance().move(theMove, modifiedBoard);

            int score = miniMax(player, modifiedBoard, currentPly);

            if (score >= bestScore) {
                bestScore = score;
                indexOfBestMove = theMove;
            }

        }
        XOEngine.getInstance().move(indexOfBestMove, board);
        return (int)bestScore;
    }

    /**
     * Play the move with the lowest score.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMin (CellState player, IBoard board, int currentPly) {
        double bestScore = Double.POSITIVE_INFINITY;
        int indexOfBestMove = -1;

        for (Integer theMove : board.getMovesAvailable()) {

            IBoard modifiedBoard = board.Copy(board);
            XOEngine.getInstance().move(theMove, modifiedBoard);

            int score = miniMax(player, modifiedBoard, currentPly);

            if (score <= bestScore) {
                bestScore = score;
                indexOfBestMove = theMove;
            }

        }

        XOEngine.getInstance().move(indexOfBestMove, board);
        return (int)bestScore;
    }

    /**
     * Get the score of the board.
     * @param player        the play that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @return              the score of the board
     */
    private static int score (CellState player, IBoard board) {
        if (player instanceof EmptyState) {
            throw new IllegalArgumentException("Player must be X or O.");
        }

        CellState opponent = (player instanceof XState) ? StateFactory.getState('O') : StateFactory.getState('X') ;

        if (board.isGameOver() && board.getWinner() == player) {
            return 10;
        } else if (board.isGameOver() && board.getWinner() == opponent) {
            return -10;
        } else {
            return 0;
        }
    }


}
