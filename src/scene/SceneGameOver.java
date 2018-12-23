package scene;

import game.GameObject;

public class SceneGameOver extends Scene {

    @Override
    public void init() {
        BackgroundGameOver gameOver= GameObject.recycle(BackgroundGameOver.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
