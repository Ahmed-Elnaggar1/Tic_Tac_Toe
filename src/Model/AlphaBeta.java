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
public class AlphaBeta implements Algorithms {

    private static double maxPly;

    /**
     * Execute the algorithm.
     *
     * @param player the player that the AI will identify as
     * @param board the Tic Tac Toe board to play on
     * @param maxPly the maximum depth
     */
    @Override
    public void run(CellState player, IBoard board, double maxPly) {
        if (maxPly < 1) {
            throw new IllegalArgumentException("Maximum depth must be greater than 0.");
        }

        AlphaBeta.maxPly = maxPly;
        alphaBetaPruning(player, board, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
    }

    /**
     * The meat of the algorithm.
     *
     * @param player the player that the AI will identify as
     * @param board the Tic Tac Toe board to play on
     * @param alpha the alpha value
     * @param beta the beta value
     * @param currentPly the current depth
     * @return the score of the board
     */
    private static int alphaBetaPruning(CellState player, IBoard board, double alpha, double beta, int currentPly) {
        if (currentPly++ == maxPly || board.isGameOver()) {
            return score(player, board);
        }

        if (board.getPlayerTurn() == player) {
            return getMax(player, board, alpha, beta, currentPly);
        } else {
            return getMin(player, board, alpha, beta, currentPly);
        }
    }

    /**
     * Play the move with the highest score.
     *
     * @param player the player that the AI will identify as
     * @param board the Tic Tac Toe board to play on
     * @param alpha the alpha value
     * @param beta the beta value
     * @param currentPly the current depth
     * @return the score of the board
     */
    private static int getMax(CellState player, IBoard board, double alpha, double beta, int currentPly) {
        int indexOfBestMove = -1;

        for (Integer theMove : board.getMovesAvailable()) {

            IBoard modifiedBoard = board.Copy(board);
            XOEngine.getInstance().move(theMove, modifiedBoard);
            int score = alphaBetaPruning(player, modifiedBoard, alpha, beta, currentPly);

            if (score > alpha) {
                alpha = score;
                indexOfBestMove = theMove;
            }

            // Pruning.
            if (alpha >= beta) {
                break;
            }
        }

        if (indexOfBestMove != -1) {
            XOEngine.getInstance().move(indexOfBestMove, board);
        }
        return (int) alpha;
    }

    /**
     * Play the move with the lowest score.
     *
     * @param player the player that the AI will identify as
     * @param board the Tic Tac Toe board to play on
     * @param alpha the alpha value
     * @param beta the beta value
     * @param currentPly the current depth
     * @return the score of the board
     */
    private static int getMin(CellState player, IBoard board, double alpha, double beta, int currentPly) {
        int indexOfBestMove = -1;

        for (Integer theMove : board.getMovesAvailable()) {

            IBoard modifiedBoard = board.Copy(board);
            XOEngine.getInstance().move(theMove, modifiedBoard);

            int score = alphaBetaPruning(player, modifiedBoard, alpha, beta, currentPly);

            if (score < beta) {
                beta = score;
                indexOfBestMove = theMove;
            }

            // Pruning.
            if (alpha >= beta) {
                break;
            }
        }

        if (indexOfBestMove != -1) {
            XOEngine.getInstance().move(indexOfBestMove, board);
        }
        return (int) beta;
    }

    /**
     * Get the score of the board.
     *
     * @param player the play that the AI will identify as
     * @param board the Tic Tac Toe board to play on
     * @return the score of the board
     */
    private static int score(CellState player, IBoard board) {
        if (player instanceof EmptyState) {
            throw new IllegalArgumentException("Player must be X or O.");
        }
        CellState opponent = (player instanceof XState) ? StateFactory.getState('O') : StateFactory.getState('X');

        if (board.isGameOver() && board.getWinner() == player) {
            return 10;
        } else if (board.isGameOver() && board.getWinner() == opponent) {
            return -10;
        } else {
            return 0;
        }
    }

}
