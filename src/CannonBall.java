import javax.swing.*;
import java.awt.*;

public class CannonBall {
    private int y;
    private int x;
    private Image cannonBall;
    private GameViewer window;
    private Tank tank;
    private int xVelocity;
    private int yVelocity;
    private int yVelocityChange;

    public CannonBall(Tank tank) {
        this.tank = tank;
        window = tank.getWindow();
        cannonBall = new ImageIcon("Resources/cannon.png").getImage();
        xVelocity = tank.getPower();
        yVelocity = 30;
        yVelocityChange = tank.getAngle();
        x = tank.getX() + 80;
        y = 500;

    }

    public void reset(){
        y = 500;
        yVelocity = 30;
        x = tank.getX() + 80;
    }

    public void changeLocation(){
        yVelocity -= yVelocityChange;
        x += xVelocity;
        y -= yVelocity;
    }

    public void draw(Graphics g){
        g.drawImage(cannonBall, x, y, 20, 20, window);
    }


    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getyVelocityChange() {
        return yVelocityChange;
    }

    public void setyVelocityChange(int yVelocityChange) {
        this.yVelocityChange = yVelocityChange;
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
