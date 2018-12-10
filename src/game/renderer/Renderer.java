package game.renderer;

import game.GameObject;

import java.awt.*;

public abstract class Renderer {
    public abstract void render(Graphics g, GameObject master);
}
