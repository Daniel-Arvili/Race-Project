package utilities.DP;
import game.racers.Racer;
import java.util.ArrayList;
/**
 * The ActiveState class represents the active state of a racer in an arena.
 * It implements the RacerAlertState interface and provides a method to alert the racer, activating it in the arena.
 */
public class ActiveState  implements RacerAlertState{
    /**
     * Alerts the racer, activating it in the arena.
     * Moves the racer from the broken racers list to the active racers list in the racer's arena.
     * Sorts the active racers list based on their current location's X coordinate.
     *
     * @param racer the racer to be alerted and activated
     */
    @Override
    public void alert(Racer racer) {
        racer.getArena().getActiveRacers().add(racer);
        racer.getArena().getBrokenRacers().remove(racer);
        racer.getArena().setActiveRacers(mergeSort(racer.getArena().getActiveRacers()));


    }
    /**
     * Performs merge sort on the given list of racers based on their current location's X coordinate.
     *
     * @param racers the list of racers to be sorted
     * @return the sorted list of racers
     */
    public static ArrayList<Racer> mergeSort(ArrayList<Racer> racers) {
        if (racers.size() <= 1) {
            return racers;
        }

        int mid = racers.size() / 2;
        ArrayList<Racer> leftList = new ArrayList<>(racers.subList(0, mid));
        ArrayList<Racer> rightList = new ArrayList<>(racers.subList(mid, racers.size()));

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return merge(leftList, rightList);
    }

    public static ArrayList<Racer> merge(ArrayList<Racer> leftList, ArrayList<Racer> rightList) {
        ArrayList<Racer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < leftList.size() && j < rightList.size()) {
            Racer leftRacer = leftList.get(i);
            Racer rightRacer = rightList.get(j);

            if (leftRacer.getCurrentLocation().getX() >= rightRacer.getCurrentLocation().getX()) {
                result.add(leftRacer);
                i++;
            } else {
                result.add(rightRacer);
                j++;
            }
        }

        while (i < leftList.size()) {
            result.add(leftList.get(i));
            i++;
        }

        while (j < rightList.size()) {
            result.add(rightList.get(j));
            j++;
        }

        return result;
    }

}
