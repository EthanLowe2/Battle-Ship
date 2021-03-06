package lowe.battleship;

/*
BattleShip
Ethan
11/15/2021
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FXMLController implements Initializable {

    @FXML
    private ImageView imgA1, imgA2, imgA3, imgA4, imgA5, imgB1, imgB2, imgB3, imgB4, imgB5, imgC1, imgC2, imgC3, imgC4, imgC5, imgD1, imgD2, imgD3, imgD4, imgD5, imgE1, imgE2, imgE3, imgE4, imgE5;
    
    @FXML
    private Label lblHit, lblMiss, lblScore, lblTimer, lblScore2, lblCurrentScore, lblScoreView, lblLose2, lblLose1, lblLose3;
    
    @FXML
    private Button btnDone, btnReset, btnLose;
    
    @FXML
    private TextField txtName;
    
    @FXML
    private Rectangle recLose;
    
    @FXML
    void MClick(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
       if (!txtName.getText().equals("")){ 
           if(!lblCurrentScore.getText().contains("-")){
        if (img.getAccessibleText().equals("X")){
            img.setImage(new Image(getClass().getResource("/Wave Kaboom.jpg").toString()));
            Count(true);
            img.setAccessibleText("O"); 
        }if (img.getAccessibleText().equals("")){
            img.setImage(new Image(getClass().getResource("/Wave Sploosh.jpg").toString()));
            Count(false);
            img.setAccessibleText("O");
            ScoreMiss();
        }if (Running == false){
            clock.setCycleCount(Timeline.INDEFINITE);
            clock.play();
        }if (Hit == 4) { //the done button is not visible until you hit all ships
            btnDone.setVisible(true);
        }
        Running = true;
           }
           else if (lblCurrentScore.getText().contains("-")) {
               lblLose1.setVisible(true);
               lblLose2.setVisible(true);
               lblLose3.setVisible(true);
               recLose.setVisible(true);
               btnLose.setVisible(true);
               clock.stop();
               btnDone.setVisible(false);
               btnReset.setVisible(false);
           }
       }
       else {
           Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill in your name");
            alert.showAndWait();
       }
    }
    
    ImageView box[];
    
    String name[] = new String[5];
    int score[] = new int[5];
    
    boolean Running = false;
    
    int result;
    int resultM;
    
    int Spot1;
    int Spot2;
    
    int Hit;
    int Miss;
    
    int G;
    
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
        } if (Spot1 == 10 || Spot2 == 10) {
            box[22].setAccessibleText("X");
            box[23].setAccessibleText("X");
        } if (Spot1 == 11 || Spot2 == 11) {
            box[15].setAccessibleText("X");
            box[20].setAccessibleText("X");
        } if (Spot1 == 12 || Spot2 == 12) {
            box[16].setAccessibleText("X");
            box[21].setAccessibleText("X");
        }
    }
    
    void read() { //reading the text file and putting the names and scores in an array
        try {

            BufferedReader readFile = new BufferedReader(new FileReader("file.txt"));
            for (int i = 0; i < 5; i++) {
                name[i] = readFile.readLine();
                score[i] = Integer.parseInt(readFile.readLine());
            }
            readFile.close();
        } catch (IOException e) {
        }
    }
    
    void writeScore() { //wrighting in the text file the names and scores in a piticular form
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter("file.txt"));
            for (int i = 0; i < 5; i++) {
                outFile.write(name[i]);
                outFile.newLine();
                outFile.write(score[i]);
                outFile.newLine();
            }
            outFile.close();
        } catch (IOException e) {
        }
    }
    
    void HighSores(){ 
        int highscore;
        highscore = Integer.parseInt(lblCurrentScore.getText());
            if (highscore > score[0]){ //beat the first place
                    editscores1(0,4 );
                    read();
                    ReadScores();
             }else if (highscore > score[1]){ // beat the second place
                 editscores1(1,4);
                    read();
                    ReadScores();
             }else if (highscore > score[2]){ // beat the third place
                 editscores1(2,4);
                    read();
                    ReadScores();
             }else if (highscore > score[3]){ // beat the forth place 
                 editscores1(3,4);
                    read();
                    ReadScores();
             }else if (highscore > score[4]){ // beath the fith place
                 editscores1(4,4);
                    read();
                    ReadScores();
             }
        } 
    
    
    void editscores1 (int above, int below){ //overly complicated way of editing the text file holding the scores
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter("file.txt"));
            for (int j = 0; j < above; j++) {
            outFile.write(name[j]);
            outFile.newLine();
            outFile.write(""+score[j]);
            outFile.newLine();
            }
            outFile.write(txtName.getText());
            outFile.newLine();
            outFile.write(lblCurrentScore.getText());
            outFile.newLine();
           for (int j2 = above ; j2 <= below; j2++) {
            outFile.write(name[j2]);
            outFile.newLine();
            outFile.write(""+score[j2]);
            outFile.newLine();
            }
           outFile.close();
        } catch (IOException e) {
        }
    }
    
    void ReadScores() { // a method for puting the names and scores on a label if the text file was updated need to call after calling the read method
        String outputSc = "";
        for (int i = 0; i < 5; i++) {
            outputSc=outputSc+name[i]+ " "+score[i] + "\n";
        }
        lblScore.setText(outputSc);
    }
    
    public void Reset () { // clears all of the ImageViews as well as Miss and Hit Counters
        for (ImageView Name : box) {  
          Name.setAccessibleText("");
          Name.setImage(new Image(getClass().getResource("/Wave.jpg").toString()));
        }
        Hit = 0;
        lblHit.setText(""+Hit);
        Miss = 0;
        lblMiss.setText(""+Miss);
        Running = false;
        lblTimer.setText("0");
        lblCurrentScore.setText("1000");
    }
    
    @FXML
    void btnPlay(ActionEvent event) { //button with the reset button label
        Reset();
        Slots();
        Ships();
        btnReset.setVisible(false);
    }
    
      @FXML
    void btnDoneA(ActionEvent event) { //done button
        int Time;
        int End;
    End = Integer.parseInt(lblCurrentScore.getText());
    Time = Integer.parseInt(lblTimer.getText());
    result=End -Time*5;
    lblCurrentScore.setText(""+result);
    btnDone.setVisible(false);
    btnReset.setVisible(true);
    clock.stop();
    }
    
    void ScoreMiss (){ // a method to be able to take away your score live 
        int hurt;
        hurt = Integer.parseInt(lblCurrentScore.getText());
        resultM =hurt-65;
        lblCurrentScore.setText(""+resultM);
    }
    
    @FXML
    void btnHighscore(ActionEvent event) {
    if (!lblCurrentScore.getText().equals("1000") && Running == false){
    HighSores();    
    }    
    }
    
    @FXML
    void btnPlayAgain(ActionEvent event) { //button that comes up when you lose and resets so you can play again
        btnPlay(event);
        lblLose1.setVisible(false);
        lblLose2.setVisible(false);
        lblLose3.setVisible(false);
        recLose.setVisible(false);
        btnLose.setVisible(false);
        Running = false;
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
        read();
        ReadScores();
        btnDone.setVisible(false);
        btnReset.setVisible(false);
        lblLose1.setVisible(false);
        lblLose2.setVisible(false);
        lblLose3.setVisible(false);
        recLose.setVisible(false);
        btnLose.setVisible(false);
        //todo
        //File Saving
        //make learderboard buttons ("think you made it on the learderboard?""Save learderboard"
    }
}
