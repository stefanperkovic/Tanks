import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tank implements ActionListener {
    private String name;
    private int x;
    private int y;
    private int health;
    private int gas;
    private int power;
    private boolean round;
    private int angle;

    private Game game;
    private Tank otherTank;
    private GameViewer window;
    private Image cannonBall;
    private boolean isShooting;
    private static final int SLEEP_TIME = 110;

    public Tank(String name, int x, int y, GameViewer window, Game game){
        this.name = name;
        health = 100;
        gas = 250;
        power = 0;
        this.x = x;
        this.y = y;
        round = false;
        angle = 0;
        this.game = game;
        otherTank = null;
        this.window = window;
        cannonBall = new ImageIcon("Resources/cannon_ball.png").getImage();
        Timer clock = new Timer(SLEEP_TIME, this);
        clock.start();
        isShooting = false;
    }

    public void setOtherTank(Tank otherTank) {
        this.otherTank = otherTank;
    }

    public void shoot(){

        if (power > otherTank.getX() - 5 && power < otherTank.getX() + 5){
            otherTank.setHealth(-20);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (isShooting == true){
            int distance = power;
            int max = angle;
            int midpoint = (x + distance) / 2;
            int a = -1;
            int y = 0;
            int distanceFromVertex;
            for (int x = 0; x < distance; x++){
                distanceFromVertex = (x - midpoint) * (x - midpoint);
                y = a * distanceFromVertex + max;
                window.getGraphics().drawImage(cannonBall, x, y, 10, 10, window);
                window.paint(window.getGraphics());
            }
            if (y <= 400){
                this.setShooting(false);
            }
        }
    }

    public void setAngle(int angle){
        this.angle += angle;
    }

    public int getAngle(){
        return angle;
    }

    public void changePower(int p){
        power += p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x += x;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public void setY(int y) {
        this.y += y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas += gas;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isRound() {
        return round;
    }

    public void setRound(boolean round) {
        this.round = round;
    }
}
