package game.arenas.exceptions;

import game.racers.Racer;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 * An exception that is thrown when the maximum limit of racers in an arena has been reached.
 */
public class RacerLimitException extends Exception {

    /**
     Constructs a new RacerLimitException with the given maximum limit of racers and serial number of the racer that could not be added.
     @param maxracers the maximum number of racers allowed in the arena
     @param serialnumber the serial number of the racer
     */
    public RacerLimitException(int maxracers,int serialnumber)
    {
        super("Arena is full! ("+maxracers+" racers exists). racer #"+serialnumber+" was not added");

    }
}
