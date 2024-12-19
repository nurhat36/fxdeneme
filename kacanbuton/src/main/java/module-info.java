module org.example.kacanbuton {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.kacanbuton to javafx.fxml;
    exports org.example.kacanbuton;
}