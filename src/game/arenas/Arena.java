package game.arenas;
import game.arenas.exceptions.*;
import game.racers.Racer;
import utilities.EnumContainer;
import utilities.Myobservable;
import utilities.Myobserver;
import utilities.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
The Arena class represents a race arena where racers compete in a race.
The arena is responsible for managing the race and the racers.
The class has two ArrayLists to keep track of the active racers and the completed racers.
The class is abstract since there are different types of arenas (e.g., land, air, and naval).
Each arena has a length, a maximum number of racers, and a friction value.
The class has methods to add a racer to the active racers list, initialize the race, play a turn, and cross the finish line.
 */
public abstract class Arena implements Myobserver {
    /**
     class that describes arena
     */
    //fields
    private ArrayList<Racer> activeRacers;
    private ArrayList<Racer> completedRacers;
    private ArrayList<Racer> brokenRacers;
    private ArrayList<Racer> disableRacers;
    private final double FRICTION;
    private final int MAX_RACERS;
    private static final int MIN_Y_GAP = 60;
    private double length;

    // constructors
    /**
     Creates a new Arena with the given length, maximum number of racers, and friction value.
     Initializes the completed racers and active racers ArrayLists.
     @param length The length of the arena.
     @param maxRacers The maximum number of racers allowed in the arena.
     @param friction The friction value in the arena.
     */
    public Arena(double length, int maxRacers, double friction) {
        this.setLength(length);
        this.MAX_RACERS = maxRacers;
        this.FRICTION = friction;
        this.setCompletedRacers(new ArrayList<>());
        this.setActiveRacers(new ArrayList<>());
        this.setBrokenRacers(new ArrayList<>());
        this.setDisableRacers(new ArrayList<>());
    }
    //methods
    /**
     Returns the length of the arena.
     */
    public double getLength() {
        return length;
    }
    /**
     Returns the maximum number of racers allowed in the arena.
     */
    public int getMAX_RACERS() {
        return MAX_RACERS;
    }
    /**
     Returns the ArrayList of active racers.
     */
    public ArrayList<Racer> getActiveRacers() {
        return activeRacers;
    }
    /**
     Returns the friction value in the arena.
     */
    public double getFRICTION() {
        return FRICTION;
    }
    /**
     Returns the ArrayList of completed racers.
     */
    public ArrayList<Racer> getCompletedRacers() {
        return completedRacers;
    }
    /**
     Sets the completed racers ArrayList.
     @param completedRacers The ArrayList of completed racers.
     @return true if the completed racers ArrayList was set successfully, false otherwise.
     */
    public boolean setCompletedRacers(ArrayList<Racer> completedRacers) {
        this.completedRacers = completedRacers;
        return true;
    }
    /**
     Returns the list of disabled racers.
     */
    public ArrayList<Racer> getDisableRacers() {
        return disableRacers;
    }
    /**
     Returns the list of broken racers.
     */
    public ArrayList<Racer> getBrokenRacers() {
        return brokenRacers;
    }

    /**
     Sets the active racers ArrayList.
     @param activeRacers The ArrayList of active racers.
     @return true if the active racers ArrayList was set successfully, false otherwise.
     */
    public boolean setActiveRacers(ArrayList<Racer> activeRacers) {
        this.activeRacers = activeRacers;
        return true;
    }
    /**
     * set the Broken racers list  and return true
     */
    public boolean setBrokenRacers(ArrayList<Racer> brokenRacers) {
        this.brokenRacers = brokenRacers;
        return true;
    }
    /**
     * set the Disable racers list  and return true
     */
    public boolean setDisableRacers(ArrayList<Racer> disableRacers) {
        this.disableRacers = disableRacers;
        return true;
    }
/**
 * set the length and return true
 */
    public boolean setLength(double length) {
        this.length = length;
        return true;
    }

    /**
     Adds a new Racer to the list of active racers.
     Throws an exception if the maximum number of racers has already been reached or the Racer type is not supported.
     @param newRacer the Racer to add.
     @throws RacerTypeException if the Racer type is not supported.
     @throws RacerLimitException if the maximum number of racers has already been reached.
     */
    public void addRacer(Racer newracer) throws RacerLimitException,RacerTypeException {
        if(this.getActiveRacers().size()+1>this.getMAX_RACERS())
            throw new RacerLimitException(this.getMAX_RACERS(),newracer.getSerialNumber());
        newracer.register(this);
        this.getActiveRacers().add(newracer);
    }
    /**
     Initializes the race for all active racers, setting their starting and ending points on the track.
     */
    public void initRace() {
        int x=0;
        for (int i = 0; i < this.getActiveRacers().size(); i++) {
            this.getActiveRacers().get(i).initRace(this, new Point(0, x), new Point(this.getLength(),x));
            x+=MIN_Y_GAP;
        }
    }
    /**
     Checks whether there are any active racers in the race.
     */
    public boolean hasActiveRacers() {
        return !(this.getActiveRacers().isEmpty());
    }
    /**
     Checks whether there are any broken racers in the race.
     */
    public boolean hasBrokenRacers() {
        return !(this.getBrokenRacers().isEmpty());
    }
    /**
     Moves all active racers by one turn, and checks if any of them have crossed the finish line.
     If a racer has crossed the finish line, it is moved to the completed racers list and removed from the active racers list.
     */
    public void playTurn() {
        for(int i=0;i<this.getActiveRacers().size();i++)
        {
            this.getActiveRacers().get(i).move(getFRICTION());
            if(this.getActiveRacers().get(i).getCurrentLocation().getX()>=getLength())
            {
                crossFinishLine(this.getActiveRacers().get(i));
                i--;
            }
        }
    }
    /**
     Moves a racer from the active racers list to the completed racers list when they have crossed the finish line.
     @param racer the racer to move to the completed racers list and removed from the active racers list.
     */
    public void crossFinishLine(Racer racer) {
        this.getCompletedRacers().add(racer);
        this.getActiveRacers().remove(racer);
    }
    /**
     Prints out the results of the race, listing all completed racers and their description.
     */
    public void showResults()
    {
        for(int i=0;i<this.getCompletedRacers().size();i++ )
        {
            System.out.println("#"+i+"-> "+this.getCompletedRacers().get(i).describeRacer()+this.getCompletedRacers().get(i).describeSpecific());
        }
    }
    /**
     This method updates the state of the race once a racer has finished the race.
     It is synchronized to prevent concurrent updates by multiple racers.
     */
    @Override
    public synchronized void update(Myobservable o) { // notified by the racer that finished the race
       ((Racer) o).alert();
    }
}

