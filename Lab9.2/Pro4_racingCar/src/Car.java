import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Car extends Pane {
	private double x = 0;
	private double y = 100;
	private double radius = 5;
	private Rectangle rectangle;
	private Polygon polygon;
	private Circle circle1;
	private Circle circle2;
	private Timeline animat;

	Car(){
		drawCar();
		animat = new Timeline(
			new KeyFrame(Duration.millis(50), e -> moveCar()));
		animat.setCycleCount(Timeline.INDEFINITE);
		animat.play();
	}

	private void drawCar(){
		getChildren().clear();
		rectangle = new Rectangle(x, y - 20, 50, 10);
		polygon = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
		circle1 = new Circle(x + 15, y - 5, radius);
		circle2 = new Circle(x + 35, y - 5, radius);
        rectangle.setFill(Color.BLANCHEDALMOND);
        polygon.setFill(Color.BLANCHEDALMOND);
        circle1.setFill(Color.GREY);
        circle2.setFill(Color.GREY);
		getChildren().addAll(rectangle, circle1, circle2, polygon);
	}

	//---Pause animation---//
	public void pause() {
		animat.pause();
	}

	//---Play animation---//
	public void play() {
		animat.play();
	}

	//---Increase rate---//
	public void increaseSpeed() {
		animat.setRate(animat.getRate() + 1);
	}

	//---decrease rate---//
	public void decreaseSpeed() {
		animat.setRate(animat.getRate() > 0 ? animat.getRate() - 1 : 0);
	}

	//---Redraw car---//
	protected void moveCar() {
		if (x <= getWidth()) {
			x += 1;	
		} 
		else
			x = 0;
		drawCar();
	}
}
