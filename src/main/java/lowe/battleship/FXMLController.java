package lowe.battleship;

/*
BattleShip
Ethan
11/15/2021
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class FXMLController implements Initializable {

    @FXML
    private ImageView imgA1, imgA2, imgA3, imgA4, imgA5, imgB1, imgB2, imgB3, imgB4, imgB5, imgC1, imgC2, imgC3, imgC4, imgC5, imgD1, imgD2, imgD3, imgD4, imgD5, imgE1, imgE2, imgE3, imgE4, imgE5;
    
    @FXML
    private Label lblHit, lblMiss, lblScore, lblTimer, lblScore2;

    @FXML
    void MClick(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        
        if (img.getAccessibleText().equals("X")){
            img.setImage(new Image(getClass().getResource("/Wave Kaboom.jpg").toString()));
            Count(true);
            img.setAccessibleText("O");
        }if (img.getAccessibleText().equals("")){
            img.setImage(new Image(getClass().getResource("/Wave Sploosh.jpg").toString()));
            Count(false);
            img.setAccessibleText("O");
        }if (Running == false){
            clock.setCycleCount(Timeline.INDEFINITE);
            clock.play();
        }
        Running = true;
    }
    
    ImageView box[];
    
    boolean Running = false;
    
    int Spot1;
    int Spot2;
    
    int Hit;
    int Miss;
    
    Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), ae -> timer()));
    
    void timer() {
        int play = Integer.parseInt(lblTimer.getText()) + 1;
        lblTimer.setText("" + play);
    }
    
    public void Count(boolean count) { //Adds to the Counters told appart by a Boolean value
        if (count == true){
            Hit++;
            lblHit.setText(""+Hit);
        } else if (count == false){
            Miss++;
            lblMiss.setText(""+Miss);
        }
    }

    public void Slots() { // Generates random numbers to be used in Ships (Method Below)
        Spot1 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        Spot2 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        while (Spot1 == Spot2) {
            Spot2 = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        }
    }

    public void Ships() { //Places Ships based on values made in Slots (Method above)
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
    
    public void Reset () { // clears all of the ImageViews as well as Miss and Hit Counters
        for (ImageView name : box) {  
          name.setAccessibleText("");
          name.setImage(new Image(getClass().getResource("/Wave.jpg").toString()));
        }
        if(Hit > 0){ //ScoreBoard
            lblScore.setText(lblMiss.getText() + "\n" + lblScore.getText());
        } if (Integer.parseInt(lblTimer.getText()) >0) {
            lblScore2.setText(lblTimer.getText() + "\n" + lblScore2.getText());
        }
        Hit = 0;
        lblHit.setText(""+Hit);
        Miss = 0;
        lblMiss.setText(""+Miss);
        Running = false;
        clock.stop();
        lblTimer.setText("0");
    }
    
    @FXML
    void btnPlay(ActionEvent event) {
        Reset();
        Slots();
        Ships();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //adding all of the ImageViews to an array so clearing them is much easyier
        ImageView temp[] = {imgA1, imgA2, imgA3, imgA4, imgA5, imgB1, imgB2, imgB3, imgB4, imgB5, imgC1, imgC2, imgC3, imgC4, imgC5, imgD1, imgD2, imgD3, imgD4, imgD5, imgE1, imgE2, imgE3, imgE4, imgE5};
        box = temp;
        //Makes sure you can just play without having to press a button
        Reset();
        Slots();
        Ships();
        //todo
        //add maximum misses
        //Timer that starts when you Start playing
        //File Saving
        // Maybe a little prettier
    }
}
