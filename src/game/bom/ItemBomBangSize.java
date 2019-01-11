package game.bom;

import game.FrameCounter;
import game.GameObjectPhysics;
import game.renderer.SingleImageRenderer;
import physics.BoxCollider;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemBomBangSize extends GameObjectPhysics {
    public ItemBomBangSize(){
        super();
        this.createRenderer();
        this.boxCollider=new BoxCollider(this.position,this.anchor,30,30);
    }

    private void createRenderer() {
        BufferedImage image;
        image= SpriteUtils.loadImage("assets/images/background/item_bombsize.png");
        this.renderer=new SingleImageRenderer(image);
    }

}
