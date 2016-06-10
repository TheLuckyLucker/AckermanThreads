/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author Conny Blach, s4329872
 * @author Tiko Huizinga, s4460898
 */
public class AckermanRunner extends Task<Integer> {

    private AckermanNumbers numbers;
    private final FXMLDocumentController controller;

    public AckermanRunner(AckermanNumbers A, FXMLDocumentController t) {
        this.numbers = A;
        this.controller = t;
    }

    /**
     * This was used for task2 when we had to use the threads
     *
     * @Override public void run() { numbers.calculate(numbers.getM(),
     * numbers.getN()); Platform.runLater(() ->
     * controller.updateResult(numbers.getAckerman()));
     * if(numbers.getCanceled()){ Platform.runLater(() ->
     * controller.setStatusMessage("Canceled")); } else{ Platform.runLater(() ->
     * controller.setStatusMessage("Finished")); }
    }
     */
    /**
     * Call function which is executed by the Ackermann Worker
     *
     * @return the new value for value of Task
     * @throws Exception
     */
    @Override
    protected Integer call() throws Exception {
        numbers.calculate(numbers.getM(), numbers.getN(), this);
        Platform.runLater(() -> controller.updateResult(numbers.getAckerman()));
        if (this.isCancelled()) {
            Platform.runLater(() -> controller.setStatusMessage("Canceled"));
        } else {
            Platform.runLater(() -> controller.setStatusMessage("Finished"));
        }
        return 0;
    }

}
