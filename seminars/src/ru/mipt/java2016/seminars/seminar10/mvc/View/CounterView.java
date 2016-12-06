package ru.mipt.java2016.seminars.seminar10.mvc.View;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import ru.mipt.java2016.seminars.seminar10.mvc.Controller.CounterController;
import ru.mipt.java2016.seminars.seminar10.mvc.Controller.IController;
import ru.mipt.java2016.seminars.seminar10.mvc.Model.CounterModel;

public class CounterView implements IView, Observer {
    private IController controller;

    public CounterView() {
        controller = new CounterController(this);
    }

    public void readCounterValue(Scanner scanner) {
        controller.updateCounter(scanner.nextInt());
    }

    @Override
    public void displayCounter(int counter) {
        System.out.println(counter);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof CounterModel) {
            System.out.println("New Counter value: " + ((CounterModel) o).getCounter());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CounterView view = new CounterView();
        while (sc.hasNextInt()) {
            view.readCounterValue(sc);
        }
    }
}
