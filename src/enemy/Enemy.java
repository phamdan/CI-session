package enemy;

import game.GameObject;
import game.Settings;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy (){
        super();
        this.createRenderer();
        this.position.set(0,-30);
        //this.anchor.set(0,0);
        this.velocity.set(3,-1);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images=new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer=new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        if(this.position.x> Settings.BACKGROUND_WIDTH-14
        &&this.velocity.x>0){
            this.velocity.set(-3,this.velocity.y);
        }
        if(this.position.x<14&&this.velocity.x<0){
            this.velocity.set(3,this.velocity.y);
        }
        if(this.position.y> Settings.SCREEN_HEIGHT-14
                &&this.velocity.y>0){
            this.velocity.set(this.velocity.x,-1);
        }
        if(this.position.y<14&&this.velocity.y<0){
            this.velocity.set(this.velocity.x,1);
        }
    }
}
