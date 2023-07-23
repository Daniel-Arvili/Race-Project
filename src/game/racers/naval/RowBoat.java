package game.racers.naval;
import game.racers.Racer;
import game.racers.land.Car;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Team;
import utilities.EnumContainer.BoatType;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
A class that represents a rowing boat, which is a type of naval racer.
It extends the Racer class and implements the NavalRacer interface.
 */
public class RowBoat extends Racer implements NavalRacer {
    private final static String CLASS_NAME ="RowBoat";
    private final static double MAX_SPEED =75;
    private final static double DEFAULT_ACCELERATION =10;
    private final static Color DEFAULT_color= Color.RED;
    private Team team;
    private BoatType type;
    /**
     Constructs a RowBoat object with a given name, maximum speed, acceleration, and color.
     Sets the default team and type values.
     @param name the name of the rowing boat
     @param maxSpeed the maximum speed of the rowing boat
     @param acceleration the acceleration of the rowing boat
     @param color the color of the rowing boat
     */
     public RowBoat(String name, double maxSpeed, double acceleration, Color color )
    {
        super(name,maxSpeed,acceleration,color);
        this.setTeam(Team.DOUBLE);
        this.setType(BoatType.SKULLING);
    }
    /**
     Constructs a RowBoat object with a default name, maximum speed, acceleration, and color.
     The default name is "RowBoat#" followed by a unique serial number, the default maximum speed is 75,
     the default acceleration is 10, and the default color is red.
     */
    public RowBoat()
    {
        this("RowBoat #"+getSerial(),MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_color);
    }
    /**
     Returns the type of rowing of the rowing boat.
     */
    // methods
    public BoatType getType() {return type;
    }
    /**
     Sets the type of rowing of the rowing boat.
     @param type the type of rowing of the rowing boat
     */
    public boolean setType(BoatType type) {
        this.type = type;
        return true;
    }
    /**
     Returns the team configuration of the rowing boat.
     */
    public Team getTeam() {return team;
    }
    /**
     Sets the team configuration of the rowing boat.
     @param team the team configuration of the rowing boat
     */
    public boolean setTeam(Team team) {
        this.team = team;
        return true;
    }
    /**
     Returns a String representation of the rowing boat's specific attributes.
     */
    public String describeSpecific() {
        return " Type "+getType()+" Team: "+getTeam();}
    /**
     Returns the name of the class.
     */
    public String className() {return CLASS_NAME;}
    /**
     Creates and returns a deep copy of the current Racer object.
     @return A new Racer object with the same properties as the current object.
     */
    public Racer clone() {
        return new RowBoat(this.getName(), this.getMaxSpeed(), this.getAcceleration(), this.getColor());
    }
}
