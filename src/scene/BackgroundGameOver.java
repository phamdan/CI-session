package scene;

import game.FrameCounter;
import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class BackgroundGameOver extends GameObject {
    FrameCounter waiCounter;
    public BackgroundGameOver(){
        this.renderer=new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/game-over-scene.jpg"));
        this.position.set(Settings.SCREEN_WIDTH/2,Settings.SCREEN_HEIGHT/2);
        this.waiCounter=new FrameCounter(60);
    }

    @Override
    public void run() {
        super.run();
        if(this.waiCounter.run()&&GameWindow.isAnyKeyPress){
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
