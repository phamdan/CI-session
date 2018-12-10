package game.renderer;

import game.GameObject;

import java.awt.*;

public class TextRenderer extends Renderer {
    String text;
    public TextRenderer(String text) {
        this.text = text;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawString(this.text
            , (int) master.position.x
            , (int) master.position.y
        );
    }
}
