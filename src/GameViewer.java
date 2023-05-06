import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameViewer extends JFrame implements KeyListener {
    private Game game;
    private Image background;
    private Image cannon;
    private Image tankImage;
    private int WINDOW_WIDTH;
    private int WINDOW_HEIGHT;
    public GameViewer(Game g){
        tankImage = new ImageIcon("Resources/Tank.png").getImage();
        background = new ImageIcon("Resources/Background.png").getImage();
        game = g;
        WINDOW_HEIGHT = 800;
        WINDOW_WIDTH = 2000;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tanks");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        addKeyListener(this);
    }

    public void paint(Graphics g){
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 75));
        if (game.getTankOne() != null){
            g.drawString("Power: " + game.getTankOne().getX(), 200, 60);
            g.drawString("Angle: " + game.getTankOne().getAngle(), 300, 60);
            g.drawImage(tankImage, game.getTankOne().getX(), game.getTankOne().getY(), 50, 50, this);
        }
        if (game.getTankTwo() != null){
            g.drawImage(tankImage, game.getTankTwo().getX(), game.getTankTwo().getY(), 50, 50, this);
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
                t.setGas(-5);
            }

        }
        else if(keyCode == KeyEvent.VK_RIGHT)
        {
            if (t.getGas() > 0){
                t.setX(20);
                t.setGas(-5);
            }
        }
        else if (keyCode == KeyEvent.VK_P){
            t.changePower(10);
        }
        else if (keyCode == KeyEvent.VK_L){
            t.changePower(-10);
        }
        else if (keyCode == KeyEvent.VK_S){
            t.shoot();
            t.setShooting(true);
            t.setRound(false);
            if (t == game.getTankOne()){
                game.getTankTwo().setRound(true);
            }
            else{
                game.getTankOne().setRound(true);
            }
        }
        else if(keyCode == KeyEvent.VK_A){
            t.setAngle(5);
        }
        else if(keyCode == KeyEvent.VK_D){
            t.setAngle(-5);
        }
//        else if(keyCode == KeyEvent.VK_UP)
//        {
//            t.setY(5);
//        }
//        else if(keyCode == KeyEvent.VK_DOWN)
//        {
//            t.setY(-5);
//        }


        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
