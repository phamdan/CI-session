package game.bom;

import game.FrameCounter;
import game.GameObjectPhysics;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BombBangRight extends GameObjectPhysics {
    public static final int SizeBomBang=90;
    FrameCounter limitTime;
    BufferedImage image;
    public BombBangRight(){
        super();
        this.createRenderer();
        this.limitTime=new FrameCounter(60);
    }

    private void createRenderer() {
        //BufferedImage image;
        this.image=SpriteUtils.loadImage("assets/images/background/bombbang_right_1.png");
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
