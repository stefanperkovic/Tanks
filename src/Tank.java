import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tank implements ActionListener {
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
    private boolean isShooting;
    private static final int SLEEP_TIME = 110;
    private CannonBall bullet;
    private Image tankImage;
    private String type;
    private static final int HEALTH_DECREASE = -25;
    private static final int GROUND_LEVEL = 550;
    private static final int HITBOX_LEFT = 45;
    private static final int HITBOX_RIGHT = 145;
    private static final int HITBOX_BOTTOM = 135;
    private static final int HITBOX_TOP = 70;
    private static final int SHOOTING_LEFT = -1;







    public Tank(int x, int y, String type, GameViewer window, Game game){
        this.type = type;
        if (this.type.equals("left")){
            tankImage = new ImageIcon("Resources/TankLeft.png").getImage();
        }
        else{
            tankImage = new ImageIcon("Resources/TankRight.png").getImage();
        }
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
        Timer clock = new Timer(SLEEP_TIME, this);
        clock.start();
        isShooting = false;
        bullet = new CannonBall(this);

    }

    public void shoot(){
        this.setShooting(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (isShooting == true){
            if (type.equals("right")){
                bullet.setxVelocity(power);
            }
            else {
                bullet.setxVelocity(SHOOTING_LEFT * power);
            }
            bullet.setyVelocityChange(angle);
            bullet.changeLocation();
            bullet.draw(window.getGraphics());

            if (((bullet.getX() > otherTank.getX() + HITBOX_LEFT) && (bullet.getX() < otherTank.getX() + HITBOX_RIGHT))
                    && (bullet.getY() > otherTank.getY() + HITBOX_TOP) && (bullet.getY() < otherTank.getY() + HITBOX_BOTTOM)){
                otherTank.setHealth(HEALTH_DECREASE);
                game.checkWin();
                this.setShooting(false);
                bullet.reset();
            }
            if (bullet.getY() > GROUND_LEVEL){
                this.setShooting(false);
                bullet.reset();
            }
        }
    }
    public GameViewer getWindow() {
        return window;
    }

    public void setOtherTank(Tank otherTank) {
        this.otherTank = otherTank;
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
