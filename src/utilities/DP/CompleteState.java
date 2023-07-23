package utilities.DP;
import game.racers.Racer;
/**
 * The CompleteState class represents the complete state of a racer in an arena.
 * It implements the RacerAlertState interface and provides a method to alert the racer, indicating that it has finished the race.
 * Upon alert, the racer's details are printed, indicating that it has finished.
 */
public class CompleteState  implements RacerAlertState{
    /**
     * Alerts the racer, indicating that it has finished the race.
     * Calls the crossFinishLine() method of the racer's arena to handle the racer crossing the finish line.
     * Prints the racer's name and details to indicate that it has finished.
     *
     * @param racer the racer that has finished the race
     */
    @Override
    public void alert(Racer racer) {
        racer.getArena().crossFinishLine(racer);
        System.out.println(racer.getName()+" has finished, racer details:");
        racer.introduce();
    }
}
