import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene9 {
    //Scene 9 variable
    protected static Scene scene9;

    //Set scene 9
    protected static Scene setScene9(Stage window){
        //Set up scene4
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label warning = new Label("ATM can only dispense $10 notes!");
        Label description = new Label("Please enter a new amount");
        //Set Id
        warning.setId("big-label");
        description.setId("med-label");
        //Button that directs to scene 4
        Button button = new Button("Return");
        button.setOnAction(e -> window.setScene(Scene7.getScene7()));
        //Set width
        button.setMinWidth(100);
        button.getStyleClass().add("button-red");
        //Set Layout variables
        layout.getChildren().addAll(warning, description, button);
        //Create sceen with layout set and window width & height
        scene9 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene9.getStylesheets().add("screen.css");
        return scene9;
    }

    //Get Scene 9 if it has already been set
    protected static Scene getScene9(){return scene9;}
}