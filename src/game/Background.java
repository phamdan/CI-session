package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets\\images\\background\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, 600 - image.getHeight());
        this.anchor.set(0, 0);
    }

    @Override
    public void run() {
        if(this.position.y < 0) {
            // this.position.y += 10 // thay doi Vector ko o Vector
            this.position.addThis(0, 1);
        } else {
            // this.y = 0
            this.position.set(this.position.x, 0);
        }
    }
}
