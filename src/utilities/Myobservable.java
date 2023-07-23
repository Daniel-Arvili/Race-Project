package utilities;
import java.util.Vector;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 The MyObservable class represents an observable object in the observer design pattern.
 It allows other objects to register themselves as observers and be notified of changes.
 */
public class Myobservable {

    private Vector<Myobserver> list1=new Vector<>();
    /**
     Registers an observer to receive notifications.
     @param observer The observer to register.
     */
    public void register(Myobserver ob){
        list1.add(ob);
    }
    /**
     Unregisters an observer from receiving notifications.
     @param observer The observer to unregister.
     */
    public void unregister(Myobserver ob)
    {
        list1.remove(ob);
    }
    /**

     Notifies all registered observers about a change in the observable object.
     This method should be called whenever the state of the observable object changes.
     */
    protected void notifyObservers()
    {
        for( Myobserver ob  : list1)
            ob.update(this);
    }
}
