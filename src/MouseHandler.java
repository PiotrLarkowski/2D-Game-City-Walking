import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(GamePanel.gameStatus.equals("Menu")){
            if((e.getX()>=615 && e.getX()<=920) && (e.getY()>=260 && e.getY()<=340)){
                System.out.println("Wybrano opcje menu 1");
            }
            else if((e.getX()>=615 && e.getX()<=920) && (e.getY()>=360 && e.getY()<=440)){
                System.out.println("Wybrano opcje menu 2");
            }
            else if((e.getX()>=615 && e.getX()<=920) && (e.getY()>=460 && e.getY()<=540)){
                System.out.println("Wybrano opcje menu 3");
            }else if((e.getX()>=660 && e.getX()<=865) && (e.getY()>=560 && e.getY()<=640)){
                System.out.println("Wybrano opcje menu 4");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
