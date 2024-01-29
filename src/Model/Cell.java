/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class Cell {
    private CellState State;
    public Cell()
    {
        State = new EmptyState();
    }
    
    public void setState(CellState State)
    {
        this.State = State;
    }
    
    public void display() {
        State.displayState();
    }
}
