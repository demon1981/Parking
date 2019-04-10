package model;

import view.Observer;

import java.util.List;

abstract public class ObservableImpl implements Observable{

    static private List<Observer> observers;

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o :
                observers) {
            o.update();
        }
    }
}
