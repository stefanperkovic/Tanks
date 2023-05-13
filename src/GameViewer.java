/**
 * Stefan Perkovic
 *
 * Creates the Window for the Tank Game
 * Handles the user input between both tanks
 * Uses KeyListener to take in the user impact
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameViewer extends JFrame implements KeyListener {
    private Game game;
    private Image background;
    private Image camo;
    private boolean inInstructions;
    private static final int WINDOW_WIDTH = 2000;
    private static final int WINDOW_HEIGHT = 800;
    private static final int INSTRUCTIONS_X = 500;
    private static final int HEADER_HEIGHT = 50;



    public GameViewer(Game game){
        background = new ImageIcon("Resources/background.png").getImage();
        camo = new ImageIcon("Resources/camo.jpeg").getImage();
        this.game = game;
        inInstructions = true;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tanks");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        addKeyListener(this);
    }

    /**
     * Draws the game window in whatever state it is in
     */
    public void paint(Graphics g){

        // Checks if the user is in the instructions screen, if so prints it
        if (inInstructions == true){
            printInstructions(g);
        }

        // Checks if the game is over
        // Prints the winner of the game
        else if(game.isGameOver() == true){
            if (game.getTankOne().getHealth() == 0){
                setUpWin(g);
                g.drawString("Tank 2 Wins!!!!!!", 400, 400);
            }
            else{
                setUpWin(g);
                g.drawString("Tank 1 Wins!!!!!!", 400, 400);
            }

        }
        // Prints the current state of the game with both tanks
        else{
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            if (game.getTankOne() != null){
                tankOneAttributes(g);
            }
            if (game.getTankTwo() != null){
                tankTwoAttributes(g);
            }
        }

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Creates the starting page
     * Prints the instructions for the game
     */
    public void printInstructions(Graphics g){
        g.drawImage(camo, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 50));
        g.drawString("How to Play", 60, 100);
        g.setFont(new Font("Serif", Font.PLAIN, 50));
        g.drawString("Left and Right Arrow to Move", INSTRUCTIONS_X, 225);
        g.drawString("S to Shoot", INSTRUCTIONS_X, 275);
        g.drawString("P to Add Power", INSTRUCTIONS_X, 350);
        g.drawString("L to Lower Power", INSTRUCTIONS_X, 400);
        g.drawString("A to increase Angle", INSTRUCTIONS_X, 475);
        g.drawString("D to Decrease Angle", INSTRUCTIONS_X, 525);
        g.drawString("Space to Start", INSTRUCTIONS_X, 700);
    }

    /**
     * Sets up the page for the win message
     */
    public void setUpWin(Graphics g){
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Serif", Font.PLAIN, 100));
    }

    /**
     * Draws the header for tank 1 and the tank itself
     */
    public void tankOneAttributes(Graphics g){
        g.drawString("Tank 1 Power: " + game.getTankOne().getPower(), 25, HEADER_HEIGHT);
        g.drawString("Angle: " + game.getTankOne().getAngle(), 185, HEADER_HEIGHT);
        g.drawString("Gas: " + game.getTankOne().getGas(), 280, HEADER_HEIGHT);
        g.drawString("Health: " + game.getTankOne().getHealth(), 360, HEADER_HEIGHT);
        g.drawImage(game.getTankOne().getTankImage(), game.getTankOne().getX(), game.getTankOne().getY(), 200, 200, this);
    }

    /**
     * Draws the header for tank 2 and the tank itself
     */
    public void tankTwoAttributes(Graphics g){
        g.drawString("Tank 2 Power: " + game.getTankTwo().getPower(), 1000, HEADER_HEIGHT);
        g.drawString("Angle: " + game.getTankTwo().getAngle(), 1160, HEADER_HEIGHT);
        g.drawString("Gas: " + game.getTankTwo().getGas(), 1255, HEADER_HEIGHT);
        g.drawString("Health: " + game.getTankTwo().getHealth(), 1335, HEADER_HEIGHT);
        g.drawImage(game.getTankTwo().getTankImage(), game.getTankTwo().getX(), game.getTankTwo().getY(), 200, 200, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Takes in user input through the keys
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Tank t;

        // Checks what tank is currently taking input
        if (game.getTankOne().isRound() == false){
            t = game.getTankTwo();
        }
        else{
            t = game.getTankOne();
        }
        // Moves the tank left
        if(keyCode == KeyEvent.VK_LEFT)
        {
            t.moveLeft();
        }
        // Moves tank right
        else if(keyCode == KeyEvent.VK_RIGHT)
        {
            t.moveRight();
        }
        // Adds power
        else if (keyCode == KeyEvent.VK_P){
            t.changePower(10);
        }
        // Lowers power
        else if (keyCode == KeyEvent.VK_L){
            t.changePower(-10);
        }
        // Shoots and changes round
        else if (keyCode == KeyEvent.VK_S){
            t.changeRound();
        }
        // Increase angle
        else if(keyCode == KeyEvent.VK_A){
            t.setAngle(1);
        }
        // Decreases angle
        else if(keyCode == KeyEvent.VK_D){
            if (t.getAngle() > 0){
                t.setAngle(-1);
            }
        }
        // Close instructions screen
        else if(keyCode == KeyEvent.VK_SPACE){
            inInstructions = false;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
