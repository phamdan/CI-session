package game.renderer;

import game.GameObject;
import physics.BoxCollider;
import physics.Physics;

import java.awt.*;
import java.security.PublicKey;

public class BoxColliderRenderer extends Renderer {
    Color color;
    boolean isFill;
    public  BoxColliderRenderer(){
        this(Color.GREEN,false);
    }
    public  BoxColliderRenderer(Color color,boolean isFill){
        this.color=color;
        this.isFill=isFill;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        if(master instanceof Physics){
            g.setColor(this.color);
            Physics masterPhysic=(Physics) master;
            BoxCollider masterCollider=masterPhysic.getBoxCollider();
            if(this.isFill){
                g.fillRect((int)masterCollider.left()
                        ,(int)masterCollider.top()
                        ,masterCollider.width
                        ,masterCollider.height);
            }else {
                g.drawRect((int)masterCollider.left()
                        ,(int)masterCollider.top()
                        ,masterCollider.width
                        ,masterCollider.height);
            }
        }
    }
}
