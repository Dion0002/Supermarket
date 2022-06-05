package sm.supermarket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

import static javafx.scene.paint.Color.TRANSPARENT;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setScene(scene);
//        stage.show();
        Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.setFill(TRANSPARENT);
//        stage.initStyle(StageStyle.UNDECORATED);


    }

    public static void main(String[] args) {
        launch();
    }
}