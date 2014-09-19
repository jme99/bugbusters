/**
 * 
 */
package bugbusters.bots.model;

/**
 * @author User1
 *
 */
public class BotModel {

	private String name;
	private String color;

	private double xPos;
	private double yPos;
	private double botAngle;
	private double radarwAngle;
	private double cannonAngle;

	private double gameTime;

	private double velocity;
	private double level;

	private boolean dead;
	private boolean gameStarted;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public double getBotAngle() {
		return botAngle;
	}

	public void setBotAngle(double botAngle) {
		this.botAngle = botAngle;
	}

	public double getRadarwAngle() {
		return radarwAngle;
	}

	public void setRadarwAngle(double radarwAngle) {
		this.radarwAngle = radarwAngle;
	}

	public double getCannonAngle() {
		return cannonAngle;
	}

	public void setCannonAngle(double cannonAngle) {
		this.cannonAngle = cannonAngle;
	}

	public double getGameTime() {
		return gameTime;
	}

	public void setGameTime(double gameTime) {
		this.gameTime = gameTime;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
}