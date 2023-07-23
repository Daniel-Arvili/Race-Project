package utilities.DP;
import game.racers.Racer;
/**
 * The InjuredState class represents the injured state of a racer in an arena.
 * It implements the RacerAlertState interface and provides a method to alert the racer, indicating that it has been injured.
 * Upon alert, the racer is moved from the active racers list to the broken racers list of the arena.
 */
public class InjuredState implements RacerAlertState {
    @Override
    /**
     * Alerts the racer, indicating that it has been injured.
     * Moves the racer from the active racers list to the broken racers list of the arena.
     *
     * @param racer the racer that has been injured
     */
    public void alert(Racer racer) {
        racer.getArena().getBrokenRacers().add(racer);
        racer.getArena().getActiveRacers().remove(racer);
    }
}
