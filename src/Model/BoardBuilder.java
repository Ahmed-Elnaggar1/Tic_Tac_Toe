/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class BoardBuilder implements IBoardBuilder {

    @Override
    public IBoard initiallizeBoard() {
        IBoard board = new Board();
        XOFlyWeight state = new XOFlyWeight();
        for (int row = 0; row < Board.BOARD_WIDTH; row++) {
            for (int col = 0; col < Board.BOARD_HEIGHT; col++) {
                board.getBoardStates()[row][col] = state.getState('E');
            }
        }

        board.getMovesAvailable().clear();

        for (int i = 0; i < Board.BOARD_WIDTH * Board.BOARD_WIDTH; i++) {
            board.getMovesAvailable().add(i);
        }
        board.setGameOver(false);
        board.setMoveCount(0);
        board.setPlayerTurn(state.getState('X'));
        board.setWinner(state.getState('E'));
        board.setXScore(0);
        board.setOScore(0);
        return board;
    }

    @Override
    public void reset(IBoard board) {
        //IBoard board = new Board();
        XOFlyWeight state = new XOFlyWeight();
        for (int row = 0; row < Board.BOARD_WIDTH; row++) {
            for (int col = 0; col < Board.BOARD_HEIGHT; col++) {
                board.getBoardStates()[row][col] = state.getState('E');
            }
        }

        board.getMovesAvailable().clear();

        for (int i = 0; i < Board.BOARD_WIDTH * Board.BOARD_WIDTH; i++) {
            board.getMovesAvailable().add(i);
        }
        board.setGameOver(false);
        board.setMoveCount(0);
        board.setPlayerTurn(state.getState('X'));
        board.setWinner(state.getState('E'));
    }

}
