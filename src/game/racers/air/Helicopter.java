package game.racers.air;
import game.racers.Racer;
import utilities.EnumContainer.Color;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 * The Helicopter class represents a type of racer.
 * This class extends the Racer class and implements the AerialRacer interface.
 */
public class Helicopter extends Racer implements AirRacer {
    // fields
    private final static String CLASS_NAME ="Helicopter";
    private final static double MAX_SPEED =400;
    private final static double DEFAULT_ACCELERATION =50;
    private final static Color DEFAULT_color= Color.BLUE;
    /**
     Constructs a new Helicopter with the specified name, maximum speed, acceleration, and color.
     @param name The name of the helicopter.
     @param maxSpeed The maximum speed of the helicopter.
     @param acceleration The acceleration of the helicopter.
     @param color The color of the helicopter.
     */
     public Helicopter(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
    }
    /**
     Constructs a new Helicopter with default values for its name, maximum speed, acceleration, and color.
     */
    public Helicopter()
    {
        this("Helicopter#<"+getSerial(),MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_color);
    }
    /**
     Returns an empty string as the Helicopter class does not have any specific details to describe.
     */
    @Override
    public String describeSpecific() {
        return "";
    }
    /**
     Returns the name of the Helicopter class.
     */
    @Override
    public String className() {
        return "Helicopter";
    }
    /**
     Creates and returns a deep copy of the current Racer object.
     @return A new Racer object with the same properties as the current object.
     */
    public Racer clone() {
        return new Helicopter(this.getName(), this.getMaxSpeed(), this.getAcceleration(), this.getColor());
    }

}
