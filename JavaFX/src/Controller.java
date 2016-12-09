// imports for Java FX
//javaFX_01
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
// need extends Application
public class Controller extends Application {

    Button button; //this creates a button object

    //needed to launch the main Java FX file
    public static void main(String[] args) {
        launch(args);
    }

    //starts the stage
    @Override
    public void start(Stage primaryStage) throws Exception {
        //defines the title of the stage
        primaryStage.setTitle("Scene 1");

        //defines the contents and look of the stage
        button = new Button();
        button.setText("Click me");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}