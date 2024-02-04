/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class EmptyState implements CellState {

    @Override
    public void changeState(Cell c) {
        
    }

    @Override
    public void displayState() {
        System.out.println("Empty STATE");
    }

    @Override
    public boolean notEquals(CellState state) {
        return true;
    }

    @Override
    public String tostring() {
        return "Empty"; 
    }
    
}
