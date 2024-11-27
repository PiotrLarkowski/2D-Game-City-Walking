import java.awt.*;
public class GameMenu {

    public int x, y, width, height;
    public void update(){

    }

    public void draw(Graphics2D g2){
       g2.setColor(Color.blue);
       g2.fillRect(PercentageCalculationFromScreenSize.calculateThePercentageOfWidth(30),
                PercentageCalculationFromScreenSize.calculateThePercentageOfHeight(20),
                PercentageCalculationFromScreenSize.calculateThePercentageOfWidth(40),
                PercentageCalculationFromScreenSize.calculateThePercentageOfHeight(60));

        addButton(1,"OPCJA 1", g2);
        addButton(2,"OPCJA 2", g2);
        addButton(3,"OPCJA 3", g2);

    }

    public void addButton(int numberOfButton, String name, Graphics2D g2){
        x = PercentageCalculationFromScreenSize.calculateThePercentageOfWidth(40);
        y = PercentageCalculationFromScreenSize.calculateThePercentageOfHeight(30);
        width = PercentageCalculationFromScreenSize.calculateThePercentageOfWidth(20);
        height = PercentageCalculationFromScreenSize.calculateThePercentageOfHeight(10);
        if(numberOfButton == 2) {
            y = y + 100;
        }else if(numberOfButton == 3) {
            y = y + 200;
        }
        g2.setColor(Color.black);
        g2.fillRect(x, y, width, height);
        g2.setColor(Color.blue);
        g2.fillRect(x +2, y +2, width -4, height -4);
        g2.setColor(Color.black);
        g2.setFont(new Font("Times New Roman",Font.BOLD,30));
        g2.drawString(name, x +(25* name.length()/2), y +(height /2)+10);
    }
}
