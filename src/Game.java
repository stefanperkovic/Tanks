import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Game {
    private GameViewer window;
    private Tank tankOne;
    private Tank tankTwo;
    private boolean gameOver;


    public Game(){
        window = new GameViewer(this);
        tankOne = new Tank("PlayerOne", 200, 426, "right", window,this);
        tankTwo = new Tank("PlayerTwo", 1000, 426, "left", window,this);
        tankOne.setOtherTank(tankTwo);
        tankTwo.setOtherTank(tankOne);
        gameOver = false;
    }

    public void playGame() {
        window.repaint();
    }


    public void checkWin(){
        if (tankOne.getHealth() <= 0 || tankTwo.getHealth() <= 0){
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
        a.playGame();
    }


}
