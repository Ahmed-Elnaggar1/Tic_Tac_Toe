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
public class RandomStrategy implements Algorithms {

    @Override
    public void run(CellState player, IBoard board, double maxPly) {
        int[] moves = new int[board.getMovesAvailable().size()];
        int index = 0;

        for (Integer item : board.getMovesAvailable()) {
            moves[index++] = item;
        }

        int randomMove = moves[new java.util.Random().nextInt(moves.length)];
        XOEngine.getInstance().move(randomMove, board);
    }

}
