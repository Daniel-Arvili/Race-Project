package utilities.DP;
import game.racers.Racer;
/**
 * The RacerAlertState interface represents the  state of a racer.
 * It provides a method for alerting the racer.
 */
public interface RacerAlertState {
    /**
     * Alerts the racer.
     *
     * @param racer the racer to be alerted
     */
    public void alert(Racer racer);
}
