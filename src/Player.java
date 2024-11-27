import java.awt.*;

public class Player {
    public static int playerXPosition = 700;
    public static int playerYPosition = 400;
    public static int playerHeight = 200;
    public static int playerWidth = 150;

    public void update(){

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        g2.fillRect(playerXPosition,playerYPosition,playerWidth,playerHeight);
    }
}
