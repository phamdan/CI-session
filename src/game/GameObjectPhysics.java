package game;

import physics.BoxCollider;
import physics.Physics;

public class GameObjectPhysics extends GameObject implements Physics {
    public BoxCollider boxCollider;
    public GameObjectPhysics(){
        super();
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
