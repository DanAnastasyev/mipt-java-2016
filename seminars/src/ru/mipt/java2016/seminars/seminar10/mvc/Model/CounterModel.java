package ru.mipt.java2016.seminars.seminar10.mvc.Model;

import java.util.Observable;

public class CounterModel extends Observable {
    private int counter;

    public CounterModel(int init) {
        counter = init;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
        setChanged();
        notifyObservers();
    }
}
