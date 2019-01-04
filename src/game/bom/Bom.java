package game.bom;

import game.FrameCounter;
import game.GameObject;
import game.GameObjectPhysics;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Bom extends GameObjectPhysics {
    FrameCounter bomCounter;
    public Bom(){
        super();
        this.createRenderer();
        this.bomCounter=new FrameCounter(60);
    }

    @Override
    public void run() {
        super.run();
        if(this.bomCounter.run()){
            this.bomBang();
            this.bomCounter.reset();
        }
    }

    private void bomBang() {
        this.destroy();
        this.bomBangBang();
    }

    private void bomBangBang() {
        BombBangRight bombBangRight= GameObject.recycle(BombBangRight.class);
        BombBangLeft bombBangLeft=GameObject.recycle(BombBangLeft.class);
        BombBangUp bombBangUp=GameObject.recycle(BombBangUp.class);
        BombBangDown bombBangDown=GameObject.recycle(BombBangDown.class);
        bombBangUp.position.set(this.position.x,this.position.y-90+45);
        bombBangUp.anchor.set(0,0);
        bombBangDown.position.set(this.position);
        bombBangDown.anchor.set(0,0);
        bombBangLeft.position.set(this.position.x-90+45,this.position.y);
        bombBangLeft.anchor.set(0,0);
        bombBangRight.position.set(this.position);
        bombBangRight.anchor.set(0,0);
    }


    private void createRenderer() {
        BufferedImage images ;
        images= SpriteUtils.loadImage("assets/images/background/bomb.png");
        this.renderer = new SingleImageRenderer(images);
    }

}
