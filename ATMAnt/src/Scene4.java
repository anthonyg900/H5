import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene4 {
    //Scene 4 variable
    protected static Scene scene4;

    //Set scene 4
    protected static Scene setScene4(Stage window, User user){
        //Reset attempts since card is being retained
        user.setAttempts(0);
        //Set up scene4
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label warning = new Label("Possible Security Threat");
        Label description = new Label("This card will be retained");
        //Set Id
        warning.setId("big-label");
        description.setId("med-label");
        //Button that directs to scene 4
        Button button = new Button("Exit");
        button.setOnAction(e -> window.setScene(Scene1.getScene1()));
        //Set width
        button.setMinWidth(100);
        button.getStyleClass().add("button-red");
        //Set Layout variables
        layout.getChildren().addAll(warning, description, button);
        //Create sceen with layout set and window width & height
        scene4 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene4.getStylesheets().add("screen.css");
        return scene4;
    }

    //Get Scene 4 if it has already been set
    protected static Scene getScene4(){return scene4;}
}