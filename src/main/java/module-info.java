module Lowe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.base;
    opens lowe.battleship to javafx.fxml;
    exports lowe.battleship;
}