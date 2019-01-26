package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isAnyKeyPress;

    public static void mouseClick(Vector2D mousePosition) {
        System.out.println("clicked" + mousePosition);
    }

    public GameWindow(){
        this.setTitle("Touhou");
//        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                isAnyKeyPress=true;
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                isAnyKeyPress=false;
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = false;
                }
            }
        });
        GameWindow window = this;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Vector2D mousePosition = new Vector2D(e.getX() - window.getInsets().left
                        , e.getY() - window.getInsets().top);
                mouseClick(mousePosition);
            }
        });
    }
}
