/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.IBoard;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class Move {
    private int x;
    private int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param index
     */
    public Move(int index)
    {
        this(index%IBoard.BOARD_WIDTH, index/IBoard.BOARD_WIDTH);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
