package scene;

import game.GameObject;

public class SceneWelcome  extends Scene{
    @Override
    public void init() {
        BackgroundWelcome background= GameObject.recycle(BackgroundWelcome.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
