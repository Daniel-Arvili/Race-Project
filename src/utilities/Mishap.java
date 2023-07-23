package utilities;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 */
public class Mishap {
    /**
     The Mishap class represents a mishap that can occur in a vehicle.
     */
    private boolean fixable;
    private double reductionFactor;
    private int turnsToFix;
    /**
     Constructs and initializes a mishap with the specified parameters.
     @param fixable indicates if the mishap can be fixed
     @param turnsToFix the number of turns it takes to fix the mishap
     @param reductionFactor the reduction factor that the mishap causes in vehicle performance
     */
     public Mishap(boolean fixable,int turnsToFix,double reductionFactor){
        this.setFixable(fixable);
        this.setTurnsToFix(turnsToFix);
        this.setReductionFactor(reductionFactor);
    }
    /**
     Reduces the number of turns it takes to fix the mishap by 1, if the mishap is fixable.
     */
    public void nextTurn(){
         if (getFixable()==true)
             setTurnsToFix(getTurnsToFix()-1);
    }
    /**
     * Returns the fixable status of the mishap.
     */
    public boolean getFixable(){
        return fixable;
    }
    /**
     Sets the fixable status of the mishap to the specified value.
     @param fixable the new fixable status of the mishap
     */
   public boolean setFixable(boolean fixable){
        this.fixable=fixable;
        return true;
    }
    /**
     Returns the reduction factor of the mishap.
     */
    public double getReductionFactor(){
         return reductionFactor;
    }
    /**
     Sets the reduction factor of the mishap to the specified value.
     @param reductionFactor the new reduction factor of the mishap
     */
    public boolean setReductionFactor(double reductionFactor){
         this.reductionFactor=reductionFactor;
         return true;
    }
    /**
     Returns the number of turns it takes to fix the mishap.
     */
    public int getTurnsToFix(){
         return turnsToFix;
    }
    /**
     Sets the number of turns it takes to fix the mishap to the specified value.
     @param turnsToFix the new number of turns it takes to fix the mishap
     */
    public boolean setTurnsToFix(int turnsToFix) {
        this.turnsToFix = turnsToFix;
        return true;
    }
    /**
     Returns a string representation of the mishap in the format "(fixable, turnsToFix, reductionFactor)".
     @return a string representation of the mishap
     */
    public String toString() {
        return String.format("(%b, %d, %.2f)", fixable, turnsToFix, reductionFactor);
    }
}
