/**
 * 
 */
package bugbusters.bots.model;

/**
 * @author User1
 *
 */
public enum MessageType {
	INITIALIZE(1001), //
	YOUR_NAME(1002), //
	YOUR_COLOUR(1003), //
	GAME_OPTION(1004), //
	GAME_STARTS(1005), //
	RADAR(1006), //
	INFO(1007), //
	ROBOT_INFO(1008), //
	ROTATION_REACHED(1009), //
	ENERGY(1010), //
	ROBOTS_LEFT(1011), //
	COLLISION(1012), //
	WARNING(1013), //
	DEAD(1014), //
	GAME_FINISHES(1015), //
	EXIT_ROBOT(1016), //
	COORDINATES(1017), //
	UNKNOWN_MESSAGE_TO_ROBOT(-1);
	private int messageId;

	private MessageType(int messageId) {
		this.messageId = messageId;
	}

	public int getMessageId() {
		return messageId;
	}

	public static MessageType parseMessage(String id) {
		for (MessageType type : values()) {
			if (Integer.parseInt(id) == type.getMessageId()) {
				return type;
			}
		}
		return null;
	}
}
