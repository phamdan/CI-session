package game;

import game.renderer.SingleImageRenderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
    public boolean status=true;
    public Enemy(){
        super();
        int a;
        BufferedImage image= SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer=new SingleImageRenderer(image);
        //BufferedImage image= SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        //this.renderer=new SingleImageRenderer(image);
        this.position.set(10,10);
    }
    private void limitEnemiesPosition() {
        int halfWidth = (int)(16 * this.anchor.x);
        int halfHeight = (int)(16 * this.anchor.y);

        float x = (float) Mathx.clamp(this.position.x
                , halfWidth
                , Settings.BACKGROUND_WIDTH - halfWidth);

        this.position.set(x, this.position.y);
    }
    @Override
    public void run(){
        int halfWidth = (int)(16 * this.anchor.x);
        if(this.position.x>=(Settings.BACKGROUND_WIDTH - halfWidth)) this.status=false;
        if(this.status==true) {
            this.position.addThis(5,0);
        }
        else this.position.addThis(-5,0);
        if(this.position.x<=8) this.status=true;
        this.position.addThis(0,1);
        this.limitEnemiesPosition();
    }
}
