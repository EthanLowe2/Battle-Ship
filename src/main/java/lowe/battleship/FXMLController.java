package lowe.battleship;
/*
Put header here
bruh

 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class FXMLController implements Initializable {
    
    @FXML
    private Label lblOut;

    @FXML
    private Button btnA1;

    @FXML
    private Button btnA2;

    @FXML
    private Button btnA3;

    @FXML
    private Button btnA4;

    @FXML
    private Button btnA5;

    @FXML
    private Button btnB2;

    @FXML
    private Button btnC1;

    @FXML
    private Button btnD1;

    @FXML
    private Button btnE1;

    @FXML
    private Button btnB1;

    @FXML
    private Button btnB3;

    @FXML
    private Button btnB4;

    @FXML
    private Button btnB5;

    @FXML
    private Button btnC2;

    @FXML
    private Button btnC3;

    @FXML
    private Button btnC4;

    @FXML
    private Button btnC5;

    @FXML
    private Button btnD2;

    @FXML
    private Button btnD3;

    @FXML
    private Button btnD4;

    @FXML
    private Button btnD5;

    @FXML
    private Button btnE2;

    @FXML
    private Button btnE3;

    @FXML
    private Button btnE4;

    @FXML
    private Button btnE5;

    
      @FXML
    void btnClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        
    }
    

    
    public void ship1 (){
        int rand = ThreadLocalRandom.current().nextInt(0, 20 +1);
        if (rand == 1){
            
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
