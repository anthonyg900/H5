import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Scene13 {
    //Scene 13 variable
    protected static Scene scene13;

    //Set scene 13
    protected static Scene setScene13(Stage window, User user){
        //Set up scene4
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label prompt = new Label("Please insert your deposit slip!");
        Label description = new Label("(Generates random deposit slip amount)");
        //Set Id
        prompt.setId("big-label");
        description.setId("med-label");
        //Button that directs to scene 4
        Button button = new Button("Deposit Slip");
        Button cancel = new Button("Cancel");
        button.setOnAction(e -> addToBalance(window, user));
        cancel.setOnAction(e -> window.setScene(Scene5.getScene5()));
        //Set width
        button.setMinWidth(100);
        cancel.setMinWidth(100);
        button.getStyleClass().add("nav-button");
        cancel.getStyleClass().add("button-red");
        //Set Layout variables
        layout.getChildren().addAll(prompt, description, button, cancel);
        //Create sceen with layout set and window width & height
        scene13 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene13.getStylesheets().add("screen.css");
        return scene13;
    }

    //Increase balance
    public static void addToBalance(Stage window, User user){
        try {
            Random r = new Random();
            user.setBalance(user.getBalance() + ((r.nextInt(9) + 1) * 10));
            window.setScene(Scene14.setScene14(window));
        } catch (Exception e){
            window.setScene(Scene12.setScene12(window));
        }
    }

    //Get Scene 13 if it has already been set
    protected static Scene getScene13(){return scene13;}
}