//javaFX-04
import javafx.application.*;
        import javafx.stage.*;
        import javafx.scene.*;
        import javafx.scene.layout.*;
        import javafx.scene.control.*;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Button 1
        Label label1 = new Label("Welcome to");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);


        //Button for num 1
        Button num1 = new Button("1");
        num1.setOnAction(e -> window.setScene(scene1));

        //Button for num 2
        Button num2 = new Button("2");
        num2.setOnAction(e -> window.setScene(scene1));

        //Button for num 3
        Button num3 = new Button("3");
        num3.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(num1);
        layout2.getChildren().add(num2);
        layout2.getChildren().add(num3);
        scene2 = new Scene(layout2, 600, 300);

        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Scene 1");
        window.show();
    }

}