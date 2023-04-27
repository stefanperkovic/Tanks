public class Tank {
    private String name;
    private int x;
    private int y;
    private int health;
    private int gas;
    private int power;
    private boolean round;

    public Tank(String name, int x, int y){
        this.name = name;
        health = 100;
        gas = 250;
        power = 0;
        this.x = x;
        this.y = y;
        round = false;
    }

    public void shoot(int power){

    }

    public void move(){

    }

    public void aime(){

    }

    public void addPower(){

    }

    public void losePower(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
        this.gas = gas;
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
