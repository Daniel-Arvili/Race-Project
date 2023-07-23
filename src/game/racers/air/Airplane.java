package game.racers.air;
import game.racers.Racer;
import game.racers.Wheeled;
import game.racers.air.AirRacer;
import utilities.EnumContainer.Color;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
The Airplane class represents a type of racer that can fly in the air and has wheels.
This class extends the Racer class and implements the AerialRacer interface.
 */
public class Airplane extends Racer implements AirRacer {
    // fields
    private final static String CLASS_NAME ="Airplane";
    private final static int DEFAULT_WHEELS =3;
    private final static double MAX_SPEED =885;
    private final static double DEFAULT_ACCELERATION =100;
    private final static Color DEFAULT_color=Color.BLACK;
    private Wheeled wheeled;
    /**
     Constructs a new Airplane with default values for its name, maximum speed, acceleration, color, and number of wheels.
     The default number of wheels is 3.
     */
    public Airplane(){
        super("Airplane#"+getSerial(),MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_color);
        wheeled=new Wheeled(DEFAULT_WHEELS);
    }
    /**
     Constructs a new Airplane with the specified name, maximum speed, acceleration, color, and number of wheels.
     @param name The name of the airplane.
     @param maxSpeed The maximum speed of the airplane.
     @param acceleration The acceleration of the airplane.
     @param color The color of the airplane.
     @param numOfWheels The number of wheels of the airplane.
     */
    public Airplane(String name, double maxSpeed, double acceleration, Color color, int numOfWheels){
        super(name,maxSpeed,acceleration,color);
        wheeled=new Wheeled(numOfWheels);
    }
    /**
     Returns a string describing the specific details of the Airplane class, which in this case is the number of wheels.
     */
    public String describeSpecific(){
        return wheeled.describeSpecific();
    }
    /**
     Returns the name of the Airplane class.
     */
    @Override
    public String className() {
        return "Airplane";
    }
    /**
     Creates and returns a deep copy of the current Racer object.
     @return A new Racer object with the same properties as the current object.
     */
    @Override
    public Racer clone() {
        return new Airplane(this.getName(),this.getMaxSpeed(), this.getAcceleration(),this.getColor(),wheeled.getNumofWheels());
    }
}



