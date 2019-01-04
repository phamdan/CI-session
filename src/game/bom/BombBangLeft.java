package game.bom;

import game.FrameCounter;
import game.GameObjectPhysics;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BombBangLeft extends GameObjectPhysics {
    public static final int SizeBomBang=90;
    FrameCounter limitTime;
    public BombBangLeft(){
        super();
        this.createRenderer();
        this.limitTime=new FrameCounter(60);
    }

    private void createRenderer() {
        BufferedImage image;
        image= SpriteUtils.loadImage("assets/images/background/bombbang_left_1.png");
        this.renderer=new SingleImageRenderer(image);
    }

    @Override
    public void run() {
        super.run();
        if(limitTime.run()){
            this.destroy();
            limitTime.reset();
        }
    }
}
