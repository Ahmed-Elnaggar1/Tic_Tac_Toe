/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class OState implements CellState {

    @Override
    public void changeState(Cell c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayState() {
        System.out.println("O STATE");
    }

    @Override
    public boolean notEquals(CellState state) {
        return getClass() != state.getClass();
    }

    @Override
    public String tostring() {
        return "O";
    }
    
}
