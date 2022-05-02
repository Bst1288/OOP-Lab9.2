import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        FanPane fanPane = new FanPane();
        
        //Create 3 buttons : pause resume reverse
		Button buttonPause = new Button("Pause");
		Button buttonResume = new Button("Resume");
		Button buttonReverse = new Button("Reverse");
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(buttonPause, buttonResume, buttonReverse); //Place nodes

        //Create border pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(fanPane);
		borderPane.setBottom(hBox);

        buttonPause.setOnAction( (e -> {fanPane.pause();}) );
        buttonResume.setOnAction( (e -> {fanPane.resume();}) );
        buttonReverse.setOnAction( (e -> {fanPane.reverse();}) );

        //Create scene
		Scene scene = new Scene(borderPane, 250, 250);
		primaryStage.setTitle("Exercise15_28"); //set title
		primaryStage.setScene(scene);
		primaryStage.show();

		fanPane.requestFocus();
    }
}
