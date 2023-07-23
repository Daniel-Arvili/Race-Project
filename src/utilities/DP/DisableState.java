package utilities.DP;
import game.racers.Racer;
/**
 * The DisableState class represents the disabled state of a racer in an arena.
 * It implements the RacerAlertState interface and provides a method to alert the racer, indicating that it has been disabled.
 * Upon alert, the racer is moved from the active racers list to the disabled racers list of the arena.
 * A message indicating the racer's name and that it has been disabled is printed.
 */
public class DisableState  implements RacerAlertState{
    @Override
    /**
     * Alerts the racer, indicating that it has been disabled.
     * Moves the racer from the active racers list to the disabled racers list of the arena.
     * Prints a message indicating the racer's name and that it has been disabled.
     *
     * @param racer the racer that has been disabled
     */
    public void alert(Racer racer) {
        racer.getArena().getDisableRacers().add(racer);
        racer.getArena().getActiveRacers().remove(racer);
        System.out.println("============");
        System.out.println("Racer "+ racer.getName()+ " disabled!");
        System.out.println("===========");
    }
}
