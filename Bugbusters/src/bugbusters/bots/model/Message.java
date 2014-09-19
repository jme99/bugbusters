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
	private Integer energyLevel;
	private Boolean hostile;
	private Double distance;
	private Double velocity;

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

	public Integer getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(Integer energyLevel) {
		this.energyLevel = energyLevel;
	}

	public Boolean getHostile() {
		return hostile;
	}

	public void setHostile(Boolean hostile) {
		this.hostile = hostile;
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

}
