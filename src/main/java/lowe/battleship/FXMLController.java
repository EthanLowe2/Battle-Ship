package lowe.battleship;

/*
BattleShip
Ethan
11/15/2021
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private ImageView imgA1, imgA2, imgA3, imgA4, imgA5, imgB1, imgB2, imgB3, imgB4, imgB5, imgC1, imgC2, imgC3, imgC4, imgC5, imgD1, imgD2, imgD3, imgD4, imgD5, imgE1, imgE2, imgE3, imgE4, imgE5;
    
    @FXML
    private Label lblHit;

    @FXML
    private Label lblMiss;

    @FXML
    void MClick(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        if (img.getAccessibleText().equals("X")){
            img.setImage(new Image(getClass().getResource("/Wave Kaboom.jpg").toString()));
        }else
            img.setImage(new Image(getClass().getResource("/Wave Sploosh.jpg").toString()));
    }
    
    ImageView box[];

    int Spot1;
    int Spot2;
    
    int Hit;
    int Miss;
    
    public void Count() {
        Hit++;
        Miss++;
        lblHit.setText(""+Hit);
        lblMiss.setText(""+Miss);
    }

    public void Slots() {
        Spot1 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        Spot2 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        while (Spot1 == Spot2) {
            Spot2 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        }
    }

    public void Ships() {
        if (Spot1 == 1 || Spot2 == 1) {
            box[0].setAccessibleText("X");
            box[5].setAccessibleText("X");
        } if (Spot1 == 2 || Spot2 == 2) {
            box[1].setAccessibleText("X");
            box[2].setAccessibleText("X");
        } if (Spot1 == 3 || Spot2 == 3) {
            box[6].setAccessibleText("X");
            box[7].setAccessibleText("X");
        } if (Spot1 == 4 || Spot2 == 4) {
            box[3].setAccessibleText("X");
            box[8].setAccessibleText("X");
        } if (Spot1 == 5 || Spot2 == 5) {
            box[4].setAccessibleText("X");
            box[9].setAccessibleText("X");
        } if (Spot1 == 6 || Spot2 == 6) {
            box[10].setAccessibleText("X");
            box[11].setAccessibleText("X");
        } if (Spot1 == 7 || Spot2 == 7) {
            box[12].setAccessibleText("X");
            box[17].setAccessibleText("X");
        } if (Spot1 == 8 || Spot2 == 8) {
            box[13].setAccessibleText("X");
            box[14].setAccessibleText("X");
        } if (Spot1 == 9 || Spot2 == 9) {
            box[18].setAccessibleText("X");
            box[19].setAccessibleText("X");
        } else if (Spot1 == 10 || Spot2 == 10) {
            box[22].setAccessibleText("X");
            box[23].setAccessibleText("X");
        } else if (Spot1 == 11 || Spot2 == 11) {
            box[15].setAccessibleText("X");
            box[20].setAccessibleText("X");
        } else if (Spot1 == 12 || Spot2 == 12) {
            box[16].setAccessibleText("X");
            box[21].setAccessibleText("X");
        }
    }
    
    public void Reset () {
        for (ImageView name : box) {  
          name.setAccessibleText("");
          name.setImage(new Image(getClass().getResource("/Wave.jpg").toString()));
   }   
}
    @FXML
    void btnPlay(ActionEvent event) {
        Reset();
        Slots();
        Ships();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView temp[] = {imgA1, imgA2, imgA3, imgA4, imgA5, imgB1, imgB2, imgB3, imgB4, imgB5, imgC1, imgC2, imgC3, imgC4, imgC5, imgD1, imgD2, imgD3, imgD4, imgD5, imgE1, imgE2, imgE3, imgE4, imgE5};
        box = temp;
        Reset();
        Slots();
        Ships();
    }
}
