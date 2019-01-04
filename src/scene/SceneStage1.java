package scene;

import game.GameObject;
import game.Player;
import game.background.Background;
import game.box.BoxStone;
import game.box.BoxWood;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SceneStage1 extends Scene {
    @Override
    public void init() {
        GameObject.recycle(Background.class);
        insertFromFile();
    }
    public void insertFromFile() {
        ArrayList<String> word = new ArrayList<>();
        try {
            String input = "C:\\Users\\Dell\\Desktop\\CI-Session-next-master\\src\\map\\map1.txt";
            FileInputStream fis = new FileInputStream(new File(input));
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                word.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("file rong");
        }
        for(int i=0;i<word.size();i++){
            String temp = word.get(i);
            for(int j=0;j<word.get(i).length();j++){
                char c = temp.charAt(j);
                switch (c) {
                    case '#': {
                        GameObject g = GameObject.recycle(BoxStone.class);
                        g.position.x = j * 45;
                        g.position.y = i * 45;
                        g.anchor.set(0, 0);
                        break;
                    }
                    case '*': {
                        GameObject k = GameObject.recycle(BoxWood.class);
                        k.position.x = j * 45;
                        k.position.y = i * 45;
                        k.anchor.set(0, 0);
                        break;
                    }
                    case 'p':{
                        GameObject k = GameObject.recycle(Player.class);
                        k.position.x = j * 45;
                        k.position.y = i * 45;
                        k.anchor.set(0, 0);
                        break;
                    }
                    default:
                        break;
                }
            }
        }
    }
    @Override
    public void clear(){
        GameObject.clearAll();
    }
}
