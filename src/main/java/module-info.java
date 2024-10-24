module com.example.heatcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens ch.iet_gibb.oecoheat to javafx.fxml;
    exports ch.iet_gibb.oecoheat;

    opens ch.iet_gibb.oecoheat.models to javafx.base;
}
