/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Move;
import java.util.HashSet;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class Board implements IBoard {

    private CellState[][] BoardStates;
    private CellState PlayerTurn;
    private CellState winner;
    private int moveCount = 0;
    private boolean GameOver;
    private HashSet<Integer> movesAvailable;
    private Move nextMove;
    private int XScore;
    private int OScore;

    public int getXScore() {
        return XScore;
    }

    public void setXScore(int XScore) {
        this.XScore = XScore;
    }

    public int getOScore() {
        return OScore;
    }

    public void setOScore(int OScore) {
        this.OScore = OScore;
    }

    public Move getNextMove() {
        return nextMove;
    }

    public void setNextMove(Move nextMove) {
        this.nextMove = nextMove;
    }

    public Board() {
        BoardStates = new CellState[BOARD_WIDTH][BOARD_HEIGHT];
        this.movesAvailable = new HashSet<>();
    }

    @Override
    public CellState[][] getBoardStates() {
        return BoardStates;
    }

    @Override
    public void setBoardStates(CellState[][] BoardStates) {
        this.BoardStates = BoardStates;
    }

    @Override
    public CellState getPlayerTurn() {
        return PlayerTurn;
    }

    @Override
    public void setPlayerTurn(CellState PlayerTurn) {
        this.PlayerTurn = PlayerTurn;
    }

    @Override
    public CellState getWinner() {
        return winner;
    }

    @Override
    public void setWinner(CellState winner) {
        this.winner = winner;
    }

    @Override
    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    @Override
    public boolean isGameOver() {
        return GameOver;
    }

    @Override
    public void setGameOver(boolean GameOver) {
        this.GameOver = GameOver;
    }

    @Override
    public HashSet<Integer> getMovesAvailable() {
        return movesAvailable;
    }

    @Override
    public void setMovesAvailable(HashSet<Integer> movesAvailable) {
        this.movesAvailable = movesAvailable;
    }

    @Override
    public IBoard Copy(IBoard board) {
        IBoard boardCopy = new Board();

        for (int i = 0; i < board.getBoardStates().length; i++) {
            boardCopy.getBoardStates()[i] = board.getBoardStates()[i].clone();
        }

        boardCopy.setPlayerTurn(board.getPlayerTurn());
        boardCopy.setWinner(board.getWinner());
        boardCopy.getMovesAvailable().addAll(board.getMovesAvailable());
        boardCopy.setMoveCount(board.getMoveCount());
        boardCopy.setGameOver(board.isGameOver());
        return boardCopy;
    }

    @Override
    public String getStaus() {
        return "X score : " + this.XScore +"      "+ "O score: " + this.OScore;
    }

}
