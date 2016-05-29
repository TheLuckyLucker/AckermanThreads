/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
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
    
    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        numbers = new AckermanNumbers(
                                Integer.parseInt(mInput.getText()),
                                Integer.parseInt(nInput.getText()));
        Thread testRunner = new Thread(new AckermanRunner(numbers,this));
        numbers.setCanceled(false);
        setStatusMessage("Calculating....");
        testRunner.setUncaughtExceptionHandler((t,e) -> setStatusMessage("Exception Bug"));
        testRunner.start();

    }
    
    @FXML
    private void handleCancelButton(ActionEvent event){
        numbers.setCanceled(true);
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
