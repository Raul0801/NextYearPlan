package com.raul.nextyearplan;

import com.raul.nextyearplan.database.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(final Stage stage) throws IOException {
        DBConnection.createDB();
        final FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        final Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Next Year Plan");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(final String[] args) {
        launch();
    }
}