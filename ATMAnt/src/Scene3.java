import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene3 {
    //Scene 3 variable
    protected static Scene scene3;

    //Set scene 3
    protected static Scene setScene3(Stage window){
        //Set up scene3
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label warning = new Label("Invalid Pin Entry!");
        Label instruction = new Label("Please try again!");
        //Set Id
        instruction.setId("med-label");
        warning.setId("big-label");
        //Button that directs to scene 3
        Button button = new Button("Back to Keypad");
        button.setOnAction(e -> window.setScene(Scene2.getScene2()));
        button.getStyleClass().add("button-red");
        //Set Layout variables
        layout.getChildren().addAll(warning, instruction, button);
        //Create sceen with layout set and window width & height
        scene3 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene3.getStylesheets().add("screen.css");
        //Return scene
        return scene3;
    }

    //Get Scene 3 if it has already been set
    protected static Scene getScene3(){return scene3;}
}