module org.example.hastaneotomasyonu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.hastaneotomasyonu to javafx.fxml;
    exports org.example.hastaneotomasyonu;
}