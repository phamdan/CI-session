package game;

import game.bom.Bom;
import game.box.BoxWood;
import game.renderer.SingleImageRenderer;
import physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player extends GameObjectPhysics {
    int direction; // 1 = top, 2 = right, 3 = bot, 4 = left, 0 = stay
    FrameCounter moveCounter;
    FrameCounter nextBom;
    public Player(){
        super();
        this.createRenderer();
        this.direction = Settings.STAY;
        this.moveCounter = new FrameCounter(10);
        this.nextBom=new FrameCounter(100);//nếu đặt 2 bomm thì 30 là đẹpds
        this.boxCollider=new BoxCollider(this.position,this.anchor,30,30);
    }

    private void createRenderer() {
        BufferedImage images ;
        images= SpriteUtils.loadImage("assets/images/background/bomber_right.png");
        this.renderer = new SingleImageRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.setDirection();
        this.move();
        if(this.nextBom.run()) {
            this.bom();
        }
    }
    private void bom() {
        if (GameWindow.isFirePress) {
            Bom bom = GameObject.recycle(Bom.class);
            bom.position.set(this.position);
            bom.anchor.set(0, 0);
            this.nextBom.reset();
        }
    }
    private boolean checkBox() {
        Vector2D aheadPosition = null;

        if(this.direction==Settings.TOP){
            aheadPosition = this.position.add(0,-Settings.WAY_SIZE);
        }else if(this.direction==Settings.RIGHT){
            aheadPosition=this.position.add(Settings.WAY_SIZE,0);
        }else if(this.direction==Settings.LEFT){
            aheadPosition=this.position.add(-Settings.WAY_SIZE,0);
        }else if(this.direction==Settings.BOT){
            aheadPosition=this.position.add(0,Settings.WAY_SIZE);
        }

        BoxWood boxWood=GameObject.findByPosition(BoxWood.class,aheadPosition);
        if(boxWood==null) {
            return true;
        }
        return false;

    }


    private void setDirection() {
        if(GameWindow.isUpPress) {
            this.direction = Settings.TOP;
        } else if(GameWindow.isRightPress) {
            this.direction = Settings.RIGHT;
        } else if(GameWindow.isDownPress) {
            this.direction = Settings.BOT;
        } else if(GameWindow.isLeftPress) {
            this.direction = Settings.LEFT;
        } else {
            this.direction = Settings.STAY;
        }
    }
    private void move() {
        if(this.moveCounter.run()) {
            float vx = 0, vy = 0;
            switch (this.direction) {
                case Settings.TOP: {
                    vy = -Settings.WAY_SIZE;
                    BufferedImage images ;
                    images= SpriteUtils.loadImage("assets/images/background/bomber_up.png");
                    this.renderer = new SingleImageRenderer(images);
                    break;
                }
                case Settings.RIGHT: {
                    if(checkBox()==true) {
                        vx = Settings.WAY_SIZE;
                        BufferedImage images;
                        images = SpriteUtils.loadImage("assets/images/background/bomber_right.png");
                        this.renderer = new SingleImageRenderer(images);
                    }else{
                        vx=0;
                    }
                    break;
                }
                case Settings.BOT: {
                    vy = Settings.WAY_SIZE;
                    BufferedImage images ;
                    images= SpriteUtils.loadImage("assets/images/background/bomber_down.png");
                    this.renderer = new SingleImageRenderer(images);
                    break;
                }
                case Settings.LEFT: {
                    vx = -Settings.WAY_SIZE;
                    BufferedImage images ;
                    images= SpriteUtils.loadImage("assets/images/background/bomber_left.png");
                    this.renderer = new SingleImageRenderer(images);
                    break;
                }
            }
            if(this.direction != Settings.STAY) {
                this.position.addThis(vx, vy);
                this.moveCounter.reset();
            }
        }
    }

}
