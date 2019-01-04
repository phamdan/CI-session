package game.bom;

import game.FrameCounter;
import game.GameObjectPhysics;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BombBangUp extends GameObjectPhysics {
    public static final int SizeBomBang=90;
    FrameCounter limitTime;
    public BombBangUp(){
        super();
        this.createRenderer();
        this.limitTime=new FrameCounter(60);
    }

    private void createRenderer() {
        BufferedImage image;
        image= SpriteUtils.loadImage("assets/images/background/bombbang_up_1.png");
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
