import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameViewer extends JFrame implements KeyListener {
    private Game game;
    private Image background;
    private Image cannon;

    private int WINDOW_WIDTH;
    private int WINDOW_HEIGHT;
    private boolean inInstructions;
    private Image camo;
    public GameViewer(Game g){
        background = new ImageIcon("Resources/background.png").getImage();
        camo = new ImageIcon("Resources/camo.jpeg").getImage();
        game = g;
        WINDOW_HEIGHT = 800;
        WINDOW_WIDTH = 2000;
        inInstructions = true;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tanks");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        addKeyListener(this);
    }

    public void paint(Graphics g){
        if (inInstructions == true){
            g.drawImage(camo, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("How to Play", 60, 100);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("Left and Right Arrow to Move", 500, 225);
            g.drawString("S to Shoot", 500, 275);
            g.drawString("P to Add Power", 500, 350);
            g.drawString("L to Lower Power", 500, 400);
            g.drawString("A to increase Angle", 500, 475);
            g.drawString("D to Decrease Angle", 500, 525);
            g.drawString("Space to Start", 500, 700);
        }
        else if(game.isGameOver() == true){
            if (game.getTankOne().getHealth() < 0){
                g.drawRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Serif", Font.PLAIN, 100));
                g.drawString("Tank 2 Wins!!!!!!", 600, 500);
            }
            else{
                g.drawRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Serif", Font.PLAIN, 100));
                g.drawString("Tank 1 Wins!!!!!!", 400, 400);
            }

        }
        else{
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            if (game.getTankOne() != null){
                g.drawString("Tank 1 Power: " + game.getTankOne().getPower(), 25, 50);
                g.drawString("Angle: " + game.getTankOne().getAngle(), 185, 50);
                g.drawString("Gas: " + game.getTankOne().getGas(), 280, 50);
                g.drawString("Health: " + game.getTankOne().getHealth(), 360, 50);
                g.drawImage(game.getTankOne().getTankImage(), game.getTankOne().getX(), game.getTankOne().getY(), 200, 200, this);
            }
            if (game.getTankTwo() != null){
                g.drawImage(game.getTankTwo().getTankImage(), game.getTankTwo().getX(), game.getTankTwo().getY(), 200, 200, this);
                g.drawString("Tank 2 Power: " + game.getTankTwo().getPower(), 1000, 50);
                g.drawString("Angle: " + game.getTankTwo().getAngle(), 1160, 50);
                g.drawString("Gas: " + game.getTankTwo().getGas(), 1255, 50);
                g.drawString("Health: " + game.getTankTwo().getHealth(), 1335, 50);
            }
        }


        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Tank t;
        if (game.getTankOne().isRound() == false){
            t = game.getTankTwo();
        }
        else{
            t = game.getTankOne();
        }
        if(keyCode == KeyEvent.VK_LEFT)
        {
            if (t.getGas() > 0){
                t.setX(-20);
                t.setGas(-20);
                t.getBullet().setX(t.getBullet().getX() - 20);
            }

        }
        else if(keyCode == KeyEvent.VK_RIGHT)
        {
            if (t.getGas() > 0){
                t.setX(20);
                t.setGas(-20);
                t.getBullet().setX(t.getBullet().getX() + 20);
            }
        }
        else if (keyCode == KeyEvent.VK_P){
            t.changePower(10);
        }
        else if (keyCode == KeyEvent.VK_L){
            if (t.getPower() > 0){
                t.changePower(-10);
            }
        }
        else if (keyCode == KeyEvent.VK_S){
            t.shoot();
            t.setRound(false);
            if (t == game.getTankOne()){
                game.getTankTwo().setRound(true);
            }
            else{
                game.getTankOne().setRound(true);
            }
        }
        else if(keyCode == KeyEvent.VK_A){
            t.setAngle(1);
        }
        else if(keyCode == KeyEvent.VK_D){
            if (t.getAngle() > 0){
                t.setAngle(-1);
            }
        }
        else if(keyCode == KeyEvent.VK_SPACE){
            inInstructions = false;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
