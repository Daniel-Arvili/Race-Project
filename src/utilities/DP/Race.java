package utilities.DP;
import game.arenas.Arena;
import game.racers.Racer;
import java.util.ArrayList;

/**
 * The Race class represents a race event that takes place in a specific arena
 * with a group of racers.
 */
public class Race {
    private ArrayList<Racer> myRacers;
    private Arena myArena;

    /**
     * Sets the list of racers for the race.
     *
     * @param racers the list of racers participating in the race
     */
    public void setRacersList(ArrayList<Racer> racers) {
        this.myRacers = racers;
    }

    /**
     * Sets the arena for the race.
     *
     * @param arena the arena where the race takes place
     */
    public void setArena(Arena arena) {
        this.myArena = arena;
    }

    /**
     * Returns the list of racers participating in the race.
     *
     * @return the list of racers for the race
     */
    public ArrayList<Racer> getMyRacers() {
        return myRacers;
    }

    /**
     * Returns the arena where the race takes place.
     *
     * @return the arena for the race
     */
    public Arena getMyArena() {
        return myArena;
    }
}
