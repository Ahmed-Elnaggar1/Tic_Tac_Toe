/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public interface CellState {
    public void changeState(Cell c);
    public void displayState();
    public boolean notEquals(CellState state);
    public String tostring();
}
