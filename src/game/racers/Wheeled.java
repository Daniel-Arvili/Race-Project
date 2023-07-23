/**

 This package contains classes for creating game racers.
 */
package game.racers;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 */
public class Wheeled {
    /**
     The number of wheels of the object.
     */
    private int numofWheels;
    /**
     Constructs a Wheeled object with the given number of wheels.
     @param numofWheels the number of wheels of the object.
     */
    public Wheeled(int numofWheels) {
        this.setNumofWheels(numofWheels);
    }
    /**
     Constructs a Wheeled object with 0 wheels.
     */
    public Wheeled() {
        this(0);
    }
    /**
     Returns the number of wheels of the object.
     @return the number of wheels of the object.
     */
    public int getNumofWheels() {
        return numofWheels;
    }
    /**
     Sets the number of wheels of the object.
     @param numofWheels the number of wheels of the object.
     @return true if the number of wheels was set successfully.
     */
    public boolean setNumofWheels(int numofWheels) {
        this.numofWheels = numofWheels;
        return true;
    }
    /**
     Returns a string representation of the Wheeled object, including its number of wheels.
     @return a string representation of the Wheeled object, including its number of wheels.
     */
    public String describeSpecific() {
        return ", Number of Wheels: " + this.getNumofWheels();
    }
}
