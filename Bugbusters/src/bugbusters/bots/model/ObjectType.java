/**
 * 
 */
package bugbusters.bots.model;

/**
 * @author User1
 *
 */
public enum ObjectType {
	NOOBJECT(-1), ROBOT(0), SHOT(1), WALL(2), COOKIE(3), MINE(4), LAST_OBJECT_TYPE(
			5);

	private int messageId;

	private ObjectType(int messageId) {
		this.messageId = messageId;
	}

	public int getMessageId() {
		return messageId;
	}

	public static ObjectType parseMessage(String id) {
		for (ObjectType type : values()) {
			if (Integer.parseInt(id) == type.getMessageId()) {
				return type;
			}
		}
		return null;
	}

}
