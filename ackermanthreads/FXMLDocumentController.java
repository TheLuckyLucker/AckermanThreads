/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Conny Blach, s4329872
 * @author Tiko Huizinga, s4460898
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField mInput, nInput;
    @FXML
    private Label resultField, progStatus;

    private AckermanNumbers numbers;
    AckermanRunner runner;

    /**
     * Handle a click on the start button This should create a new thread of an
     * ackermanRunner
     *
     * @param event the click event
     */
    @FXML
    private void handleStartButtonAction(ActionEvent event) {
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
        t.setUncaughtExceptionHandler((thread, e) -> setStatusMessage("Stack Overflow"));
        t.start();
//        System.out.println(test.get());

    }

    /**
     * Handle the click on the cancel button to cancel the working thread
     *
     * @param event
     */
    @FXML
    private void handleCancelButton(ActionEvent event) {
        setStatusMessage("Canceled");
        runner.cancel();
        updateResult(0);
    }

    /**
     * Handle a click on the quit button to exit the app
     *
     * @param event
     */
    @FXML
    private void handleQuitButton(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Updates the Label result
     *
     * @param result the result with which the label is updated
     */
    public void updateResult(int result) {
        resultField.setText(Integer.toString(result));
    }

    /**
     * Sets a new status message for the user such that he knows what the app is
     * doing
     *
     * @param message statusmessage
     */
    public void setStatusMessage(String message) {
        progStatus.setText(message);
    }

}
