import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene15 {
    //Scene 15 variable
    protected static Scene scene15;

    //Set scene 15
    protected static Scene setScene15(Stage window){
        //Set up scene15
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label prompt = new Label("Have a nice day!");
        Label message = new Label("Thank you for using Rock Solid Credit Union");
        //Set Id
        prompt.setId("big-label");
        message.setId("med-label");
        //Button that directs to scene 6
        Button button = new Button("Back to Home");
        button.setOnAction(e -> window.setScene(Scene1.getScene1()));
        button.getStyleClass().add("nav-button");
        //Set Layout variables
        layout.getChildren().addAll(prompt, message, button);
        //Create sceen with layout set and window width & height
        scene15 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene15.getStylesheets().add("screen.css");
        //Return scene
        return scene15;
    }

    //Get Scene 15 if it has already been set
    protected static Scene getScene15(){return scene15;}
}