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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private ImageView imgA1, imgA2, imgA3, imgA4, imgA5, imgB1, imgB2, imgB3, imgB4, imgB5, imgC1, imgC2, imgC3, imgC4, imgC5, imgD1, imgD2, imgD3, imgD4, imgD5, imgE1, imgE2, imgE3, imgE4, imgE5;

    @FXML
    void MClick(MouseEvent event) {
        Button btn = (Button) event.getSource();
    }
    
    ImageView box[];

    int Spot1;
    int Spot2;

    public void Slots() {
        Spot1 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        Spot2 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        while (Spot1 == Spot2) {
            Spot2 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        }
    }

    public void Ships() {
        if (Spot1 == 1 || Spot2 == 1) {
            box[1].setAccessibleText("X");
            box[6].setAccessibleText("X");
        } else if (Spot1 == 2 || Spot2 == 2) {
            box[2].setAccessibleText("X");
            box[3].setAccessibleText("X");
        } else if (Spot1 == 3 || Spot2 == 3) {
            box[7].setAccessibleText("X");
            box[8].setAccessibleText("X");
        } else if (Spot1 == 4 || Spot2 == 4) {
            box[4].setAccessibleText("X");
            box[9].setAccessibleText("X");
        } else if (Spot1 == 5 || Spot2 == 5) {
            box[5].setAccessibleText("X");
            box[10].setAccessibleText("X");
        } else if (Spot1 == 6 || Spot2 == 6) {
            box[11].setAccessibleText("X");
            box[12].setAccessibleText("X");
        } else if (Spot1 == 7 || Spot2 == 7) {
            box[13].setAccessibleText("X");
            box[18].setAccessibleText("X");
        } else if (Spot1 == 8 || Spot2 == 8) {
            box[14].setAccessibleText("X");
            box[15].setAccessibleText("X");
        } else if (Spot1 == 9 || Spot2 == 9) {
            box[19].setAccessibleText("X");
            box[20].setAccessibleText("X");
        } else if (Spot1 == 10 || Spot2 == 10) {
            box[23].setAccessibleText("X");
            box[24].setAccessibleText("X");
        } else if (Spot1 == 11 || Spot2 == 11) {
            box[16].setAccessibleText("X");
            box[21].setAccessibleText("X");
        } else if (Spot1 == 12 || Spot2 == 12) {
            box[17].setAccessibleText("X");
            box[22].setAccessibleText("X");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView temp[] = {imgA1, imgA2, imgA3, imgA4, imgA5, imgB1, imgB2, imgB3, imgB4, imgB5, imgC1, imgC2, imgC3, imgC4, imgC5, imgD1, imgD2, imgD3, imgD4, imgD5, imgE1, imgE2, imgE3, imgE4, imgE5};
        box = temp;
        // TODO

    }
}
