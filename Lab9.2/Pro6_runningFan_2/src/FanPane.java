import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.beans.property.DoubleProperty;

public class FanPane extends Pane{
    private Circle circle = new Circle();
    private double startAngle = 15; //Start angle
	private Timeline fan;
	private Pane blades = new Pane(); //Create 4 arcs
	private Arc arc;
    private ObservableList<Node> list = blades.getChildren();
    
    //---Constuct FanPane---//
    public FanPane(){
        setPadding(new Insets(10, 10, 10, 10));
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.LIGHTGOLDENRODYELLOW);
		circle.centerXProperty().bind(widthProperty().divide(2));
		circle.centerYProperty().bind(heightProperty().divide(2));
		circle.radiusProperty().bind((heightProperty().divide(2)).multiply(.90));
		getBlades();
        getChildren().addAll(circle, blades);
		fan = new Timeline(new KeyFrame(Duration.millis(50), e -> spin()));
		fan.setCycleCount(Timeline.INDEFINITE);
		fan.play(); //Start animation
    }

    //---Animetion fane blades---//
    protected void spin(){
        for(int i = 0; i < list.size(); i++){
            Arc a = (Arc)list.get(i);
            a.setStartAngle(a.getStartAngle()+startAngle);
        }
    }

    //---Animetion pause---//
    public void pause(){
        fan.pause();
    }

    //---Animetion resume---//
    public void resume(){
        fan.play();
    }

    //---Animetion reverse---//
    protected void reverse(){
        startAngle *= -1;
    }

    //---Return rateProperty---// (กรอ slide ไปมา)
        public DoubleProperty rateProperty(){
            return fan.rateProperty();
        }

    //---Add 4 arc to a pane---//
    private void getBlades(){
        double angle = 0;
        for(int i = 0; i < 4; i++){
            arc = new Arc(); 
			arc.centerXProperty().bind(widthProperty().divide(2));
			arc.centerYProperty().bind(heightProperty().divide(2));
			arc.radiusXProperty().bind(circle.radiusProperty().multiply(.90));
			arc.radiusYProperty().bind(circle.radiusProperty().multiply(.90));
			arc.setStartAngle(angle + 90);
			arc.setLength(50);
			arc.setFill(Color.PEACHPUFF);
			arc.setType(ArcType.ROUND);
			blades.getChildren().add(arc);
			angle += 90;
        }
    }
}
