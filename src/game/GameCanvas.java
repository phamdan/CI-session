package game;

import enemy.Enemy;
import game.player.Player;
import game.player.PlayerBullet;
import game.renderer.TextRenderer;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameCanvas extends JPanel{
    public GameCanvas() {
        //GameObject.addGameObject(new Background());
        GameObject.createGameObject(Background.class);
        //GameObject.addGameObject(new Player());
        GameObject.createGameObject(Player.class);
        //GameObject.addGameObject(new Enemy());
        GameObject.createGameObject(Enemy.class);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        GameObject.renderAll(g);
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void renderAll() {
        this.repaint(); // ~ paint()
    }

    public void gameLoop() {
        long lastTimeRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTimeRun > 1000 / 60) {
                runAll(); // logic game
                renderAll(); // hien thi game
                lastTimeRun = currentTime;
            }
        }
    }
}
