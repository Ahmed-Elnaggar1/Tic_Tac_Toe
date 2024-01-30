/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.XOLogic;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class BoardSingleton {
    private static BoardSingleton instance = null;
    private final int[][] boardState ;
    private BoardSingleton()
    {
        boardState = new int[XOLogic.BOARD_WIDTH][XOLogic.BOARD_HEIGHT];
    }
    public static BoardSingleton getInstance()
    {
        if(instance == null)
        {
            instance = new BoardSingleton();
        }
        return instance;
    }
    public int[][] getBoard()
    {
        return this.boardState;
    }
}
