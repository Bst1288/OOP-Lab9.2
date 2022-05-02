import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        //creat clock
        //random hour minute and second
        ClockPane clock = new ClockPane((int)(Math.random() * 12), ((int)(Math.random() * 2)==1 ? 30 : 0), 0);
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		clock.setSecondHandVisible(false);
        //creat label for time
		Label time = new Label(timeString);

        BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(time);
		BorderPane.setAlignment(time, Pos.TOP_CENTER);

        //creat scene
        Scene scene = new Scene(pane, 250, 250); 
		primaryStage.setTitle("Exercise14_28");//set title
		primaryStage.setScene(scene);
		primaryStage.show();
    }
}
