package game.racers.land;
import game.racers.Racer;
import game.racers.Wheeled;
import game.racers.air.Helicopter;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Breed;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
The Horse class represents a type of land racer that is a subclass of Racer and implements the LandRacer interface.
It has properties such as name, max speed, acceleration, color and breed.
 */
public class Horse extends Racer implements LandRacer {
    //fields
    private final static String CLASS_NAME ="Horse";
    private final static double MAX_SPEED =50;
    private final static double DEFAULT_ACCELERATION =3;
    private final static Color DEFAULT_color= Color.BLACK;
    private Breed breed;
    /**
     Constructs a Horse object with the given name, max speed, acceleration and color, and sets the breed to THOROUGHBRED.
     @param name the name of the Horse
     @param maxSpeed the maximum speed of the Horse
     @param acceleration the acceleration of the Horse
     @param color the color of the Horse
     */
    public Horse(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
        this.setBreed(Breed.THOROUGHBRED);
    }
    /**
     Constructs a Horse object with default values, where the name is "Horse#" followed by a unique serial number,
     the maximum speed is 50, the acceleration is 3, and the color is black. It also sets the breed to THOROUGHBRED.
     */
    public Horse()
    {
        this("Horse #"+getSerial(),MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_color);
    }
    /**
     Returns the breed of the Horse object.
     */
    public Breed getBreed() {
        return breed;
    }
    /**
     Sets the breed of the Horse object to the given breed.
     @param breed the breed to set for the Horse object
     */
    public boolean setBreed(Breed breed) {
        this.breed = breed;
        return true;
    }
    /**
     Returns a description of the specific properties of the Horse object.
     */
    @Override
    public String describeSpecific() {
         return " Breed "+getBreed();
    }
    /**
     Returns the class name of the Horse object.
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
        return new Horse(this.getName(), this.getMaxSpeed(), this.getAcceleration(), this.getColor());
    }
}
