package game.player;

import game.GameObject;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        this.position.addThis(0, -3);
    }
}
