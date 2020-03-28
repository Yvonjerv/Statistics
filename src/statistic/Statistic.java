/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author YVON
 */
public class Statistic extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("STATISTICS");
        //Image image = new Image("/images/icons8_room_99px.png");
        //stage.getIcons().add(image);
       // stage.setResizable(false);
        //new Image(XYZ.class.getResourceAsStream("/xyz.png"));
        //Image icon = new Image(StatisticController.class.getResource("icons8_room_99px.png").toExternalForm(), false);
        // stage.getIcons().add(icon);

       // stage.setMaxWidth(390);
        //stage.setMaxHeight(625);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
