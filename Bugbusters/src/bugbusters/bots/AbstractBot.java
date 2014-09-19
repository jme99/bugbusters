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
	private BotModel model;
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
		case EXIT_ROBOT:
			break;
		case GAME_FINISHES:
			break;
		case GAME_OPTION:
			break;
		case GAME_STARTS:
			break;
		case INFO:
			break;
		case INITIALIZE:
			message.setYesNo(parseBoolean(chunks[1]));
			break;
		case RADAR:
			message.setVelocity(parseDouble(chunks[1]));
			message.setAngle(parseDouble(chunks[3]));
			message.setObjectType(ObjectType.parseMessage(chunks[2]));
			break;
		case ROBOTS_LEFT:
			message.setLeftRobots(parseInteger(chunks[1]));
			break;
		case ROBOT_INFO:
			message.setAngle(parseDouble(chunks[1]));
			message.setYesNo(parseBoolean(chunks[2]));
			break;
		case ROTATION_REACHED:
			break;
		case UNKNOWN_MESSAGE_TO_ROBOT:
			break;
		case WARNING:
			break;
		case YOUR_COLOUR:
			break;
		case YOUR_NAME:
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
