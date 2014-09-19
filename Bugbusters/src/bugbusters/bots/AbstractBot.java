package bugbusters.bots;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bugbusters.bots.model.BotModel;
import bugbusters.bots.model.Message;
import bugbusters.bots.model.MessageType;
import bugbusters.bots.model.ObjectType;
import bugbusters.bots.model.World;
import bugbusters.io.MessageHandlerIn;
import bugbusters.io.MessageHandlerOut;

/**
 * Botklasse von der alle weiteren Bots erben sollen.
 * 
 * @author Jannick
 *
 */
public class AbstractBot extends Thread {

	protected BufferedReader bf;
	protected MessageHandlerIn handlerIn;
	protected MessageHandlerOut handlerOut;
	protected BotModel model;
	private World world;

	public AbstractBot() {
		bf = new BufferedReader(new InputStreamReader(System.in));
		handlerIn = new MessageHandlerIn();
		handlerOut = new MessageHandlerOut();
		model = new BotModel();
		world = new World();
	}

	protected Message parseMessage(String inMessage) {
		String[] chunks = inMessage.split(" ");
		MessageType messageType = MessageType.parseMessage(chunks[0]);
		Message message = new Message(messageType);

		switch (messageType) {
		case COLLISION:
			break;
		case COORDINATES:
			break;
		case DEAD:
			model.setDead(true);
			break;
		case ENERGY:
			// message.setEnergyLevel(parseDouble(chunks[1]));
			model.setLevel(parseDouble(chunks[1]));
			break;
		case EXITROBOT:
			break;
		case GAMEFINISHES:
			break;
		case GAMEOPTION:
			break;
		case GAMESTARTS:
			break;
		case INFO:
			break;
		case INITIALIZE:
			message.setYesNo(parseBoolean(chunks[1]));
			if ("1".equals(chunks[1])) {
				handlerOut.sendMessage("Name " + model.getName()
						+ " Team: BUG-BUSTERS");
				handlerOut.sendMessage("Colour FF0000 00FF00");
			}
			break;
		case RADAR:
			message.setVelocity(parseDouble(chunks[1]));
			message.setAngle(parseDouble(chunks[3]));
			message.setObjectType(ObjectType.parseMessage(chunks[2]));
			break;
		case ROBOTSLEFT:
			message.setLeftRobots(parseInteger(chunks[1]));
			break;
		case ROBOTINFO:
			message.setAngle(parseDouble(chunks[1]));
			message.setYesNo(parseBoolean(chunks[2]));
			break;
		case ROTATIONREACHED:
			break;
		case UNKNOWN_MESSAGE_TO_ROBOT:
			break;
		case WARNING:
			break;
		case YOURCOLOUR:
			break;
		case YOURNAME:
			break;
		default:
			break;
		}
		return message;
	}

	private Integer parseInteger(String string) {
		if (string != null) {
			return Integer.parseInt(string);
		}
		return null;
	}

	private Double parseDouble(String string) {
		if (string != null) {
			return Double.parseDouble(string);
		}
		return null;
	}

	private boolean parseBoolean(String chunk) {
		if (chunk != null) {
			return Integer.parseInt(chunk) == 1;
		}
		return false;
	}

	public BotModel getModel() {
		return model;
	}

	public World getWorld() {
		return world;
	}

}
