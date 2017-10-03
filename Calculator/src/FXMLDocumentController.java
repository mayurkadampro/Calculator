/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Mayur
 */
public class FXMLDocumentController implements Initializable {


    @FXML
    private TextField txtDisplay;
    private int decimalClick = 0;
    private String gobject;
    private double FirstDouble;
    private double SecondDouble;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handlerGenrealActtion(ActionEvent event) {
         gobject = ((Button) event.getSource()).getText();
        switch (gobject) {
            case "AC":
                txtDisplay.setText("");
                decimalClick = 0;
                break;
            case "+/-":
                double plusminus = Double.parseDouble(String.valueOf(txtDisplay.getText()));
                plusminus = plusminus * (-1);
                txtDisplay.setText(String.valueOf(plusminus));
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                String Current = txtDisplay.getText();
                FirstDouble = Double.parseDouble(Current);
                txtDisplay.setText("");
                decimalClick = 0;
            default:
        }
    }

    @FXML
    private void handletDigitAction(ActionEvent event) {
        String digitobject = ((Button) event.getSource()).getText();
        String oldtext = txtDisplay.getText();
        String newtext = oldtext + digitobject;
        txtDisplay.setText(newtext);
    }

    @FXML
    private void handlerDecimalAction(ActionEvent event) {

        if (decimalClick == 0) {
            String decimalobject = ((Button) event.getSource()).getText();
            String oldtext = txtDisplay.getText();
            String newtext = oldtext + decimalobject;
            txtDisplay.setText(newtext);
            decimalClick = 1;
        }

    }

    @FXML
    private void handlerEqualActtion(ActionEvent event) {
        
     
        double Result=0;
        String SecondText = txtDisplay.getText();
        SecondDouble = Double.parseDouble(SecondText);
        
        switch(gobject){
        
            case "+": Result = FirstDouble+SecondDouble;
                      break;
            case "*": Result = FirstDouble*SecondDouble;
                      break;
            case "/": Result = FirstDouble/SecondDouble;
                      break;
            case "-": Result = FirstDouble-SecondDouble;
                      break;
            default:
        }
        
        String format = String.format("%.1f", Result);
        txtDisplay.setText(format);
        
    }

}
