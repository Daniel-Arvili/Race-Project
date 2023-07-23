package game.arenas.air;
import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.AirRacer;
import utilities.EnumContainer.Vision;
import utilities.EnumContainer.Weather;
import utilities.EnumContainer.Height;
import utilities.EnumContainer.Wind;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 * The AerialArena class represents an arena for aerial racing events.
 * It extends the Arena class and adds additional properties such as vision, weather, height, and wind.
 */
public class AerialArena extends Arena {
    // fields
    public final static double DEFAULT_FRICTION = 0.4;
    private final static int DEFAULT_MAX_RACERS = 6;
    private final static int DEFAULT_LENGTH = 1500;
     private Vision vision;
     private Weather weather;
     private Height height;

     private Wind wind;
    /**
     Constructs a new AerialArena object with given length and maximum racers.
     Default values for vision, weather, height, and wind are set.
     @param length The length of the arena
     @param maxRacers The maximum number of racers allowed in the arena
     */
     // constructors
     public AerialArena(double length,int maxRacers){
         super(length,maxRacers,DEFAULT_FRICTION);
         this.setVision(vision.SUNNY);
         this.setWeather(Weather.DRY);
         this.setHeight(Height.HiGH);
         this.setWind(Wind.HIGH);
     }
    /**
     Constructs a new AerialArena object with default length and maximum racers.
     Default values for vision, weather, height, and wind are set.
     */
      public AerialArena(){
          this(DEFAULT_LENGTH,DEFAULT_MAX_RACERS);
     }
    @Override
    /**
     * Function to add a racer, the function checks if the Racer is  type of AerialRacer,if not throws  exception.
     * @param newRacer (newRacer)
     * @throws RacerTypeException if have racer type problem
     */
    public void addRacer(Racer newracer) throws RacerLimitException, RacerTypeException {
        if(newracer instanceof AirRacer) {
            super.addRacer(newracer);
        }
        else
            throw new RacerTypeException(newracer.className(),"Aerial arena");
    }
     // set and get methods
    /**
     Returns the current wind level of the arena.
     */
     public Wind getWind(){
         return wind;
     }
    /**
     Sets the wind level for the arena.
     @param wind The wind level to be set
     @return true if the wind level was set successfully, false otherwise
     */
    public boolean setWind(Wind wind) {
        this.wind = wind;
        return true;
    }
    /**
     Returns the current vision level of the arena.
     */
    public Vision getVision(){
        return vision;
    }
    /**
     Sets the vision level for the arena.
     @param vision The vision level to be set
     */
    public boolean setVision(Vision vision) {
        this.vision= vision;
        return true;
    }
    /**
     Returns the current height level of the arena.
     */
    public Height getHeight(){
        return height;
    }
    /**
     Sets the height level for the arena.
     @param height The height level to be set
     */
    public boolean setHeight(Height height) {
        this.height = height;
        return true;
    }
    /**
     Returns the current weather level of the arena.
     */
    public Weather getWeather(){
        return weather;
    }
    /**
     Sets the weather level for the arena.
     @param weather The weather level to be set
     */
    public boolean setWeather(Weather weather) {
        this.weather = weather;
        return true;
    }

    
}
