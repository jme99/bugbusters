/**
 * 
 */
package bugbusters.bots.model;

/**
 * @author User1
 *
 */
public class Message {
	private MessageType type;
	private Double xPos;
	private Double yPos;
	private Double angle;
	private Double energyLevel;
	private Double distance;
	private Double velocity;
	private boolean yesNo;
	private Integer leftRobots;
	private ObjectType objectType;

	public Message(MessageType messageType) {
		this.type = messageType;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
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

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}

	public Double getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(Double energyLevel) {
		this.energyLevel = energyLevel;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getVelocity() {
		return velocity;
	}

	public void setVelocity(Double velocity) {
		this.velocity = velocity;
	}

	public boolean isYesNo() {
		return yesNo;
	}

	public void setYesNo(boolean yesNo) {
		this.yesNo = yesNo;
	}

	public Integer getLeftRobots() {
		return leftRobots;
	}

	public void setLeftRobots(Integer leftRobots) {
		this.leftRobots = leftRobots;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

}
