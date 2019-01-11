package game.background;

import game.GameObject;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public  Background(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/background_Play.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0,0);
        this.anchor.set(0, 0);
    }

}
