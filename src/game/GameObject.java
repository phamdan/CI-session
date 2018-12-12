package game;

import game.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects
            = new ArrayList<>();

    public static void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public static void runAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.run();
        }
    }
    public static <E extends GameObject> E createGameObject(Class<E> clazz){
        try {
            E newInstance = clazz.newInstance();
            addGameObject(newInstance);
            return newInstance; // new E()
            // E ~ Background, E ~ Player
        } catch(Exception ex) {
            return null;
        }
    }
    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.render(g);
        }
    }

    public Renderer renderer;
    public Vector2D position;
    public Vector2D anchor;
    public Vector2D velocity;
    public GameObject() {
        this.position = new Vector2D();
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.velocity=new Vector2D();
    }
    //logic
    public void run() {
        this.position.addThis(this.velocity);
    }

    //hien thi
    public void render(Graphics g) {
        if(this.renderer != null) {
            this.renderer.render(g, this);
        }
    }
}
