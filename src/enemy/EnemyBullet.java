package enemy;

import game.GameObject;
import game.player.Player;
import game.renderer.AnimationRenderer;
import game.renderer.SingleImageRenderer;
import physics.BoxCollider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    public EnemyBullet(){
        super();
        this.createRenderer();
        this.velocity.set(0,2);
        this.boxCollider=new BoxCollider(this.position,this.anchor,20,20);
    }
    private void createRenderer() {
        BufferedImage images ;
        images=SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer = new SingleImageRenderer(images);

    }
    @Override
    public void run() {
        super.run();
        if(this.position.y>630){
            this.destroy();
        }
        this.checkIntersect();
    }

    private void checkIntersect() {
        Player player=GameObject.findIntersected(Player.class,this.boxCollider);
        if(player!=null){
            this.destroy();
            player.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
