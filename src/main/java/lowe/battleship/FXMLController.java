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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
    
     @FXML
    private ImageView imgA1,imgA2,imgA3,imgA4,imgA5,imgB1,imgB2,imgB3,imgB4,imgB5,imgC1,imgC2,imgC3,imgC4,imgC5,imgD1,imgD2,imgD3,imgD4,imgD5,imgE1,imgE2,imgE3,imgE4,imgE5;

    @FXML
    void MClick(MouseEvent event) {

    }

    
      @FXML
    void btnClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
    }
    
    ImageView box[];
    
    int Spot1;
    int Spot2;
    
    public void Slots (){
         Spot1 = ThreadLocalRandom.current().nextInt(0, 11 +1);
         Spot2 = ThreadLocalRandom.current().nextInt(0, 11 +1);
        while (Spot1 == Spot2){
            Spot2 = ThreadLocalRandom.current().nextInt(0, 11 +1);
        }
    }
    public void Ships (){
       if  (Spot1 == 1 || Spot2 == 1){
        
    }
       else if (Spot1 == 2 || Spot2== 2){
           
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView temp[] = {imgA1,imgA2,imgA3,imgA4,imgA5,imgB1,imgB2,imgB3,imgB4,imgB5,imgC1,imgC2,imgC3,imgC4,imgC5,imgD1,imgD2,imgD3,imgD4,imgD5,imgE1,imgE2,imgE3,imgE4,imgE5};
        box = temp;
        // TODO
        
    }    
}
