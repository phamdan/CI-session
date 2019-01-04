package game;

import java.security.PublicKey;

public class Settings {
    public static int PLAYER_WIDTH = 45;
    public static int PLAYER_HEIGHT = 65;
    public static int SCREEN_WIDTH = 800;
    public static int BACKGROUND_WIDTH = 750;
    public static int SCREEN_HEIGHT = 600;
    public static int WAY_SIZE=45;
    public static int ROW_COUNT=SCREEN_HEIGHT/WAY_SIZE;// SO HANG
    public static int COL_COUNT=SCREEN_WIDTH/WAY_SIZE;// SO COT
    public final static int STAY=0;
    public final static int TOP=1;
    public final static int RIGHT=2;
    public final static int BOT=3;
    public final static int LEFT=4;
}
