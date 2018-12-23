package scene;

import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome(){
        this.renderer=new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/background welcome.jpg"));
        this.position.set(Settings.SCREEN_WIDTH/2,Settings.SCREEN_HEIGHT/2);

    }

    @Override
    public void run() {
        super.run();
        if(GameWindow.isAnyKeyPress){
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
