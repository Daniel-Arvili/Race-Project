package game.racers.naval;
import game.racers.Racer;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Team;
import utilities.EnumContainer.BoatType;

import javax.swing.plaf.PanelUI;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
The SpeedBoat class represents a type of racer that can travel on water.
This class extends the Racer class and implements the NavalRacer interface.
 */
public class SpeedBoat extends Racer implements NavalRacer {
    private final static String CLASS_NAME ="SpeedBoat";
    private final static double MAX_SPEED =170;
    private final static double DEFAULT_ACCELERATION =5;
    private final static Color DEFAULT_color= Color.RED;
    private Team team;
    private BoatType type;
    /**
     Constructs a new SpeedBoat with the specified name, maximum speed, acceleration, and color.
     The default team is set Team to DOUBLE and the default type is set Type to SKULLING.
     @param name The name of the speed boat.
     @param maxSpeed The maximum speed of the speed boat.
     @param acceleration The acceleration of the speed boat.
     @param color The color of the speed boat.
     */
    public SpeedBoat(String name, double maxSpeed, double acceleration, Color color)
    {
        super(name,maxSpeed,acceleration,color);
        this.setTeam(Team.DOUBLE);
        this.setType(BoatType.SKULLING);
    }
    /**
     Constructs a new SpeedBoat with default values for its name, maximum speed, acceleration, and color.
     The default name is "SpeedBoat#" followed by a unique serial number, the default maximum speed is 170,
     the default acceleration is 5, and the default color is red.
     */
    public SpeedBoat()
    {
        this("Speed Boat #"+getSerial(),MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_color);
    }
    /**
     Returns the team of the SpeedBoat.
     */
    public Team getTeam() {return team;
    }
    /**
     Sets the team of the SpeedBoat.
     @param team The team of the SpeedBoat.
     */
    public boolean setTeam(Team team) {
        this.team = team;
        return true;
    }
    /**
     Returns the type of the SpeedBoat.
     */
    public BoatType getType() {return type;
    }
    /**
     Sets the type of the SpeedBoat.
     @param type The type of the SpeedBoat.
     */
    public boolean setType(BoatType type) {
        this.type = type;
        return true;
    }
    /**
     Returns a string describing the specific details of the SpeedBoat class, which in this case are the type and team.
     */
    @Override
    public String describeSpecific() {
      return " Type "+this.getType()+" Team: "+this.getTeam();
    }
    /**
     Returns the name of the SpeedBoat class.
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
        return new SpeedBoat(this.getName(), this.getMaxSpeed(), this.getAcceleration(), this.getColor());
    }
}
