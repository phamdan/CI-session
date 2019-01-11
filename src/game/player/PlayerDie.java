package game.player;

import game.FrameCounter;
import game.GameObject;
import game.renderer.SingleImageRenderer;
import scene.SceneGameOver;
import scene.SceneManager;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class PlayerDie extends GameObject {
    FrameCounter time;
    public PlayerDie(){
        super();
        this.createRenderer();
        this.time=new FrameCounter(120);
    }

    private void createRenderer() {
        BufferedImage image= SpriteUtils.loadImage("assets/images/background/bomber_dead.png");
        this.renderer=new SingleImageRenderer(image);
    }

    @Override
    public void run() {
        super.run();
        if(this.time.run()){
            this.destroy();
            SceneManager.signNewScene(new SceneGameOver());
            this.time.reset();
        }
    }
}
