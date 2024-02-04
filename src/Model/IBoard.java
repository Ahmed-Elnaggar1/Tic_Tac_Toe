/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Controller.Move;
import java.util.HashSet;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public interface IBoard {

    public static final int BOARD_WIDTH = 3;
    public static final int BOARD_HEIGHT = 3;

    public int getXScore();

    public void setXScore(int XScore);

    public int getOScore();

    public void setOScore(int OScore);

    public Move getNextMove();

    public IBoard Copy(IBoard board);

    public void setNextMove(Move nextMove);

    public CellState[][] getBoardStates();

    public void setBoardStates(CellState[][] BoardStates);

    public CellState getPlayerTurn();

    public void setPlayerTurn(CellState PlayerTurn);

    public CellState getWinner();

    public void setWinner(CellState winner);

    public int getMoveCount();

    public void setMoveCount(int moveCount);

    public boolean isGameOver();

    public void setGameOver(boolean GameOver);

    public HashSet<Integer> getMovesAvailable();

    public void setMovesAvailable(HashSet<Integer> movesAvailable);
    //public void setStatus();
    public String getStaus();
}
