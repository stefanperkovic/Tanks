/**
 * Stefan Perkovic
 *
 * Creates the CannonBall class
 * Prints the cannonball as it flies through the air
 * Calculates its trajectory using gravity
 */


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
    private static final int INITIAL_Y_POSITION = 500;
    private static final int INITIAL_Y_VELOCITY = 30;
    private static final int INITIAL_X_POSITION_FACTOR = 80;
    private static final int CANNONBALL_SIZE = 20;

    public CannonBall(Tank tank) {
        this.tank = tank;
        window = this.tank.getWindow();
        cannonBall = new ImageIcon("Resources/cannon.png").getImage();
        xVelocity = this.tank.getPower();
        yVelocity = INITIAL_Y_VELOCITY;
        yVelocityChange = this.tank.getAngle();
        x = this.tank.getX() + INITIAL_X_POSITION_FACTOR;
        y = INITIAL_Y_POSITION;

    }

    /**
     * Resets the bullet to its original position
     */
    public void reset(){
        y = INITIAL_Y_POSITION;
        yVelocity = INITIAL_Y_VELOCITY;
        x = tank.getX() + INITIAL_X_POSITION_FACTOR;
    }

    /**
     * Finds the next location of the bullet
     */
    public void changeLocation(){
        yVelocity -= yVelocityChange;
        x += xVelocity;
        y -= yVelocity;
    }

    /**
     * Draws the bullet
     */
    public void draw(Graphics g){
        g.drawImage(cannonBall, x, y, CANNONBALL_SIZE, CANNONBALL_SIZE, window);
    }


    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
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
