/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Move;
import Controller.XOEngine;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class Defensive implements Algorithms {

    @Override
    public void run(CellState player, IBoard board, double maxPly) {
        IBoard modifiedBoard = board.Copy(board);
        modifiedBoard.setPlayerTurn(StateFactory.getState('X'));
        boolean flag = false;
        for(int i = 0 ; i<IBoard.BOARD_WIDTH;i++)
        {
            for(int j=0; j<IBoard.BOARD_HEIGHT;j++)
            {
                if(board.getBoardStates()[i][j] instanceof EmptyState)
                {
                   XOEngine.getInstance().move(new Move(i,j), modifiedBoard);
                   if(modifiedBoard.isGameOver())
                   {
                       XOEngine.getInstance().move(new Move(i,j), board);
                       flag=true;
                       break;
                   }
                   board.getBoardStates()[i][j].displayState();
                   board.getBoardStates()[i][j] = StateFactory.getState('E');
                   board.getBoardStates()[i][j].displayState();
                }
            }
            if(flag==true)
            {
                break;
            }
        }
        if(flag == false)
        {
            new RandomStrategy().run(player, board, maxPly);
        }
        
    }
    
}
