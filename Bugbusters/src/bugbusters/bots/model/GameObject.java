package bugbusters.bots.model;

import java.awt.Point;

public class GameObject {

	private Double timeStamp;
	private Point position;

	public GameObject(Double timeStamp, Point position) {
		super();
		this.timeStamp = timeStamp;
		this.position = position;
	}

	public Double getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Double timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

}
