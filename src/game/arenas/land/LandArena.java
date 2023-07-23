package game.arenas.land;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.AirRacer;
import game.racers.land.LandRacer;
import utilities.EnumContainer.Coverage;
import utilities.EnumContainer.LandSurface;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
The LandArena class represents a land arena in a racing game.
It contains information about the coverage and surface of the arena.
It also overrides the addRacer method to only allow adding land racers to the arena.
 */
public class LandArena extends Arena {
    // fields
    public final static double DEFAULT_FRICTION = 0.5;
    private final static int DEFAULT_MAX_RACERS = 8;
    private final static int DEFAULT_LENGTH = 800;
    private Coverage coverage;
    private LandSurface surface;

    /**
     Overrides the addRacer method in the superclass to only allow adding LandRacer objects to the arena.
     @param newracer The racer to add to the arena
     @throws RacerLimitException If the maximum number of racers for the arena has been reached
     @throws RacerTypeException If the racer being added is not a LandRacer
     */
    public void addRacer(Racer newracer) throws RacerLimitException, RacerTypeException {
        if(newracer instanceof LandRacer) {
            super.addRacer(newracer);
        }
        else
            throw new RacerTypeException(newracer.className(),"Land arena");
    }

    /**
     Constructs a new LandArena object with default values of length 800 and maxRacers 8.
     Sets coverage to GRASS and surface to FLAT.
     */
     public LandArena(){
        this(DEFAULT_LENGTH,DEFAULT_MAX_RACERS);
    }
    /**
     Constructs a new LandArena object with the given length and maxRacers.
     Sets coverage to GRASS and surface to FLAT.
     @param length The length of the arena
     @param maxRacers The maximum number of racers allowed in the arena
     */
      public LandArena(double length,int maxRacers){
        super(length,maxRacers,DEFAULT_FRICTION);
        this.setCoverage(Coverage.GRASS);
        this.setSurface(LandSurface.FLAT);
    }
    // set and get methods
    /**
     Returns the type of coverage on the arena.
     */
    public Coverage getCoverage(){
        return coverage;
    }
    /**
     Sets the type of coverage on the arena.
     @param coverage The type of coverage on the arena
     */
    public boolean setCoverage(Coverage coverage) {
        this.coverage = coverage;
        return true;
    }
    /**
     Returns the type of surface on the arena.
     */
    public LandSurface getSurface(){
        return surface;
    }
    /**
     Sets the type of surface on the arena.
     @param surface The type of surface on the arena
     */
    public boolean setSurface(LandSurface surface) {
        this.surface= surface;
        return true;
    }

}
