package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    BufferedImage image;
    public SingleImageRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image
                , (int)(master.position.x
            - this.image.getWidth() * master.anchor.x)
                , (int)(master.position.y
            - this.image.getHeight() * master.anchor.y)
                , null);
    }
}
