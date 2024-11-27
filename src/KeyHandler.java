import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (GamePanel.gameStatus.equals("Running")) {
            if (e.getKeyCode() == KeyEvent.VK_W && Player.playerYPosition > 15) {
                Player.playerYPosition = Player.playerYPosition - 10;
            } else if (e.getKeyCode() == KeyEvent.VK_S && Player.playerYPosition < Toolkit.getDefaultToolkit().getScreenSize().height-Player.playerHeight-15) {
                Player.playerYPosition = Player.playerYPosition + 10;
            } else if (e.getKeyCode() == KeyEvent.VK_A && Player.playerXPosition > 15) {
                Player.playerXPosition = Player.playerXPosition - 10;
            } else if (e.getKeyCode() == KeyEvent.VK_D && Player.playerXPosition < Toolkit.getDefaultToolkit().getScreenSize().width-Player.playerWidth-15) {
                Player.playerXPosition = Player.playerXPosition + 10;
            }
        }else if(GamePanel.gameStatus.equals("Menu")){
            if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
                if(GameMenu.selectedMenu == 1) {
                    GameMenu.selectedMenu = 4;
                }else{
                    GameMenu.selectedMenu--;
                }
            }else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
                if(GameMenu.selectedMenu == 4){
                    GameMenu.selectedMenu = 1;
                }else{
                    GameMenu.selectedMenu++;
                }
            }if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(GameMenu.selectedMenu == 4){
                    System.exit(0);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (GamePanel.gameStatus.equals("Running")) {
                GamePanel.gameStatus = "Menu";
            } else {
                GamePanel.gameStatus = "Running";
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
