package utilities.DP;

import game.arenas.Arena;
import game.arenas.air.AerialArena;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;

/**
 * The ArenaFactoryMethod class is responsible for creating different types of arenas
 * based on the given condition.
 * It follows the Factory Method design pattern to encapsulate the creation of
 * arena objects and provide a common interface for creating arenas.
 */
public class ArenaFactoryMethod {

    /**
     * Creates an arena object based on the given condition and number of participants.
     *
     * @param condition the condition specifying the type of arena to create
     * @param num the number of participants in the arena
     * @return   the created Arena object
     */
    public Arena getArena(String condition, int num) {
        Arena chosen = null;

        if ("Land".equals(condition)) {
            chosen = new LandArena(800, num);
        } else if ("Aerial".equals(condition)) {
            chosen = new AerialArena(1500, num);
        } else {
            chosen = new NavalArena(1000, num);
        }

        return chosen;
    }
}

