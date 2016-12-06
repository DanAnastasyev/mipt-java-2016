package ru.mipt.java2016.seminars.seminar10.mvc.Controller;


import ru.mipt.java2016.seminars.seminar10.mvc.Model.CounterModel;
import ru.mipt.java2016.seminars.seminar10.mvc.View.CounterView;
import ru.mipt.java2016.seminars.seminar10.mvc.View.IView;

public class CounterController implements IController {
    private IView view;
    private CounterModel counter;

    public CounterController(CounterView view) {
        this.view = view;
        counter = new CounterModel(0);
        counter.addObserver(view);
    }

    @Override
    public void updateCounter(int newCounterValue) {
        counter.setCounter(newCounterValue);
    }
}
