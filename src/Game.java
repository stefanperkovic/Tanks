/**
 * Stefan Perkovic
 *
 * Game class creates two tanks and creates the arena for the game
 * It also checks when the game is finished
 */

public class Game {
    private GameViewer window;
    private Tank tankOne;
    private Tank tankTwo;
    private boolean gameOver;
    private static final int INITIAL_TANK_HEIGHT = 426;
    private static final int TANK_ONE_INITIAL_X_POSITION = 200;
    private static final int TANK_TWO_INITIAL_X_POSITION = 1000;
    private static final int MINIMUM_HEALTH = 0;
    private static final String TANK_ONE_DIRECTION = "right";
    private static final String TANK_TWO_DIRECTION = "left";

    public Game(){
        window = new GameViewer(this);
        tankOne = new Tank(TANK_ONE_INITIAL_X_POSITION, INITIAL_TANK_HEIGHT, TANK_ONE_DIRECTION, window,this);
        tankTwo = new Tank(TANK_TWO_INITIAL_X_POSITION, INITIAL_TANK_HEIGHT, TANK_TWO_DIRECTION, window,this);
        tankOne.setOtherTank(tankTwo);
        tankTwo.setOtherTank(tankOne);
        gameOver = false;
        window.repaint();
    }

    /**
     * Checks if either tank has died and ends the game if so
     */
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

    public static void main(String[] args) {
        Game a = new Game();
    }
}
