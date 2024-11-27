import java.awt.*;
public class GameMenu {
    public void update(){

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        g2.fillRect(PercentageCalculationFromScreenSize.calculateThePercentageOfWidth(30),
                PercentageCalculationFromScreenSize.calculateThePercentageOfHeight(20),
                PercentageCalculationFromScreenSize.calculateThePercentageOfWidth(40),
                PercentageCalculationFromScreenSize.calculateThePercentageOfHeight(60));
    }
}
