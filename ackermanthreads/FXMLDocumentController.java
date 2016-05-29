/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

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
    private void handleStartButtonAction(ActionEvent event) {
        AckermanNumbers test = new AckermanNumbers(
                                Integer.parseInt(mInput.getText()),
                                Integer.parseInt(nInput.getText()));
        Thread testRunner = new Thread(new AckermanRunner(test));
        Platform.runLater(testRunner);
        System.out.println(test.getAckerman());
    }
    
    @FXML
    private void handleCancelButton(ActionEvent event){
        System.out.println("cancel");
    }
    
    @FXML
    private void handleQuitButton(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
