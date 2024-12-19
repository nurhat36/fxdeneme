module org.example.demo5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.demo5 to javafx.fxml;
    exports org.example.demo5;
}