/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class XOFlyWeight {
    private static HashMap<Character, CellState> hm;

    public XOFlyWeight() {
        hm = new HashMap<Character, CellState>();
    }

    public CellState getState(char State) {
        if (!hm.containsKey(State)) {
            hm.put(State, StateFactory.getState(State));
        }
        return hm.get(State);
    }
}
