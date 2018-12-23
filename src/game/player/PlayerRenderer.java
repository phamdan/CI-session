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
    boolean blind;

    public PlayerRenderer(String text
            , ArrayList<BufferedImage> images) {
        this.textRenderer = new TextRenderer(text);
        this.animation = new AnimationRenderer(images);
        this.blind=false;
    }

    @Override
    public void render(Graphics g, GameObject master) {
//        this.textRenderer.render(g, master);
        Player player=(Player) master;
        if(player.immune){
            if(this.blind){
                this.animation.render(g,master);
            }
            this.blind=!this.blind;
        }else {
            this.animation.render(g, master);
        }
    }
}
