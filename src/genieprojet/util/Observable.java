package genieprojet.util;

import java.util.ArrayList;

/**
 *
 * @author Benoit
 */
public class Observable {
    ArrayList<IObserver> observers;
    
    public Observable() {
        observers = new ArrayList<>();
    }
    
    public void ajouterObserver(IObserver o) {
        observers.add(o);
    }
    
    public void retirerObserver(IObserver o) {
        observers.remove(o);
    }
    
    public void notifier() {
        for (IObserver o : observers) {
            o.update();
        }
    }
}
