module org.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.demo3 to javafx.fxml;
    exports org.example.demo3;
}