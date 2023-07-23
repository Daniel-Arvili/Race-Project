package game.racers.land;
import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.BicycleType;
import utilities.EnumContainer.Color;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
A class representing a bicycle that extends the Racer class and implements the LandRacer interface.
This class has a Wheeled and Type instance as its member variables and can be instantiated with a specified number of wheels.
It also has methods to get and set the bicycle type and describe the specific features of the bicycle.
 */
public class Bicycle extends Racer implements LandRacer {
    private final static String CLASS_NAME ="Bicycle";
    private final static int DEFAULT_WHEELS =2;
    private final static double MAX_SPEED =270;
    private final static double DEFAULT_ACCELERATION =10;
    private final static Color DEFAULT_color= Color.GREEN;
    private Wheeled wheeled;
    private BicycleType type;
    /**
     Constructs a bicycle object with the specified name, maximum speed, acceleration, color and number of wheels.
     It also sets the bicycle type to Type.MOUNTAIN.
     @param name The name of the bicycle.
     @param maxSpeed The maximum speed of the bicycle.
     @param acceleration The acceleration of the bicycle .
     @param color The color of the bicycle.
     @param numOfWheels The number of wheels the bicycle has.
     */
    public Bicycle(String name, double maxSpeed, double acceleration, Color color, int numOfWheels)
    {
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheels);
        this.setType(BicycleType.MOUNTAIN);
    }
    /**
     Constructs a bicycle object with default values.
     It sets the name to "Bicycle#<serial number>", maximum speed to 270 , acceleration to 10 ,
     color to GREEN and number of wheels to 2.
     */
    public Bicycle()
    {
        this("Bicycle #"+getSerial(),MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_color,DEFAULT_WHEELS);
    }
    /**
     Returns the name of the class.
     */
    public String className() {
        return CLASS_NAME;
    }
    /**
     Returns a string describing the specific features of the bicycle, the number of wheels and bicycle type.
     */
    public String describeSpecific() {
        return wheeled.describeSpecific()+" Bicycle Type "+getType();
    }
    /**
     Returns the type of the bicycle.
     */
    public BicycleType getType() {
        return type;
    }
    /**
     Sets the type of the bicycle.
     @param type The type to set.
     */
    public boolean setType(BicycleType type) {
        this.type = type;
        return true;
    }
    /**
     Creates and returns a deep copy of the current Racer object.
     @return A new Racer object with the same properties as the current object.
     */
    public Racer clone() {
        return new Bicycle(this.getName(), this.getMaxSpeed(), this.getAcceleration(), this.getColor(),wheeled.getNumofWheels());
    }
}
