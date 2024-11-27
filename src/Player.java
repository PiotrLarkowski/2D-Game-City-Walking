import java.awt.*;

public class Player {
    public static int playerXPosition = 100;
    public static int playerYPosition = 100;

    public void update(){

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        g2.fillRect(playerXPosition,playerYPosition,50,50);
    }
}
