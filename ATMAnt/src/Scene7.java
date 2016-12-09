import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene7 {
    protected static Scene scene7;
    private static String withdrawal = "0";
    private static Label withdrawalLabel;

    //Set Scene 7
    protected static Scene setScene7(Stage window, User user) {
        //Create layout for upper part of screen
        VBox upperlayout = new VBox(20);
        upperlayout.setAlignment(Pos.CENTER);
        //Labels
        Label prompt = new Label("Enter withdrawal amount:");
        Label message = new Label("Must a be multiple of $10");
        withdrawalLabel = new Label("");
        //String to store pin number
        //Clears pin label and withdrawal (used when returning from a different stage)
        clearAmount();
        //Set Id
        withdrawalLabel.setId("big-label");
        message.setId("med-label");
        prompt.setId("top-label");
        //Set Layout variables
        upperlayout.getChildren().addAll(prompt, message, withdrawalLabel);

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
        withdrawalLabel.setId("pin-label");
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
        clear.setOnAction(e -> clearAmount());
        enter.setOnAction(e -> checkAmount(window, user));
        cancel.setOnAction(e -> window.setScene(Scene5.getScene5()));

        //Add each to lower grid
        lowerGrid.getChildren().addAll(printReciept, enter, clear, cancel,
                button1, button2, button3, button4, button5, button6, button7,
                button8, button9, button0);

        //Combine top and bottom into one pane
        BorderPane layout = new BorderPane();
        layout.setTop(upperlayout);
        layout.setCenter(lowerGrid);

        //Draw scene
        scene7 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene7.getStylesheets().add("screen.css");
        //Return new scene
        return scene7;
    }

    //Get Scene 2 if it has already been set
    public static Scene getScene7() {
        return scene7;
    }

    //Set entered pin
    private static void appendToPin(int x) {
        if(withdrawal.equals("0"))
            withdrawal = Integer.toString(x);
        else if(withdrawal.length() < 4)
            withdrawal += x;
        withdrawalLabel.setText("$" + withdrawal);
    }

    //Clear withdrawalLabel and withdrawal
    private static void clearAmount() {
        withdrawal = "0";
        withdrawalLabel.setText("$" + withdrawal);
    }

    //Check pin to see if it matches
    private static void checkAmount(Stage window, User user) {
        try {
            //If a valid amount has been entered
            if (Integer.parseInt(withdrawal) % 10 == 0 && user.getBalance() >= Integer.parseInt(withdrawal)) {
                user.setBalance(user.getBalance() - Integer.parseInt(withdrawal));
                window.setScene(Scene11.setScene11(window));
            } else if (Integer.parseInt(withdrawal) % 10 != 0) {
                window.setScene(Scene9.setScene9(window));
            } else if (user.getBalance() < Integer.parseInt(withdrawal)) {
                window.setScene(Scene8.setScene8(window));
            } else {
                window.setScene(Scene10.setScene10(window));
            }
        } catch (Exception e){
            window.setScene(Scene10.setScene10(window));
        }
    }
}

