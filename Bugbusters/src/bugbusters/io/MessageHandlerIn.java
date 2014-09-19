package bugbusters.io;

/**
 * Soll die Nachtichten vom Server lesen und in ein für den Roboter schnell zu
 * lesendes Format umwandleln. zB int ?!?!
 * 
 * @author Jannick
 *
 */
public class MessageHandlerIn {

	// Nachrichtenarten, die der Roboter erhalten kann
    public static final int 
	INITIALIZE = 1001,
	YOUR_NAME = 1002,
	YOUR_COLOUR = 1003,
	GAME_OPTION = 1004,
	GAME_STARTS = 1005,
	RADAR = 1006,
	INFO = 1007,
	ROBOT_INFO = 1008,
	ROTATION_REACHED = 1009,
	ENERGY = 1010,
	ROBOTS_LEFT = 1011,
	COLLISION = 1012,
	WARNING = 1013,
	DEAD = 1014,
	GAME_FINISHES = 1015,
	EXIT_ROBOT = 1016,
	COORDINATES=1017,
	UNKNOWN_MESSAGE_TO_ROBOT = -1;
    
	public int identifyMessageType(String message) {
		if (message == null) return UNKNOWN_MESSAGE_TO_ROBOT;
		if (message.equals("Radar")) return RADAR;
		if (message.equals("Info")) return INFO;
		if (message.equals("RobotInfo")) return ROBOT_INFO;
		if (message.equals("Collision")) return COLLISION;
		if (message.equals("Energy")) return ENERGY;
		if (message.equals("RotationReached")) return ROTATION_REACHED;
		if (message.equals("RobotsLeft")) return ROBOTS_LEFT;
		if (message.equals("GameOption")) return GAME_OPTION;
		if (message.equals("GameStarts")) return GAME_STARTS;
		if (message.equals("Initialize")) return INITIALIZE;
		if (message.equals("Warning")) return WARNING;
		if (message.equals("Dead"))  return DEAD;
		if (message.equals("GameFinishes"))  return GAME_FINISHES;
		if (message.equals("ExitRobot"))  return EXIT_ROBOT;
		if (message.equals("YourName"))  return YOUR_NAME;
		if (message.equals("YourColour"))  return YOUR_COLOUR;
		if (message.equals("Coordinates"))  return COORDINATES;
		return UNKNOWN_MESSAGE_TO_ROBOT;
	}

}
