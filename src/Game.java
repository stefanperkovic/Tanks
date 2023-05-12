import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Game {
    private GameViewer window;
    private Tank tankOne;
    private Tank tankTwo;
    private boolean gameOver;
    private static final int INITIAL_TANK_HEIGHT = 426;
    private static final int TANK_ONE_INITIAL_X_POSITION = 200;
    private static final int TANK_TWO_INITIAL_X_POSITION = 400;
    private static final int MINIMUM_HEALTH = 0;

    public Game(){
        window = new GameViewer(this);
        tankOne = new Tank(TANK_ONE_INITIAL_X_POSITION, INITIAL_TANK_HEIGHT, "right", window,this);
        tankTwo = new Tank(TANK_TWO_INITIAL_X_POSITION, INITIAL_TANK_HEIGHT, "left", window,this);
        tankOne.setOtherTank(tankTwo);
        tankTwo.setOtherTank(tankOne);
        gameOver = false;
        window.repaint();
    }


    public void checkWin(){
        if (tankOne.getHealth() <= MINIMUM_HEALTH || tankTwo.getHealth() <= MINIMUM_HEALTH){
            gameOver = true;
        }
    }


    public Tank getTankOne() {
        return tankOne;
    }

    public Tank getTankTwo() {
        return tankTwo;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public static void main(String[] args) {
        Game a = new Game();
    }
}
