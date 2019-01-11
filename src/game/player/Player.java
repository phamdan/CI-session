package game.player;

import game.*;
import game.bom.*;
import game.box.BoxStone;
import game.box.BoxWood;
import game.enemy.Enemy1;
import game.renderer.SingleImageRenderer;
import physics.BoxCollider;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player extends GameObjectPhysics {
    public static int bomSize;
    int direction; // 1 = top, 2 = right, 3 = bot, 4 = left, 0 = stay
    FrameCounter moveCounter;
    FrameCounter nextBom;
    int bomNext;
    public Player(){
        super();
        this.createRenderer();
        this.direction = Settings.STAY;
        this.moveCounter = new FrameCounter(10);
        this.nextBom=new FrameCounter(100);//nếu đặt 2 bomm thì 30 là đẹpds
        this.bomNext=100;
        this.boxCollider=new BoxCollider(this.position,this.anchor,40,40);
        this.bomSize=1;
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
        this.checkBomBangSize();
        this.checkBomItem();
        this.checkPlayerDie();
        if(this.nextBom.run()) {
            this.bom();
        }
    }

    private void checkBomItem() {
        ItemBomb itemBomb=GameObject.findIntersected(ItemBomb.class,this.boxCollider);
        if(itemBomb!=null){
            itemBomb.destroy();
            this.bomNext-=40;
            this.nextBom=new FrameCounter(this.bomNext);
        }
    }

    private void checkPlayerDie() {
        BombBangRight bombBangRight= GameObject.findIntersected(BombBangRight.class,this.boxCollider);
        BombBangLeft bombBangLeft= GameObject.findIntersected(BombBangLeft.class,this.boxCollider);
        BombBangUp bombBangUp= GameObject.findIntersected(BombBangUp.class,this.boxCollider);
        BombBangDown bombBangDown= GameObject.findIntersected(BombBangDown.class,this.boxCollider);
        Enemy1 enemy1=GameObject.findIntersected(Enemy1.class,this.boxCollider);
        if(bombBangRight!=null||bombBangLeft!=null||bombBangDown!=null||bombBangUp!=null||enemy1!=null){
            this.destroy();
            PlayerDie playerDie=GameObject.recycle(PlayerDie.class);
            playerDie.position.set(this.position);
            playerDie.anchor.set(0,0);
        }
    }

    private void checkBomBangSize() {
        ItemBomBangSize itemBomBangSize = GameObject.findIntersected(ItemBomBangSize.class,this.boxCollider);
        if(itemBomBangSize !=null){
            itemBomBangSize.destroy();
            this.bomSize++;
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
                    vx = Settings.WAY_SIZE;
                    BufferedImage images;
                    images = SpriteUtils.loadImage("assets/images/background/bomber_right.png");
                    this.renderer = new SingleImageRenderer(images);
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
                if(this.checkBox()) {
                    this.position.addThis(vx, vy);
                    this.moveCounter.reset();
                }
            }
        }
    }
    private boolean checkBox() {
        Vector2D aheadPosition = null;

        if (this.direction == Settings.TOP) {
            aheadPosition = this.position.add(0, -Settings.WAY_SIZE);
        } else if (this.direction == Settings.RIGHT) {
            aheadPosition = this.position.add(Settings.WAY_SIZE, 0);
        } else if (this.direction == Settings.LEFT) {
            aheadPosition = this.position.add(-Settings.WAY_SIZE, 0);
        } else if (this.direction == Settings.BOT) {
            aheadPosition = this.position.add(0, Settings.WAY_SIZE);
        }
        BoxWood boxWood= GameObject.findByPosition(BoxWood.class, aheadPosition);
        BoxStone boxStone=GameObject.findByPosition(BoxStone.class,aheadPosition);
        Bom bom=GameObject.findByPosition(Bom.class,aheadPosition);
        if(boxWood!=null||boxStone!=null||bom!=null) return false;
        return true;
    }
}
