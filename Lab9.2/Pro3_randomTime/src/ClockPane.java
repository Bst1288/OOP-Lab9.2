import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane{
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;
    private double h = 250;
    double w = 250;
    public ClockPane(){
        setTime();
    }

    public ClockPane(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        madeClock();
    }

    //------------------------------------------------------------------------------//

    //---set methoods---//
    public void setHour(int hour){
		this.hour = hour;
		madeClock();
	}

    public void setMinute(int minute){
		this.minute = minute;
		madeClock();
	}

    public void setSecond(int second){
		this.second = second;
		madeClock();
	}

    public void setWidth(double w){
		this.w = w;
		madeClock();
	}

    public void setHeigt(double h){
		this.h = h;
		madeClock();
	}

    public void setHourHandVisible(boolean hourHandVisible){
		this.hourHandVisible = hourHandVisible;
		madeClock();
	}

    public void setMinuteHandVisible(boolean minuteHandVisible){
		this.minuteHandVisible = minuteHandVisible;
		madeClock();
	}

    public void setSecondHandVisible(boolean secondHandVisible){
		this.secondHandVisible = secondHandVisible;
		madeClock();
	}

    public void setTime(){
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
        madeClock();
    }
    //------------------------------------------------------------------------------//

    //---get methods---//
    public int getHour(){
		return hour;
	}

    public int getMinute(){
		return minute;
	}

    public int getSecond(){
		return second;
	}

    public double getWidth(double w){
		return w;
	}

    public double getHeigt(double h){
		return h;
	}

    public boolean getHourHandVisible(boolean hourHandVisible){
		return hourHandVisible;
	}

    public boolean getMinuteHandVisible(boolean minuteHandVisible){
		return minuteHandVisible;
	}

    public boolean getSecondHandVisible(boolean secondHandVisible){
		return secondHandVisible;
	}

    //------------------------------------------------------------------------------//

    protected void madeClock(){
        double radius = Math.min(w, h) * 0.8 * 0.5;
        double x = w/47;
		double y = h/2.1;

        //Draw circle 
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.POWDERBLUE);
		circle.setStroke(Color.BLACK);
        //number in clock : 12, 3, 6, 9
        Text t1 = new Text(x - 5, y - radius + 12, "12");
        Text t3 = new Text(x + radius - 10, y + 3, "3");
		Text t4 = new Text(x - 3, y + radius - 3, "6");
        Text t2 = new Text(x - radius + 3, y + 5, "9");

        //Draw hour handle (เข็มชั่วโมง)
        double hourLength = radius * 0.5;
		double hourX = x + hourLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = y - hourLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hourLine = new Line(x, y, hourX, hourY);
		hourLine.setStroke(Color.BLUEVIOLET);
        
        //Draw minute handle (เข็มนาที)
        double minuteLength = radius * 0.65;
		double minuteX = x + minuteLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = y - minuteLength * Math.cos(minute * (2 * Math.PI / 60));
		Line minuteLine = new Line(x, y, minuteX, minuteY);
		minuteLine.setStroke(Color.BLUE);

        //Draw second handle(เข็มวินาที)
        double secondLength = radius * 0.8;
		double secondX = x + secondLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = y - secondLength * Math.cos(second * (2 * Math.PI / 60));
		Line secondLine = new Line(x, y, secondX, secondY);
		secondLine.setStroke(Color.BLACK);

        getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4);
        if (hourHandVisible)
			getChildren().add(hourLine);
		if (minuteHandVisible)
			getChildren().add(minuteLine);
        if(secondHandVisible)
            getChildren().add(secondLine);
		
    }
}
