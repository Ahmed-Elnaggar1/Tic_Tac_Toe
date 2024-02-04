/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Stack;

/**
 *
 * @author es-ahmedalizakaryah2
 */
public class CareTaker {
     private static final Stack<IBoard> stack = new Stack<>();
    
    public static void save(IBoard memento) {
      stack.push(memento);
  }

  public static void restore() {
       stack.pop();
  }
  
  public static IBoard getPeak()
  {
      return stack.peek();
  }
    
}
