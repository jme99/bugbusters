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
	YOURNAME(1002), //
	YOURCOLOUR(1003), //
	GAMEOPTION(1004), //
	GAMESTARTS(1005), //
	RADAR(1006), //
	INFO(1007), //
	ROBOTINFO(1008), //
	ROTATIONREACHED(1009), //
	ENERGY(1010), //
	ROBOTSLEFT(1011), //
	COLLISION(1012), //
	WARNING(1013), //
	DEAD(1014), //
	GAMEFINISHES(1015), //
	EXITROBOT(1016), //
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
			if (id.equalsIgnoreCase(type.toString())) {
				return type;
			}
		}
		System.out.println("Echo unknown Message: " + id);
		return UNKNOWN_MESSAGE_TO_ROBOT;
	}
}
