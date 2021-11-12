module Lowe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens lowe.battleship to javafx.fxml;
    exports lowe.battleship;
}