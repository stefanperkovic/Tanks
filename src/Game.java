import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Game {
    private GameViewer window;
    private Tank tankOne;
    private Tank tankTwo;
    private int turn;



    public Game(){
        window = new GameViewer(this);
        tankOne = new Tank("PlayerOne", 200, 400, window,this);
        tankTwo = new Tank("PlayerTwo", 1000, 400, window,this);
        tankOne.setOtherTank(tankTwo);
        tankTwo.setOtherTank(tankOne);
        turn = 0;
    }

    public void playGame() {
        window.repaint();
        while (checkWin() == false) {


//            if (turn % 2 == 0){
//                tankOne.setRound(true);
//                playRound(tankOne);
//                tankOne.setRound(false);
//            }
//            else{
//                tankTwo.setRound(true);
//                playRound(tankTwo);
//                tankTwo.setRound(false);
//            }
//            turn += 1;
        }
    }

//    public void playRound(Tank t){
//        while(true){
//
//
//
//
//            break;
//        }
//        window.repaint();
//    }

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
