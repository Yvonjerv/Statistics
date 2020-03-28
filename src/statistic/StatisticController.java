package statistic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author YVON
 */
public class StatisticController implements Initializable {
 List<String> lstFile;
 

    @FXML
    private JFXButton btn_import;
 
    @FXML
    private Label lbl_mean;

    @FXML
    private Label lbl_variance;

    @FXML
    private Label lbl_standard_deviation;

    @FXML
    private Label textArea;
    @FXML
    private Label lbl_plus;

    @FXML
    private Label lbl_minus;

    @FXML
    private JFXButton btn_68;
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
    private JFXButton btn_Yes_No;


    ArrayList<Double> listI = new ArrayList<Double>();

    @FXML
    private void handleButtonAction(ActionEvent event) {
         if (event.getSource() == btn_50) {
            getCalculation(0.67, "50%");
            getClear();
        }
        if (event.getSource() == btn_68) {
            getCalculation(1, "68%");
            getClear();
        }
        if (event.getSource() == btn_70) {
            getCalculation(1.04, "70%");
            getClear();
        }
          if (event.getSource() == btn_80) {
            getCalculation(1.28, "80%");
            getClear();
        }
        if (event.getSource() == btn_90) {
            getCalculation(1.64, "90%");
            getClear();
        }
        if (event.getSource() == btn_95) {
            getCalculation(2, "95%");
            getClear();
        }
        if (event.getSource() == btn_99) {
            getCalculation(2.58, "99%");
            getClear();
        }
        if (event.getSource() == btn_997) {
            getCalculation(3, "99.7%");
            getClear();
        }
       
    }

    @FXML
    void singleFileChooser(ActionEvent event) throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(null);
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", lstFile));
        listI.clear();
        if (f != null) {
            textArea.setText("" + f.getAbsolutePath());
        }

        Scanner s = new Scanner(new File(f.getAbsolutePath()));
        while (s.hasNextLine()) {
            listI.add(s.nextDouble());
        }

        System.out.println(listI);
        System.out.println(listI.size());
        getCalculation(2, "95%");
        getClear();
    }

    double sumsqr, cal, variance, sum, mean, diff, diff_plus, diff_minus, z, st_dev = 0;

    void getClear() {
        sumsqr = 0;     cal = 0;
        variance = 0;   sum = 0;
        mean = 0;       diff = 0;
        diff_plus = 0;  diff_minus = 0;
        st_dev = 0;     z=0;
    }

    private void getCalculation(double z, String percent) {
        //mean
        for (int i = 0; i < listI.size(); i++) {
            sum += listI.get(i);
        }
        mean = (double) sum / listI.size();
        String mean_string = Double.toString(mean);
        lbl_mean.setText(mean_string);

        //Variance
        for (int i = 0; i < listI.size(); i++) {
            cal = Math.pow(listI.get(i) - mean, 2);
            sumsqr += cal;
        }
        variance = sumsqr / (listI.size() - 1);
        String variance_string = Double.toString(variance);
        lbl_variance.setText(variance_string);

        //Standard deviation
        st_dev = Math.sqrt(variance);
        String st_dev_string = Double.toString(st_dev);
        lbl_standard_deviation.setText(st_dev_string);

        diff = (z * (st_dev)) / (Math.sqrt(listI.size()));

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
        lstFile = new ArrayList<>();
        lstFile.add("*.doc");
        lstFile.add("*.docx");
        lstFile.add("*.txt");
}
       @FXML
    private void YesAction(ActionEvent event) {
        if (event.getSource() == btn_Yes_No) {
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