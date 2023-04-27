import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Game {
    private GameViewer window;
    private Tank tankOne;
    private Tank tankTwo;
    private int turn;



    public Game(){
        tankOne = new Tank("PlayerOne", 200, 600);
        tankTwo = new Tank("PlayerOne", 200, 600);
        window = new GameViewer(this);
        turn = 0;
    }

    public void playGame(){
        window.paint(window.getGraphics());
        while (checkWin() == false){
            if (turn % 2 == 0){
                tankOne.setRound(true);
                playRound(tankOne);
                tankOne.setRound(false);
            }
            else{
                tankTwo.setRound(true);
                playRound(tankTwo);
                tankTwo.setRound(false);
            }
            turn += 1;
        }
    }

    public void playRound(Tank t){
        window.repaint();
    }

    public boolean checkWin(){
        if (tankOne.getHealth() == 0 || tankTwo.getHealth() == 0){
            return true;
        }
        else{
            return false;
        }
    }


    public Tank getTankOne() {
        return tankOne;
    }

    public Tank getTankTwo() {
        return tankTwo;
    }

    public static void main(String[] args) {
        Game a = new Game();
        a.playGame();
    }


}
