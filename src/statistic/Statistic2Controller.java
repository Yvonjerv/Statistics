/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YVON
 */
public class Statistic2Controller implements Initializable {
  @FXML
    private JFXButton btn_68;

    @FXML
    private Label lbl_mean1;

    @FXML
    private Label lbl_mean;

    @FXML
    private Label lbl_variance1;

    @FXML
    private Label lbl_variance;

    @FXML
    private Label lbl_standard_deviation1;

    @FXML
    private Label lbl_standard_deviation;

    @FXML
    private Label lbl_standard_deviation11;

    @FXML
    private Label lbl_plus;

    @FXML
    private Label lbl_minus;

    @FXML
    private Label lbl_standard_deviation11111;

    @FXML
    private Label lbl_standard_deviation111;

    @FXML
    private JFXButton btn_70;

    @FXML
    private JFXButton btn_80;

    @FXML
    private JFXButton btn_50;

    @FXML
    private Label lbl_percent;

    @FXML
    private JFXButton btn_95;

    @FXML
    private JFXButton btn_99;

    @FXML
    private JFXButton btn_997;

    @FXML
    private JFXButton btn_90;

    @FXML
    private JFXButton btn_Back;

    @FXML
    private Pane pane_color;

    @FXML
    private JFXTextField txt_sample;

    @FXML
    private JFXTextField txt_successes;
 
    @FXML
    private void YesButtonAction(ActionEvent event) {
         if (event.getSource() == btn_50) {
            getPercent(0.67, "50%");
            getClear();
        }
        if (event.getSource() == btn_68) {
            getPercent(1, "68%");
            getClear();
        }
        if (event.getSource() == btn_70) {
            getPercent(1.04, "70%");
            getClear();
        }
          if (event.getSource() == btn_80) {
            getPercent(1.28, "80%");
            getClear();
        }
        if (event.getSource() == btn_90) {
            getPercent(1.64, "90%");
            getClear();
        }
        if (event.getSource() == btn_95) {
            getPercent(2, "95%");
            getClear();
        }
        if (event.getSource() == btn_99) {
            getPercent(2.58, "99%");
            getClear();
        }
        if (event.getSource() == btn_997) {
            getPercent(3, "99.7%");
            getClear();
        }
       
    }
    double  variance, mean, diff, diff_plus, diff_minus, z, st_dev = 0;

    void getClear() {
        variance = 0;   mean = 0;       diff = 0;
        diff_plus = 0;  diff_minus = 0;
        st_dev = 0;     z=0;
    }
    
     private void getPercent(double z, String percent) {
        //getting the data
        double sampleSize = Double.valueOf(txt_sample.getText());
        double successes = Double.valueOf(txt_successes.getText());

        //mean
        mean = successes / sampleSize;
        String mean_string = Double.toString(mean);
        lbl_mean.setText(mean_string);

        //Standard deviation
        st_dev = Math.sqrt((mean*(1-mean))/sampleSize);
        String st_dev_string = Double.toString(st_dev);
        lbl_standard_deviation.setText(st_dev_string);

        //Variance
        variance = Math.pow(st_dev, 2);
        String variance_string = Double.toString(variance);
        lbl_variance.setText(variance_string); 

        diff = (z * (st_dev));

        diff_plus = mean + diff;
        String diff_plus_string = Double.toString(diff_plus);
        lbl_plus.setText(diff_plus_string);

        diff_minus = mean - diff;
        String diff_minus_string = Double.toString(diff_minus);
        lbl_minus.setText(diff_minus_string);
        lbl_percent.setText(percent);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void BackAction(ActionEvent event) {
        if (event.getSource() == btn_Back) {
            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("menu.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
