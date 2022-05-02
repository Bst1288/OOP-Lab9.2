import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.collections.ObservableList;
import javafx.util.Duration;

public class FanPane extends StackPane{
    private double startAngle = 15; //Start angle
	private Timeline fan;
	private Pane blades = getBlades(); //Create four arcs
	private ObservableList<Node> list = blades.getChildren();
    
    //---Constuct FanPane---//
    public FanPane(){
        getChildren().addAll(getCircle(), blades);
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

    //---Return circle---//
    private Circle getCircle(){
        Circle circle = new Circle();
		circle.setRadius(100);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.PALEGREEN);
		return circle;
    }

    //---Add 4 arc to a pane---//
    private Pane getBlades(){
        Pane pane = new Pane();
        double angle = 0;
        for(int i = 0; i < 4; i++){
            Arc arc = new Arc(125, 115, 90, 90, angle + 90, 50);
			arc.setFill(Color.LEMONCHIFFON);
			arc.setType(ArcType.ROUND);
			pane.getChildren().add(arc);
			angle += 90;
        }
        return pane;
    }
}
