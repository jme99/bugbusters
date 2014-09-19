package bugbusters.bots.model;

public class GameObject {

	private Double timeStamp;
	private Double xPos;
	private Double yPos;

	public GameObject(Double timeStamp, Double xPos, Double yPos) {
		super();
		this.timeStamp = timeStamp;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public Double getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Double timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getxPos() {
		return xPos;
	}

	public void setxPos(Double xPos) {
		this.xPos = xPos;
	}

	public Double getyPos() {
		return yPos;
	}

	public void setyPos(Double yPos) {
		this.yPos = yPos;
	}

}
