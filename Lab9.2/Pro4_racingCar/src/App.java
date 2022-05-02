import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
	@Override
	public void start(Stage primaryStage) {
        //Create a car
		Car carPane = new Car();

        carPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				carPane.increaseSpeed();
			}
			else if (e.getCode() == KeyCode.DOWN) {
				carPane.decreaseSpeed();
			}
		});
		carPane.setOnMousePressed(e -> carPane.pause());
		carPane.setOnMouseReleased(e -> carPane.play());

		//Create a scene
		Scene scene = new Scene(carPane, 400, 100);
		primaryStage.setTitle("วิ่งไปเรยแฮมทาโร่ ^O^");
		primaryStage.setScene(scene);
		primaryStage.show();
		carPane.requestFocus();
	}
}