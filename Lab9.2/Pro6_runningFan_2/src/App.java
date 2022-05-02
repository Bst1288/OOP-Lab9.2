import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        //Create 3 buttons : pause resume reverse
		Button buttonPause = new Button("Pause");
		Button buttonResume = new Button("Resume");
		Button buttonReverse = new Button("Reverse");
        HBox buttonPane = new HBox(5);
		buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().addAll(buttonPause, buttonResume, buttonReverse); //Place nodes

        //Create new FanPane
        FanPane fan = new FanPane();

        //Create slider
        Slider slider = new Slider();
		slider.setMax(7);
		fan.rateProperty().bind(slider.valueProperty());

        //Create pane
        BorderPane borderPane = new BorderPane();
		borderPane.setTop(buttonPane);
		borderPane.setCenter(fan);
		borderPane.setBottom(slider);

        buttonPause.setOnAction( (e -> {fan.pause();}) );
        buttonResume.setOnAction( (e -> {fan.resume();}) );
        buttonReverse.setOnAction( (e -> {fan.reverse();}) );

        //Create scene
		Scene scene = new Scene(borderPane, 250, 250);
		primaryStage.setTitle("Exercise16_18"); //set title
		primaryStage.setScene(scene);
		primaryStage.show();

    }
}
