import javax.swing.*;
import java.awt.*;

public class CannonBall {
    private double a;
    private int y;
    private int x;
    private Image cannonBall;
    private GameViewer window;
    private Tank t;
    private int k;
    private int xv;
    private int yv;
    private int yvChange;

    public CannonBall(Tank tank) {
        t = tank;
        xv = t.getPower();
        yvChange = t.getAngle();

        x = t.getX() + 20;
        y = 480;

        cannonBall = new ImageIcon("Resources/cannon.png").getImage();
        window = tank.getWindow();

        yv = 30;


    }

    public void reset(){
        y = 480;
        yv = 30;
        x = t.getX() + 20;
    }

    public void changeLocation(){
        yv -= yvChange;
        x += xv;
        y -= yv;


        System.out.println("Y: " + y);
        System.out.println("X: " + x);
    }

    public void draw(Graphics g){
//        System.out.println("X: " + x + " Y: " + y);
        g.drawImage(cannonBall, x, y, 20, 20, window);

    }

    public int getxv() {
        return xv;
    }

    public void setxv(int xv) {
        this.xv = xv;
    }

    public int getyvChange() {
        return yvChange;
    }

    public void setyvChange(int yvChange) {
        this.yvChange = yvChange;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
