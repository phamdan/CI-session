package game.player;

import game.GameCanvas;
import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.AnimationRenderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    public Player(){
        super();
        this.position.set(200, 300);
        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
//        this.renderer = new AnimationRenderer(images);
        this.renderer = new PlayerRenderer("Player", images);
    }

    int count = 0;
    @Override
    public void run() {
        if(GameWindow.isUpPress) {
            this.position.addThis(0, -10);
        }
        if(GameWindow.isDownPress) {
            this.position.addThis(0, 10);
        }
        if(GameWindow.isLeftPress) {
            this.position.addThis(-10, 0);
        }
        if(GameWindow.isRightPress) {
            this.position.addThis(10, 0);
        }
        this.limitPlayerPosition();
        count++;
        if(count > 20) {
            this.fire();
        }
    }

    private void fire() {
        if(GameWindow.isFirePress) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            GameObject.addGameObject(bullet);
            count = 0;
        }
    }

    private void limitPlayerPosition() {
        int halfWidth = (int)(Settings.PLAYER_WIDTH
                * this.anchor.x);
        int halfHeight = (int)(Settings.PLAYER_HEIGHT
                * this.anchor.y);

        float x = (float)Mathx.clamp(this.position.x
                , halfWidth
                , Settings.BACKGROUND_WIDTH - halfWidth);
        float y = (float)Mathx.clamp(this.position.y
                , halfHeight
                , Settings.SCREEN_HEIGHT - halfHeight);

        this.position.set(x, y);
    }
}
