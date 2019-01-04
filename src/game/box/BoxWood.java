package game.box;

import game.GameObjectPhysics;
import game.renderer.SingleImageRenderer;
import physics.BoxCollider;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BoxWood extends GameObjectPhysics {
    public BoxWood(){
        super();
        this.createRenderer();
        this.boxCollider=new BoxCollider(this.position,this.anchor,30,30);
    }

    private void createRenderer() {
        BufferedImage images;
        images = SpriteUtils.loadImage("assets/images/background/wood.png");
        this.renderer = new SingleImageRenderer(images);
    }
}
