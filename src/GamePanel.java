
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static String gameStatus = "Running";

    static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    static int[] screenSize = {WIDTH, HEIGHT};

    Thread gameThread;
    final int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    MouseHandler mouseHandler = new MouseHandler();

    Player player = new Player();
    GameMenu gameMenu = new GameMenu();

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenSize[0], screenSize[1]));
        this.setBackground(Color.black);
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
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (gameStatus.equals("Running")) {
//        gridDrawing(g2);
            g2.setColor(Color.GREEN);
            g2.fillRect(0,0,1500,850);
            player.draw(g2);
        } else if (gameStatus.equals("Menu")) {
            gameMenu.draw(g2);
        }
    }

    private void gridDrawing(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        int xCoordinate = 0;
        int yCoordinate = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 17; j++) {
                g2.drawRect(xCoordinate, yCoordinate, 50, 50);
                yCoordinate = yCoordinate + 50;
            }
            yCoordinate = 0;
            xCoordinate = xCoordinate + 50;
        }
    }
}
