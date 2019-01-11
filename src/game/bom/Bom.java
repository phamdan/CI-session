package game.bom;

import game.*;
import game.box.BoxStone;
import game.box.BoxWood;
import game.player.Player;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Bom extends GameObjectPhysics {
    FrameCounter bomCounter;
    public static int BomBangBangSize;
    public Bom(){
        super();
        this.createRenderer();
        this.bomCounter=new FrameCounter(100);
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
        for(int i = 1; i<= Player.bomSize; i++) {
            if((this.checkBoxLeft(i)==1)){// cái đầu tiên mà false thì khỏi phải kiểm tra phía sau
                break;
            }else if(this.checkBoxLeft(i)==2){
                BombBangLeft bombBangLeft = GameObject.recycle(BombBangLeft.class);
                bombBangLeft.position.set(this.position.x - 90*i + i*45, this.position.y);
                bombBangLeft.anchor.set(0, 0);
                break;
            }
            else {
                BombBangLeft bombBangLeft = GameObject.recycle(BombBangLeft.class);
                bombBangLeft.position.set(this.position.x - 90*i + i*45, this.position.y);
                bombBangLeft.anchor.set(0, 0);
            }
        }
        for(int i=0;i<Player.bomSize;i++) {
            if (this.checkBoxRight(i)==1) {
                break;
            }else if(this.checkBoxRight(i)==2){
                BombBangRight bombBangRight = GameObject.recycle(BombBangRight.class);
                bombBangRight.position.set(this.position.x+i*90-i*45,this.position.y);
                bombBangRight.anchor.set(0, 0);
                break;
            }
            else {
                BombBangRight bombBangRight = GameObject.recycle(BombBangRight.class);
                bombBangRight.position.set(this.position.x+i*90-i*45,this.position.y);
                bombBangRight.anchor.set(0, 0);
            }
        }
        for(int i=1;i<=Player.bomSize;i++) {
            if(this.checkBoxStoneUp(i)==1){
                break;
            }else if(this.checkBoxStoneUp(i)==2){
                BombBangUp bombBangUp = GameObject.recycle(BombBangUp.class);
                bombBangUp.position.set(this.position.x, this.position.y - i*90 + i*45);
                bombBangUp.anchor.set(0, 0);
                break;
            }
            else {
                BombBangUp bombBangUp = GameObject.recycle(BombBangUp.class);
                bombBangUp.position.set(this.position.x, this.position.y - i*90 + i*45);
                bombBangUp.anchor.set(0, 0);
            }
        }
        for(int i=0;i<Player.bomSize;i++) {
            if (this.checkBoxStoneDown(i)==1) {
                break;
            }else if(this.checkBoxStoneDown(i)==2){
                BombBangDown bombBangDown = GameObject.recycle(BombBangDown.class);
                bombBangDown.position.set(this.position.x,this.position.y+i*90-i*45);
                bombBangDown.anchor.set(0, 0);
                break;
            }
            else {
                BombBangDown bombBangDown = GameObject.recycle(BombBangDown.class);
                bombBangDown.position.set(this.position.x,this.position.y+i*90-i*45);
                bombBangDown.anchor.set(0, 0);
            }
        }
    }
    private int checkBoxStoneUp(int i){
        Vector2D aheadPositionUp = null;
        aheadPositionUp = this.position.add(0, -i*Settings.WAY_SIZE);
        BoxStone boxStoneUp=GameObject.findByPosition(BoxStone.class,aheadPositionUp);
        BoxWood boxWoodUp=GameObject.findByPosition(BoxWood.class,aheadPositionUp);
        if(boxStoneUp!=null) return 1;
        else if(boxWoodUp!=null) return 2;
        else return 0;
    }
    private int checkBoxStoneDown(int i){
        Vector2D aheadPositionDown = null;
        aheadPositionDown = this.position.add(0, (i+1)*Settings.WAY_SIZE);
        BoxStone boxStoneDown=GameObject.findByPosition(BoxStone.class,aheadPositionDown);
        BoxWood boxWoodDown=GameObject.findByPosition(BoxWood.class,aheadPositionDown);
        if(boxStoneDown!=null) return 1;
        else if(boxWoodDown!=null) return 2;
        else  return 0;
    }
    private int checkBoxLeft(int i){

        //1~stone ; 2~wood; 3~ko co gi
        Vector2D aheadPositionLeft = null;
        aheadPositionLeft = this.position.add(-i*Settings.WAY_SIZE, 0);
        BoxStone boxStoneLeft=GameObject.findByPosition(BoxStone.class,aheadPositionLeft);
        BoxWood boxWoodLeft=GameObject.findByPosition(BoxWood.class,aheadPositionLeft);
        if(boxStoneLeft!=null) return 1;
        else if(boxWoodLeft!=null) return 2;
        else return 0;
    }
    private int checkBoxRight(int i){
        Vector2D aheadPositionRight = null;
        aheadPositionRight = this.position.add((i+1)*Settings.WAY_SIZE, 0);
        BoxWood boxWoodRight=GameObject.findByPosition(BoxWood.class,aheadPositionRight);
        BoxStone boxStoneRight=GameObject.findByPosition(BoxStone.class,aheadPositionRight);
        if(boxStoneRight!=null) return 1;
        else if(boxWoodRight!=null) return 2;
        else return 0;
    }
    private void createRenderer() {
        BufferedImage images ;
        images= SpriteUtils.loadImage("assets/images/background/bomb.png");
        this.renderer = new SingleImageRenderer(images);
    }

}
