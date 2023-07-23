package game.racers;
import game.arenas.Arena;
import utilities.DP.*;
import utilities.EnumContainer.Color;
import utilities.Mishap;
import utilities.Point;
import utilities.Fate;
import utilities.Myobservable;
import java.util.PropertyResourceBundle;
import java.util.Random;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 * this class responsible to build a game with arenas and racers
 */
public abstract class Racer extends Myobservable implements Runnable,Cloneable  {
    /**
     The Racer abstract class represents a racer in a race.
     It contains basic attributes and methods that are common to all types of racers.
     */
    // fields
    private static int serial=1;
    private int serialNumber;
    private String name;
    private Point currentLocation;
    private Point finish;
    private Arena arena;
    private double maxSpeed;
    private double acceleration;
    private double currentSpeed;
    private double failureProbability; // chance to break down
    private Color color;
    private Mishap mishap;
    private RacerAlertState state;
    private static Random rnd=new Random();
    boolean failure;
    double breaklocation;
    /**
     Constructs a new Racer with the given name, maximum speed, acceleration, and color.
     @param name the name of the Racer.
     @param maxSpeed the maximum speed of the Racer.
     @param acceleration the acceleration of the Racer.
     @param color the color of the Racer.
     */
    public Racer(String name, double maxSpeed, double acceleration, Color color){
        this.setSerialNumber(getSerial());
        this.setName(name);
        this.setMaxSpeed(maxSpeed);
        this.setAcceleration(acceleration);
        this.setColor(color);
        state=new ActiveState(); // initialize state
        failureProbability= (int)rnd.nextInt(2);
            System.out.println("failureProbability for racer "+name+ " : "+failureProbability);
        serial++;
    }
    /**
     Initializes the race with the given Arena, starting Point, and finishing Point.
     @param arena the Arena in which the race takes place.
     @param start the starting Point of the Racer.
     @param finish the finishing Point of the Racer.
     */
     public void initRace (Arena arena,Point start,Point finish)
    {
        this.setArena(arena);
        this.setCurrentLocation(start);
        this.setFinish(finish);
    }
    /**
     Creates and returns a copy of this racer.
     @return A copy of this racer.
     */
    public abstract Racer clone();
    /**
     Upgrades the color of the racer.
     @param color The new color to set for the racer.
     */
    public void upgrade(Color c)
    {
            this.setColor(c);
    }
    /**
     Moves the Racer based on the given friction and the Racer's current status.
     @param friction the friction of the race track.
     @return the new location of the Racer after moving.
     */
    public void move(double friction) {
        double reductionFactor = 1;
        if (!(this.hasMishap()) && Fate.breakDown()) {
            this.mishap = Fate.generateMishap();
            System.out.println(this.getName()+" Has a new mishap!: "+this.getMishap());
        }

        if (this.hasMishap()) {
            reductionFactor = mishap.getReductionFactor();
            this.mishap.nextTurn();
        }
        if (this.currentSpeed < this.maxSpeed) {
            this.currentSpeed += this.acceleration * friction * reductionFactor;
        }
        if (this.currentSpeed > this.maxSpeed) {
            this.currentSpeed = this.maxSpeed;
        }
        double newX = (this.currentLocation.getX() + (this.currentSpeed));
        if (newX>this.finish.getX())
            newX = this.finish.getX();
        Point newLocation = new Point(newX, this.currentLocation.getY());
        this.currentLocation = newLocation;
    }


