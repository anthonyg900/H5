import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene5 {
    //Scene 5 variable
    protected static Scene scene5;

    //Set scene 5
    protected static Scene setScene5(Stage window, User user){
        //Set up scene5
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label welcome = new Label("Welcome!");
        Label instruction = new Label("Select your transaction:");
        //Set Id
        welcome.setId("big-label");
        instruction.setId("med-label");
        //Button that directs to respective scene
        Button balance = new Button("Balance");
        Button deposit = new Button("Deposit");
        Button withdrawal = new Button("Withdrawal");
        Button cancel = new Button("Cancel");
        //Set button width
        balance.setMinWidth(100);
        deposit.setMinWidth(100);
        withdrawal.setMinWidth(100);
        cancel.setMinWidth(100);
        //Set button ids
        balance.getStyleClass().add("button-blue");
        deposit.getStyleClass().add("button-blue");
        withdrawal.getStyleClass().add("button-blue");
        cancel.getStyleClass().add("button-red");
        //Set action
        balance.setOnAction(e -> window.setScene(Scene6.setScene6(window, user)));
        deposit.setOnAction(e -> window.setScene(Scene13.setScene13(window, user)));
        withdrawal.setOnAction(e -> window.setScene(Scene7.setScene7(window, user)));
        cancel.setOnAction(e -> window.setScene(Scene15.setScene15(window)));
        //Set Layout variables
        layout.getChildren().addAll(welcome, instruction, balance, deposit, withdrawal, cancel);
        //Create sceen with layout set and window width & height
        scene5 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene5.getStylesheets().add("screen.css");
        return scene5;
    }

    //Get Scene 5 if it has already been set
    protected static Scene getScene5(){return scene5;}
}