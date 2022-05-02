import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        //created pane
		GridPane pane = new GridPane();
		pane.add(new ImageView(new Image("D:/My folder/VS Code/image/uk.gif")), 0, 0);
		pane.add(new ImageView(new Image("D:/My folder/VS Code/image/ca.gif")), 1, 0);
		pane.add(new ImageView(new Image("D:/My folder/VS Code/image/china.gif")), 0, 1);
		pane.add(new ImageView(new Image("D:/My folder/VS Code/image/us.gif")), 1, 1);

        //created scene
		Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise14_01");//set title
		primaryStage.show();
	}
    
}
