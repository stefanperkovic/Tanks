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
        WINDOW_HEIGHT = 1000;
        WINDOW_WIDTH = 800;
    }

    public void paint(Graphics g){
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
//        g.drawImage(tankImage, game.getTankOne().getX(), game.getTankOne().getY(), this);
//        g.drawImage(tankImage, game.getTankTwo().getX(), game.getTankTwo().getY(), this);

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

        }
        else if(keyCode == KeyEvent.VK_RIGHT)
        {

        }
        else if(keyCode == KeyEvent.VK_UP)
        {

        }
        else if(keyCode == KeyEvent.VK_DOWN)
        {

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
