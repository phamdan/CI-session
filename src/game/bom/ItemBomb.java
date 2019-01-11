package game.bom;

import game.GameObject;
import game.GameObjectPhysics;
import game.player.Player;
import game.renderer.SingleImageRenderer;
import physics.BoxCollider;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemBomb extends GameObjectPhysics {
    public ItemBomb(){
        super();
        this.createRenderer();
        this.boxCollider=new BoxCollider(this.position,this.anchor,30,30);
    }

    private void createRenderer() {
        BufferedImage image;
        image= SpriteUtils.loadImage("assets/images/background/item_bomb.png");
        this.renderer=new SingleImageRenderer(image);
    }

}
