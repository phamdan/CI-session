package game;

import scene.SceneManager;
import scene.SceneWelcome;

import java.awt.*;
import javax.swing.*;

public class GameCanvas extends JPanel{
    public GameCanvas() {
        //GameObject.addGameObject(new Background());
        //GameObject.recycle(Background.class);
        //GameObject.addGameObject(new Player());
        //GameObject.recycle(Player.class);
        //System.out.println(GameObject.recycle(Player.class).getClass());
        //GameObject.addGameObject(new Enemy());
        //GameObject.recycle(EnemySummoner.class);
        //GameObject.recycle()
        SceneManager.signNewScene(new SceneWelcome());
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