    public abstract String describeSpecific(); // use for specific heirs
    /**
     Describes the Racer's basic attributes.
     @return a string representing the Racer's basic attributes.
     */
    public String describeRacer(){
        return "name: "+getName()+" ,SerialNumber: "+getSerialNumber()+",maxSpeed: "+getMaxSpeed()+" ,acceleration: "+getAcceleration()+" ,color "+getColor();
    }
    /**
     Prints the Racer's description to the console.
     */
    public void introduce(){
        System.out.println("["+className()+"] "+describeRacer()+describeSpecific());
    }
    /**
     * Returns a string representation of the specific attributes of the racer object.
     */
    public abstract String className();
    /**
     * Returns the name of the racer.
     */
    public String getName() {
        return name;
    }
    /**
     * Set the name the racers.
     */
    public boolean setName(String name) {
        this.name = name;
        return true;
    }
    /**
     * Return the current location of the racers.
     */
    public Point getCurrentLocation() {
        return currentLocation;
    }
    /**
     * Set the current location of the racers.
     */
    public boolean setCurrentLocation(Point currentLocation) {
        this.currentLocation=new Point(currentLocation);
        return true;
    }
    /**
     * Return the finish location of the race.
     */
    public Point getFinish() {
        return finish;
    }
    /**
     * Set the finish location of the race.
     */
    public boolean setFinish(Point finish) {
        this.finish=new Point(finish);
        return true;
    }
    /**
     * Return the arena of the race.
     */
    public Arena getArena() {
        return arena;
    }
    /**
     * Set the arena of the race.
     */
    public boolean setArena(Arena arena) {
        this.arena = arena;
        return true;
    }
    /**
     * Return the max speed of the racer.
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }
    /**
     * Set the max speed of the racer.
     */
    public boolean setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        return true;
    }
    /**
     * Return the accelertion of the racer.
     */
    public double getAcceleration() {
        return acceleration;
    }
    /**
     * Set the accelertion of the racer.
     */
    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }
    /**
     * Return the current speed of the racer.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    /**
     * Set the current speed of the racer.
     */
    public boolean setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
        return true;
    }
    /**
     * Return the failure probability of the racer.
     */
    public double getFailureProbability() {
        return failureProbability;
    }
    /**
     * Set the failure probability of the racer.
     */
    public boolean setFailureProbability(double failureProbability) {
        this.failureProbability = failureProbability;
        return true;
    }
    /**
     * Return the color of the racer.
     */
    public Color getColor(){
        return color;
    }
    /**
     * Set the color of the racer.
     */
    public boolean setColor(Color color){
        this.color=color;
        return true;
    }
    /**
     * Returns the serial number of the racer.
     */
    public int getSerialNumber() {
        return serialNumber;
    }
    /**
     * Returns the serial number of all the racers.
     */
    public static int getSerial()
    {
        return serial;
    }
    /**
     * Set the serial number of the racer.
     */
    public boolean setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
        return true;
    }
    /**
     * Return the mishap of the racer
     */
    public Mishap getMishap(){
        return mishap;
    }
    /**
     * Set a new Mishap for the racer.
     */
    public boolean setMishap(Mishap mishap){
        if(mishap!=null)
            this.mishap = new Mishap(mishap.getFixable(), mishap.getTurnsToFix(), mishap.getReductionFactor());
        else
            this.mishap=null;
        return true;
    }
    /**
     Checks if the Racer has a mishap.
     */
    private boolean hasMishap() {
        if (this.mishap != null && this.mishap.getTurnsToFix() == 0)
            this.mishap = null;
        return this.mishap != null;
    }
    /**
     Checks if the racer has finished the race.
     @return true if the racer has reached or passed the finish line, false otherwise.
     */
    public boolean isfinished()
    {
        return this.getCurrentLocation().getX()>=this.getFinish().getX();
    }
    /**
     Alerts the racer's state.
     This method triggers the current state's alert behavior.
     */
    public void alert()
    {
        state.alert(this);
    }
    /**
     Sets the state of the racer.
     @param state The state to set for the racer.
     */
    public void setState(RacerAlertState state){this.state=state;}
    /**
     Runs the racer in the race.
     The racer will move and check for any failures until it reaches the finish line.
     It handles failure scenarios, updates the racer's state accordingly, and notifies observers of changes.
     */
    public void run()
    {
        long startTime = System.currentTimeMillis();
        int disableProbabilty=-1;
        if(failureProbability==1) {
            breaklocation = rnd.nextInt((int) this.getArena().getLength()-100) + 100;
            System.out.println("breaklocation for racer "+this.getName()+ " : "+breaklocation);
             disableProbabilty=rnd.nextInt(3)+0;
        }
        while (this.currentLocation.getX()<this.getArena().getLength())
        {
            try {
                if(failureProbability==1 && this.getCurrentLocation().getX()>=breaklocation)
                {
                    this.failureProbability=0;
                    if(disableProbabilty==0) {
                        setState(new DisableState());
                        notifyObservers();
                        return;
                    }
                    else
                    {
                        long endTime = System.currentTimeMillis();
                        long executionTime = endTime - startTime;
                        System.out.println("============");
                        System.out.println("Racer "+ this.getName()+ " has break down after: "+executionTime/1000.00+" seconds");
                        System.out.println("===========");
                        setState(new InjuredState());
                        notifyObservers();
                        Thread.sleep(3000);
                        setState(new ActiveState());
                        notifyObservers();
                    }
                }
                this.move(this.arena.getFRICTION());
                //System.out.println(this.getCurrentLocation());
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.setState(new CompleteState()); // set to complete state
        notifyObservers(); // notify to arena that the racer was finished!
    }
}

