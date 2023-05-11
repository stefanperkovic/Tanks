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
    private CannonBall bullet;
    private int count;
    private Image tankImage;
    private String type;
    public Tank(String name, int x, int y, String type, GameViewer window, Game game){
        if (type.equals("left")){
            tankImage = new ImageIcon("Resources/TankLeft.png").getImage();
        }
        else{
            tankImage = new ImageIcon("Resources/TankRight.png").getImage();
        }
        this.type = type;
        this.name = name;
        health = 100;
        gas = 200;
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
        bullet = new CannonBall(this);
        count = 0;

    }

    public GameViewer getWindow() {
        return window;
    }

    public void setOtherTank(Tank otherTank) {
        this.otherTank = otherTank;
    }

    public void shoot(){

        this.setShooting(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (isShooting == true){
            if (type.equals("right")){
                bullet.setxv(power);
            }
            else {
                bullet.setxv(-1 * power);
            }
            bullet.setyvChange(angle);
            bullet.changeLocation();
            bullet.draw(window.getGraphics());

            if (((bullet.getX() > otherTank.getX() + 45) && (bullet.getX() < otherTank.getX() + 145))
                    && (bullet.getY() > otherTank.getY() + 70) && (bullet.getY() < otherTank.getY() + 135)){
                otherTank.setHealth(-25);
                game.checkWin();
                this.setShooting(false);
                bullet.reset();
            }
            if (bullet.getY() > 550){
                this.setShooting(false);
                bullet.reset();
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

    public Image getTankImage() {
        return tankImage;
    }

    public void setTankImage(Image tankImage) {
        this.tankImage = tankImage;
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
        this.health += health;
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

    public CannonBall getBullet() {
        return bullet;
    }

    public void setBullet(CannonBall bullet) {
        this.bullet = bullet;
    }
}
