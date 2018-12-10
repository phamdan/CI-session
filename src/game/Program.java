package game;

import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GameCanvas gameCanvas = new GameCanvas();

//        gameCanvas.setSize(800, 600);
        gameCanvas.setPreferredSize(new Dimension(800, 600));
        gameWindow.add(gameCanvas);
        gameWindow.pack();
        gameWindow.setVisible(true);

        gameCanvas.gameLoop();
    }
}
