package game.racers.land;
import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Engine;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 * this class responsible to build a game with arenas and racers
 */
public class Car extends Racer implements LandRacer {
    /**
     A class representing a car that extends the Racer class and implements the LandRacer interface.
     This class has a Wheeled and Engine instance as its member variables and can be instantiated with a specified number of wheels.
     It also has methods to get and set the engine type and describe the specific features of the car.
     */
    private final static String CLASS_NAME ="Car";
    private final static int DEFAULT_WHEELS =4;
    private final static double MAX_SPEED =400;
    private final static double DEFAULT_ACCELERATION =20;
    private final static Color DEFAULT_color= Color.RED;
    private Wheeled wheeled;
    private Engine engine;
    /**
     Returns the engine type of the car.
     */
    public Engine getEngine() {
        return engine;
    }
    /**
     Sets the engine type of the car.
     @param engine The engine type to set.
     */
    public boolean setEngine(Engine engine) {
        this.engine = engine;
        return true;
    }
    /**
     Constructs a car object with the specified name, maximum speed, acceleration, color and number of wheels.
     It also sets the engine type to Engine FORURSTROKE.
     @param name The name of the car.
     @param maxSpeed The maximum speed of the car.
     @param acceleration The acceleration of the car.
     @param color The color of the car.
     @param numOfWheels The number of wheels the car has.
     */
     public Car(String name, double maxSpeed, double acceleration, Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheels);
        this.setEngine(Engine.FOURSTROKE);
    }
    /**
     Constructs a car object with default values.
     It sets the name to "Car#<serial number>", maximum speed to 400, acceleration to 20 ,
     color to RED and number of wheels to 4.
     */
    public Car()
    {
        this("Car #"+getSerial(),MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_color,DEFAULT_WHEELS);
    }
    /**
     Returns a string describing the specific features of the car, i.e. the number of wheels and engine type.
     */
    @Override
    public String describeSpecific() {
        return wheeled.describeSpecific()+" Engine Type: "+getEngine();
    }
    /**
     Returns the name of the class.
     */
    @Override
    public String className() {
        return CLASS_NAME;
    }
    /**
     Creates and returns a deep copy of the current Racer object.
     @return A new Racer object with the same properties as the current object.
     */
    public Racer clone() {
        return new Car(this.getName(), this.getMaxSpeed(), this.getAcceleration(), this.getColor(),wheeled.getNumofWheels());
    }
}
