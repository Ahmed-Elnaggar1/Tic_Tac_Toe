/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class StateFactory {
    public static CellState getState(char State)
    {
        if(State == 'X')
        {
            return new XState();
        }
        else if (State == 'O')
        {
            return new OState();
        }
        else if (State == 'E')
        {
            return new EmptyState();
        }
        else 
        {
            return null;
        }
    }
}
