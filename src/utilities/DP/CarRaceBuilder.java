package utilities.DP;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.land.Car;
import utilities.EnumContainer;
import java.util.ArrayList;
import java.util.Random;

/**
 * The CarRaceBuilder class implements the MyRaceBuilder interface to build a car race.
 */

public class CarRaceBuilder implements MyRaceBuilder {
    private ArenaFactoryMethod a1=new ArenaFactoryMethod();
    private Race race;
    private int num;
    private ArrayList<Racer> MyRacers;
    /**
     * Constructs a CarRaceBuilder object with the specified number of racers.
     *
     * @param num the number of racers for the race
     */
    public CarRaceBuilder(int num){
        this.num=num;
        this.MyRacers=new ArrayList<>();
        this.race=new Race();
    }
    @Override
    /**
     * Builds the arena for the car race.
     */
    public void BuildArena() {
        race.setArena(a1.getArena("Land",this.num));
    }
    @Override
    /**
     * Builds the list of racers for the car race.
     *
     * @throws RacerTypeException if there is an error in the racer types
     * @throws RacerLimitException if there is an error in the racer limit
     */
    public void BuildRacersList() throws RacerTypeException, RacerLimitException {
         Random rnd=new Random();
        Car careacer=new Car("Aviv",250,20, EnumContainer.Color.BLACK,4);
        this.MyRacers.add(careacer);
        for(int i=0;i<this.num-1;i++)
        {
            int x=rnd.nextInt(5)+1;
            if(x==1){
                Racer copy=careacer.clone();
                copy.upgrade( EnumContainer.Color.BLACK);
                this.MyRacers.add(copy);
            }
            else if(x==2){
                Racer copy=careacer.clone();
                copy.upgrade( EnumContainer.Color.RED);
                this.MyRacers.add(copy);
            }
            else if(x==3){
                Racer copy=careacer.clone();
                copy.upgrade( EnumContainer.Color.BLUE);
                this.MyRacers.add(copy);
            }
            else if(x==4){
                Racer copy=careacer.clone();
                copy.upgrade(EnumContainer.Color.GREEN);
                this.MyRacers.add(copy);
            }
            else
            {
                Racer copy=careacer.clone();
                copy.upgrade( EnumContainer.Color.YELLOW);
                this.MyRacers.add(copy);
            }

        }
        for(int i=0;i<this.num;i++)
        {
            race.getMyArena().addRacer(this.MyRacers.get(i));
        }
        race.setRacersList(this.MyRacers);
        race.getMyArena().initRace();
    }
    /**
     * Retrieves the constructed race object.
     *
     * @return the constructed Race object
     */
    public Race getRace() { return this.race;}

}
