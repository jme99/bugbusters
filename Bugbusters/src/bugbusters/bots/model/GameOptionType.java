package bugbusters.bots.model;

public enum GameOptionType {
	ROBOT_MAX_ROTATE(0), //
	ROBOT_CANNON_MAX_ROTATE(1), //
	ROBOT_RADAR_MAX_ROTATE(2), //

	ROBOT_MAX_ACCELERATION(3), //
	ROBOT_MIN_ACCELERATION(4), //

	ROBOT_START_ENERGY(5), //
	ROBOT_MAX_ENERGY(6), //
	ROBOT_ENERGY_LEVELS(7), //

	SHOT_SPEED(8), //
	SHOT_MIN_ENERGY(9), //
	SHOT_MAX_ENERGY(10), //
	SHOT_ENERGY_INCREASE_SPEED(11), //

	TIMEOUT(12), //
	DEBUG_LEVEL(13), //
	SEND_ROBOT_COORDINATES(14);//

	private int id;

	private GameOptionType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
