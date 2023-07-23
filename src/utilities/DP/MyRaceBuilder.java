package utilities.DP;

import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
/**
 * The MyRaceBuilder interface defines the contract for building a race.
 * It provides methods for constructing the list of racers and setting the arena,
 * as well as retrieving the built race object.
 */
public interface MyRaceBuilder
{
    /**
     * Builds the list of racers for the race.
     *
     * @throws RacerTypeException if there is an error in the racer types
     * @throws RacerLimitException if there is an error in the racer limit
     */
    public void BuildRacersList() throws RacerTypeException, RacerLimitException;
    /**
     * Builds the arena for the race.
     */
    public void BuildArena();
    /**
     * Retrieves the constructed race object.
     *
     * @return the constructed Race object
     */
    public Race getRace();
}
