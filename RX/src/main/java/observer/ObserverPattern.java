package observer;

import java.util.ArrayList;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 2:19
 * @Homepage : https://github.com/gusdnd852
 */
class ObserverPattern {
    private ArrayList<Observer> observers = new ArrayList<>();

    void notify(Object o) {
        for (Observer observer : observers) observer.update(o);
    }

    void observe(Observer o) {
        if (!observers.contains(o)) observers.add(o);
    }

    interface Observer {
        void update(Object arg);
    }
}
