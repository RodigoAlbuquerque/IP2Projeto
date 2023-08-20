module com.ufrpe.farmaciadarural {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens models to javafx.base;
    opens GUI to javafx.fxml;
    exports GUI;
}