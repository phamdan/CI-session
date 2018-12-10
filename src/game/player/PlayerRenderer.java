package game.player;

import game.GameObject;
import game.renderer.AnimationRenderer;
import game.renderer.Renderer;
import game.renderer.TextRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerRenderer extends Renderer {
    Renderer textRenderer;
    Renderer animation;
    public PlayerRenderer(String text
            , ArrayList<BufferedImage> images) {
        this.textRenderer = new TextRenderer(text);
        this.animation = new AnimationRenderer(images);
    }

    @Override
    public void render(Graphics g, GameObject master) {
//        this.textRenderer.render(g, master);
        this.animation.render(g, master);
    }
}
