import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
		pane.setPadding(new Insets(15, 15, 15, 15));

        //row(r) = 10 and column(c) = 10
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                TextField textField = new TextField();
                //random num 0,1
                textField.setText(String.valueOf((int)(Math.random()*2)));
                textField.setAlignment(Pos.CENTER);
                textField.setMaxWidth(30);
                pane.add(textField,c,r);
            }
        }

        Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_07");//Set title
		primaryStage.setScene(scene);
		primaryStage.show();
        
    }
}
