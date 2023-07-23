package game.arenas.exceptions;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 * RacerTypeException is thrown when attempting to add a racer that is not compatible with a specific arena.
 */
public class RacerTypeException extends Exception {
    /**
     Constructs a new RacerTypeException with the specified parameters.
     @param classname the name of the class of the invalid racer
     @param arenaname the name of the arena
     */
    public RacerTypeException(String classname,String arenaname)
    {
      super("Invalid Racer of type "+classname+" for "+arenaname);
    }
}
