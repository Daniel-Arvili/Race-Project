package game.arenas.naval;
import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.AirRacer;
import game.racers.naval.NavalRacer;
import utilities.EnumContainer.Water;
import utilities.EnumContainer.WaterSurface;
import utilities.EnumContainer.Body;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 * A class representing a Naval Arena for boat races.
 * Extends Arena class and adds attributes for Water, Surface and Body of water in the arena.
 */
public class NavalArena extends Arena {
    // fields
    public final static double DEFAULT_FRICTION = 0.7;
    private final static int DEFAULT_MAX_RACERS = 5;
    private final static int DEFAULT_LENGTH = 1000;
    private Water water;
    private WaterSurface surface;
    private Body Body;
    /**
     Adds a new racer to the arena.
     Throws RacerTypeException if the racer is not a type of NavalRacer.
     @param newracer The new racer to add to the arena.
     @throws RacerLimitException If the maximum number of racers has already been reached.
     @throws RacerTypeException If the new racer is not a type of NavalRacer.
     */
    public void addRacer(Racer newracer) throws RacerLimitException, RacerTypeException {
        if(newracer instanceof NavalRacer) {
            super.addRacer(newracer);
        }
        else
            throw new RacerTypeException(newracer.className(),"Naval arena");    }
     // constructors
    /**
     Constructs a new NavalArena object with default length of 1000 and maximum number of racers of 5.
     Sets the default values for Water, Surface and Body.
     */
     public NavalArena(){
        this(DEFAULT_LENGTH,DEFAULT_MAX_RACERS);
    }
    /**
     Constructs a new NavalArena object with the specified length and maximum number of racers.
     Sets the default values for Water, Surface and Body.
     @param length The length of the arena.
     @param maxRacers The maximum number of racers allowed in the arena.
     */
    public NavalArena(double length,int maxRacers){
        super(length,maxRacers,DEFAULT_FRICTION);
        this.setWater(Water.SWEET);
        this.setSurface(WaterSurface.FLAT);
        this.setBody(Body.LAKE);
    }
    /**
     Returns the current water type in the arena.
     */
    public Water getWater(){
        return water;
    }
    /**
     Sets the water type for the arena.
     @param water The type of water to set.
     */
    public boolean setWater(Water water) {
        this.water = water;
        return true;
    }
    /**
     Returns the current surface type in the arena.
     */
    public WaterSurface getSurface(){
        return surface;
    }
    /**
     Sets the surface type for the arena.
     @param surface The type of surface to set.
     */
    public boolean setSurface(WaterSurface surface) {
        this.surface= surface;
        return true;
    }
    /**
     Returns the current body of water type in the arena.
     */
    public Body getBody(){
        return Body;
    }
    /**
     Sets the body of water type for the arena.
     @param body The type of body of water to set.
     */
    public boolean setBody(Body body) {
        this.Body = body;
        return true;
    }
}
