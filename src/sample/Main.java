package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    private static Scene scene;
    private static Stage primaryStage;
    public static Stage secondStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        try {
            scene = new Scene(loadFXML("sample"));
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("Vivero - Index");
            primaryStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFXML(String fxml, String title) throws IOException {
        scene.setRoot(loadFXML(fxml));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.setTitle(title);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Scene getScene() {
        return scene;
    }

    public static void newStage(String fxml, String title) {
        try {
            Parent node = loadFXML(fxml);
            secondStage = new Stage();
            Scene scene = new Scene(node);
            secondStage.setScene(scene);
            secondStage.setTitle(title);
            secondStage.initOwner(primaryStage);
            secondStage.initModality(Modality.WINDOW_MODAL);
            secondStage.centerOnScreen();
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}