package game.background;

import game.GameObject;
import game.Player;
import game.Settings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Background extends GameObject {
    public  Background(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/background_Play.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0,0);
        this.anchor.set(0, 0);
    }

}
