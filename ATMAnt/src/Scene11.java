import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene11 {
    //Scene 11 variable
    protected static Scene scene11;

    //Set scene 10
    protected static Scene setScene11(Stage window){
        //Set up scene4
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label prompt = new Label("Updating your balance!");
        Label description = new Label("Please take cash from dispenser");
        //Set Id
        prompt.setId("big-label");
        description.setId("med-label");
        //Button that directs to scene 4
        Button button = new Button("Return");
        button.setOnAction(e -> window.setScene(Scene5.getScene5()));
        //Set width
        button.setMinWidth(100);
        button.getStyleClass().add("nav-button");
        //Set Layout variables
        layout.getChildren().addAll(prompt, description, button);
        //Create sceen with layout set and window width & height
        scene11 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene11.getStylesheets().add("screen.css");
        return scene11;
    }

    //Get Scene 1 if it has already been set
    protected static Scene getScene11(){return scene11;}
}