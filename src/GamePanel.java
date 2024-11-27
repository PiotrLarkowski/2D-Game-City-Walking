
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements Runnable {

    public static String gameStatus = "Running";

    static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    static int[] screenSize = {WIDTH, HEIGHT};

    Thread gameThread;
    final int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    MouseHandler mouseHandler = new MouseHandler();

    GameMenu gameMenu = new GameMenu();

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenSize[0], screenSize[1]));
        this.setBackground(Color.white);
        this.setLayout(null);

        this.addKeyListener(keyHandler);
        this.addMouseListener(mouseHandler);
        this.setFocusable(true);

        launchGame();

    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
//                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        gameMenu.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(gameStatus.equals("Running")){

        }else if(gameStatus.equals("Menu")){
            gameMenu.draw(g2);
        }
    }
}
