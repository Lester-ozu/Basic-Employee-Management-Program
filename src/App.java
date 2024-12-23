import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{ 
    public static void main(String[] args) throws Exception {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("arrayListDefined.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("designCSS.css").toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Employee Information Manager");
            primaryStage.show();
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }
}
