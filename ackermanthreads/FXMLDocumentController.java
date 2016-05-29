/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Conny
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField mInput, nInput;
    @FXML
    private Label resultField, progStatus;
    
    private AckermanNumbers numbers;
    private String statusMessage;
    AckermanRunner runner;
    
    @FXML
    private void handleStartButtonAction(ActionEvent event) throws InterruptedException, ExecutionException {
        numbers = new AckermanNumbers(
                                Integer.parseInt(mInput.getText()),
                                Integer.parseInt(nInput.getText()));
        setStatusMessage("Calculating....");
//        Thread testRunner = new Thread(new AckermanRunner(numbers,this));
//        numbers.setCanceled(false);

//        testRunner.setUncaughtExceptionHandler((t,e) -> setStatusMessage("Stack Overflow"));
//        testRunner.start();
        runner = new AckermanRunner(numbers, this);
        Thread t = new Thread(runner);
        t.start();
//        System.out.println(test.get());

    }
    
    @FXML
    private void handleCancelButton(ActionEvent event){
        setStatusMessage("Canceled");
        runner.cancel();
        updateResult(0);
    }
    
    @FXML
    private void handleQuitButton(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void updateResult(int result){
        resultField.setText(Integer.toString(result));
    }
    
    public void setStatusMessage(String message){
        progStatus.setText(message);
    }
    
}
