import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Scene2{
    //Scene 2 variables
    protected static Scene scene2;
    private static String pinNumber = "";
    private static Label pinLabel;

    //Set Scene 2
    protected static Scene setScene2(Stage window, User user){
        //Create layout for upper part of screen
        VBox upperlayout = new VBox(20);
        upperlayout.setAlignment(Pos.CENTER);
        //Labels
        Label prompt = new Label("Please enter your ATM pin");
        pinLabel = new Label("");
        //String to store pin number
        //Clears pin label and pinNumber (used when returning from a different stage)
        clearPin();
        //Set Id
        pinLabel.setId("big-label");
        prompt.setId("top-label");
        //Set Layout variables
        upperlayout.getChildren().addAll(prompt, pinLabel);

        //Create grid for lower part of screen
        GridPane lowerGrid = new GridPane();
        lowerGrid.getStyleClass().add("keypad");
        lowerGrid.setAlignment(Pos.CENTER);
        lowerGrid.setPadding(new Insets(10, 10, 10, 10));
        lowerGrid.setVgap(8);
        lowerGrid.setHgap(10);

        //Create each button for number pad
        Button printReciept = new Button("Print Receipt");
        Button enter = new Button("Enter");
        Button clear = new Button("Clear");
        Button cancel = new Button("Cancel");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button0 = new Button("0");

        //Set width & style
        printReciept.getStyleClass().add("button-blue");
        enter.getStyleClass().add("button-blue");
        clear.getStyleClass().add("button-red");
        cancel.getStyleClass().add("button-red");
        pinLabel.setId("pin-label");
        printReciept.setMinWidth(100);
        enter.setMinWidth(100);
        clear.setMinWidth(100);
        cancel.setMinWidth(100);

        //Set Constraints on grid
        lowerGrid.setConstraints(printReciept, 0, 0);
        lowerGrid.setConstraints(enter, 4, 0);
        lowerGrid.setConstraints(clear, 0, 3);
        lowerGrid.setConstraints(cancel, 4, 3);
        lowerGrid.setConstraints(button1, 1, 0);
        lowerGrid.setConstraints(button2, 2, 0);
        lowerGrid.setConstraints(button3, 3, 0);
        lowerGrid.setConstraints(button4, 1, 1);
        lowerGrid.setConstraints(button5, 2, 1);
        lowerGrid.setConstraints(button6, 3, 1);
        lowerGrid.setConstraints(button7, 1, 2);
        lowerGrid.setConstraints(button8, 2, 2);
        lowerGrid.setConstraints(button9, 3, 2);
        lowerGrid.setConstraints(button0, 2, 3);

        //Set keypad actions
        button1.setOnAction(e -> appendToPin(1));
        button2.setOnAction(e -> appendToPin(2));
        button3.setOnAction(e -> appendToPin(3));
        button4.setOnAction(e -> appendToPin(4));
        button5.setOnAction(e -> appendToPin(5));
        button6.setOnAction(e -> appendToPin(6));
        button7.setOnAction(e -> appendToPin(7));
        button8.setOnAction(e -> appendToPin(8));
        button9.setOnAction(e -> appendToPin(9));
        button0.setOnAction(e -> appendToPin(0));
        clear.setOnAction(e -> clearPin());
        enter.setOnAction(e -> checkPin(window, user));
        cancel.setOnAction(e -> window.setScene(Scene1.getScene1()));

        //Add each to lower grid
        lowerGrid.getChildren().addAll(printReciept, enter, clear, cancel,
                button1, button2, button3, button4, button5, button6, button7,
                button8, button9, button0);

        //Combine top and bottom into one pane
        BorderPane layout = new BorderPane();
        layout.setTop(upperlayout);
        layout.setCenter(lowerGrid);

        //Draw scene
        scene2 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene2.getStylesheets().add("screen.css");
        //Return new scene
        return scene2;
    }

    //Get Scene 2 if it has already been set
    public static Scene getScene2(){return scene2;}

    //Set entered pin
    private static void appendToPin(int x){
        //Add to pinNumber while it's less than 4
        if(pinNumber.length() < 4) {
            pinNumber += x;
            pinLabel.setText(pinLabel.getText() + " • ");
        }
    }

    //Clear pinLabel and pinNumber
    private static void clearPin(){
        pinLabel.setText("");
        pinNumber = "";
    }

    //Check pin to see if it matches
    private static void checkPin(Stage window, User user){
        //If a valid length pin has been entered
        if(pinNumber.length() >= 4) {
            //Get hashed pin
            String hashedPin = hashPin();
            //If correct pin go to account or lock out screen or invalid pin stage
            if (hashedPin.equals(user.getPin())) {
                user.setAttempts(0);
                window.setScene(Scene5.setScene5(window, user));
            } else if(user.getAttempts() >= 3) {
                window.setScene(Scene4.setScene4(window, user));
            } else {
                clearPin();
                window.setScene(Scene3.setScene3(window));
            }
            //Increment attempts
            user.setAttempts(user.getAttempts() + 1);
        }
    }

    //Create hash of entered pin
    private static String hashPin(){
        try {
            byte[] bytesOfMessage = pinNumber.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            return new String(thedigest, StandardCharsets.UTF_8);
        }catch (Exception e){
            return null;
        }
    }
}