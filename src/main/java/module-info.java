module com.raul.nextyearplan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires com.h2database;

    opens com.raul.nextyearplan.controllers to javafx.fxml;
    exports com.raul.nextyearplan.controllers;
    exports com.raul.nextyearplan;
    opens com.raul.nextyearplan to javafx.fxml;
}