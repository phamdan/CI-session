package game.renderer;

import game.FrameCounter;
import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;
    FrameCounter nextImageCounter;
    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCounter=new FrameCounter(5);
    }
    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage image = this.images.get(this.currentImageIndex);
        g.drawImage(image
                , (int)(master.position.x
        - image.getWidth() * master.anchor.x)
                , (int)(master.position.y
        - image.getHeight() * master.anchor.y)
                , null);


        if(this.nextImageCounter.run()) {//true or flase
            this.currentImageIndex++;
            if(this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.nextImageCounter.reset();
        }
    }
}
