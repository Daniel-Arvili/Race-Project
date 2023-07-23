package utilities.DP;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
/**
 * The Director class is responsible for constructing a race using a specific race builder.
 * It delegates the construction process to the provided race builder and retrieves the constructed race.
 */
public class Director {
    private MyRaceBuilder raceBuilder;
    /**
     * Constructs a Director object with the specified race builder.
     *
     * @param raceBuilder the race builder to be used for constructing the race
     */
    public Director(MyRaceBuilder raceBuilder){this.raceBuilder=raceBuilder;}
    /**
     * Retrieves the constructed race.
     *
     * @return the constructed Race object
     */
    public Race getRace(){
        return raceBuilder.getRace();
    }
    /**
     * Builds the race by executing the necessary steps in the race builder.
     *
     * @throws RacerTypeException if there is an error in the racer types
     * @throws RacerLimitException if there is an error in the racer limit
     */
    public void BuildRace() throws RacerTypeException, RacerLimitException {
        raceBuilder.BuildArena();
        raceBuilder.BuildRacersList();
    }
}
