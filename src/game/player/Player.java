package game.player;

import enemy.Enemy;
import game.*;
import game.renderer.AnimationRenderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    FrameCounter fireCounter;
    public Player(){
        super();
        this.position.set(200, 300);
        this.createRenderer();
        this.fireCounter=new FrameCounter(20);
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
        //this.renderer = new AnimationRenderer(images);
        this.renderer = new PlayerRenderer("Player", images);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.limitPlayerPosition();
        if(fireCounter.run()) {
            this.fire();
        }
    }
    private  void move(){
        int vx=0;
        int vy=0;
        int speed=10;
        if(GameWindow.isUpPress) {
            vy--;
        }
        if(GameWindow.isDownPress) {
            //this.position.addThis(0, 10);
            vy++;
        }
        if(GameWindow.isLeftPress) {
            //this.position.addThis(-10, 0);
            vx--;
        }
        if(GameWindow.isRightPress) {
            //this.position.addThis(10, 0);
            vx++;
        }
        this.velocity.set(vx,vy);
        this.velocity.setLength(speed);
    }
    private void fire() {
        if(GameWindow.isFirePress) {
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position.x, this.position.y);
            this.fireCounter.reset();
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
