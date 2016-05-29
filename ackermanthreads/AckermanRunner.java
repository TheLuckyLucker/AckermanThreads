/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

import javafx.application.Platform;


/**
 *
 * @author Conny
 */
public class AckermanRunner implements Runnable{

    private AckermanNumbers numbers;
    private final FXMLDocumentController controller;
    
    public AckermanRunner(AckermanNumbers A, FXMLDocumentController t){
        this.numbers = A;
        this.controller = t;
    }
    
    @Override
    public void run() {
        numbers.calculate(numbers.getM(), numbers.getN());
        Platform.runLater(() -> controller.updateResult(numbers.getAckerman()));
        if(numbers.getCanceled()){
            Platform.runLater(() -> controller.setStatusMessage("Canceled"));
        }
        else{
            Platform.runLater(() -> controller.setStatusMessage("Finished"));
        }
    }
    
}
