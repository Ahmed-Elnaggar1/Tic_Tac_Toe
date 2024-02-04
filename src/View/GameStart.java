package View;

import javax.swing.*;
import java.awt.*;
 

public class GameStart {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           PlayerModeScreen m = new PlayerModeScreen();
        });
    }
}
