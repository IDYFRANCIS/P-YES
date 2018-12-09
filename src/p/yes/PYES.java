package p.yes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author IDONGESIT FRANCIS
 */
public class PYES extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLP-YES-LOGIN.fxml"));

        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("pyes-alone.png")));
        stage.setTitle("PRESIDENTIAL YOUTH EMPOWERMENT SCHEME");
        stage.setScene(scene);
        //stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
