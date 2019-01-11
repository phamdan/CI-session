package scene;

import game.GameObject;
import game.bom.ItemBomb;
import game.enemy.Enemy1;
import game.player.Player;
import game.background.Background;
import game.bom.ItemBomBangSize;
import game.box.BoxStone;
import game.box.BoxWood;

import java.io.*;
import java.util.ArrayList;

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
                        BoxStone g = GameObject.recycle(BoxStone.class);
                        g.position.x = j * 45;
                        g.position.y = i * 45;
                        g.anchor.set(0, 0);
                        break;
                    }
                    case 'p':{
                        Player k = GameObject.recycle(Player.class);
                        k.position.x = j * 45;
                        k.position.y = i * 45;
                        k.anchor.set(0, 0);
                        break;
                    }
                    case '*': {
                        BoxWood k = GameObject.recycle(BoxWood.class);
                        k.position.x = j * 45;
                        k.position.y = i * 45;
                        k.anchor.set(0, 0);
                        break;
                    }
                    case 's':{
                        ItemBomBangSize k = GameObject.recycle(ItemBomBangSize.class);
                        k.position.x = j * 45;
                        k.position.y = i * 45;
                        k.anchor.set(0, 0);
                        BoxWood g = GameObject.recycle(BoxWood.class);
                        g.position.x = j * 45;
                        g.position.y = i * 45;
                        g.anchor.set(0, 0);
                        break;
                    }
                    case 'b':{
                        ItemBomb k = GameObject.recycle(ItemBomb.class);
                        k.position.x = j * 45;
                        k.position.y = i * 45;
                        k.anchor.set(0, 0);
                        BoxWood g = GameObject.recycle(BoxWood.class);
                        g.position.x = j * 45;
                        g.position.y = i * 45;
                        g.anchor.set(0, 0);
                        break;
                    }
                    case 'e': {
                        Enemy1 g = GameObject.recycle(Enemy1.class);
                        g.position.x = j * 45;
                        g.position.y = i * 45;
                        g.anchor.set(0, 0);
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
