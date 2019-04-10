package model;

import view.Observer;

public interface Observable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
