import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.NumberFormat;

public class Scene6 {
    //Scene 6 variable
    protected static Scene scene6;

    //Set scene 6
    protected static Scene setScene6(Stage window, User user){
        //Set up scene6
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label prompt = new Label("Your current balance is:");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Label balance = new Label(formatter.format(user.getBalance()));
        //Set Id
        prompt.setId("med-label");
        balance.setId("big-label");
        //Button that directs to scene 6
        Button button = new Button("Back to Keypad");
        button.setOnAction(e -> window.setScene(Scene5.getScene5()));
        button.getStyleClass().add("nav-button");
        //Set Layout variables
        layout.getChildren().addAll(prompt, balance, button);
        //Create sceen with layout set and window width & height
        scene6 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene6.getStylesheets().add("screen.css");
        //Return scene
        return scene6;
    }

    //Get Scene 6 if it has already been set
    protected static Scene getScene6(){return scene6;}
}