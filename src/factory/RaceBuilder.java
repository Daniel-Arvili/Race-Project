package factory;

import game.arenas.Arena;
import game.racers.Racer;
import utilities.EnumContainer.Color;
import java.lang.reflect.*;

public class RaceBuilder {
    /**
     * @Author Daniel Arvili
     * @Author Aviv Hagag
     * this class responsible to build a game with arenas and racers
     */
    private  Class c;
    private  final ClassLoader cl=ClassLoader.getSystemClassLoader();
    private static RaceBuilder instance=null;
    protected RaceBuilder()
    {

    }
    /**
     * using singleton pattern
     */
    public static RaceBuilder getInstance()
    {
        if(instance==null)
        {
            instance=new RaceBuilder();
        }
        return instance;
    }
    /**
     * method that responsible to build arena
     */
    public Arena buildArena(String arenaType,double length,int maxRacers) throws ClassNotFoundException,NoSuchMethodException,
    InstantiationException,InvocationTargetException,IllegalAccessException
    {
        c=cl.loadClass(arenaType);
        Constructor con=c.getConstructor(double.class,int.class);
        return (Arena)con.newInstance(length,maxRacers);
    }
    /**
     * method that responsible to build wheeled racer
     */
    public Racer buildWheeledRacer(String racerType,String name,double maxSpeed,double acceleration,Color color,int numOfWheels)throws ClassNotFoundException,NoSuchMethodException,
            InstantiationException,InvocationTargetException,IllegalAccessException
    {
        c=cl.loadClass(racerType);
        Constructor con=c.getConstructor(String.class,double.class,double.class,Color.class,int.class);
        return (Racer)con.newInstance(name,maxSpeed,acceleration,color,numOfWheels) ;
    }
    /**
     * method that responsible to build racer
     */
    public Racer buildRacer(String racerType,String name,double maxSpeed,double acceleration,Color color)throws ClassNotFoundException,NoSuchMethodException,
            InstantiationException,InvocationTargetException,IllegalAccessException
    {
        c=cl.loadClass(racerType);
        Constructor con=c.getConstructor(String.class,double.class,double.class,Color.class);
        return (Racer)con.newInstance(name,maxSpeed,acceleration,color) ;
    }

}
