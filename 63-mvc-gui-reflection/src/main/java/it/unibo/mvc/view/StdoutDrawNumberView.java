package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

/**
 * This class represents a view that is output only and writes its information on stdout.
 */

public class StdoutDrawNumberView implements DrawNumberView {

    private DrawNumberController controller;

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
    }

    @Override
    public void result(DrawResult res) {
        System.out.println("Result: " + res);
    }
    
}
