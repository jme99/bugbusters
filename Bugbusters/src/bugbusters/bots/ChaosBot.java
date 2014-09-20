package bugbusters.bots;

import java.io.IOException;

import bugbusters.bots.model.Message;

public class ChaosBot extends AbstractBot {

	private Object angle;

	public ChaosBot() {
		super();
	}

	public static void main(String[] args) {
		new ChaosBot().run();
	}

	@Override
	public void run() {
		do {
			try {
				if (bf.ready()) {
					String line = bf.readLine();
					handlerOut.echo("Empfangen: " + line);
					Message message = this.parseMessage(line);

					if (message != null) {
						switch (message.getType()) {
						case COLLISION:
							break;
						case COORDINATES:
							break;
						case DEAD:
							break;
						case ENERGY:
							break;
						case EXITROBOT:
							break;
						case GAMEFINISHES:
							break;
						case GAMEOPTION:
							break;
						case GAMESTARTS:
							handlerOut.sendMessage("Accelerate "
									+ model.getMaxAcceleartion());
							break;
						case INFO:
							break;
						case INITIALIZE:
							handlerOut.sendMessage("Accelerate "
									+ model.getMaxAcceleartion());
							break;
						case RADAR:
							consumeRadar(message);
							break;
						case ROBOTINFO:
							consumeRobotInfo(message);
							break;
						case ROBOTSLEFT:
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
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		} while (!model.isDead());

	}

	private void moveToCookie(Message m) {
		handlerOut.sendMessage("RotateTo " + 1 + " " + 1 + " " + m.getAngle());
		handlerOut.sendMessage("Accelerate " + model.getMaxAcceleartion());
		handlerOut.sendMessage("Shoot 1");
	}

	private void consumeRadar(Message message) {
		Double distance = message.getDistance();
		angle = message.getAngle();
		switch (message.getObjectType()) {
		case COOKIE:
			moveToCookie(message);
			break;
		case LAST_OBJECT_TYPE:
			break;
		case MINE:
			handlerOut.sendMessage("Shoot 1");
			break;
		case NOOBJECT:
			break;
		case ROBOT:
			break;
		case SHOT:
			break;
		case WALL:
			if (distance < 4.0) {
				handlerOut.sendMessage("Brake 1");
				handlerOut.sendMessage("RotateAmount " + 1 + " " + 1 + " "
						+ 0.6);
			} else {
				handlerOut.sendMessage("Brake 0");
				handlerOut.sendMessage("Accelerate 1");
			}
			break;
		default:
			break;
		}
	}

	private void consumeRobotInfo(Message message) {
		if (message.isYesNo()) {
			// friend
			handlerOut.sendMessage("RotateAmount " + 1 + " " + 1 + " " + 0.35);
		} else {
			// foe
			handlerOut
					.sendMessage("RotateAmount " + 1 + " " + 10 + " " + angle);
			handlerOut.sendMessage("Shoot 5");
			handlerOut.sendMessage("Shoot 5");
			handlerOut.sendMessage("Shoot 5");
			handlerOut.sendMessage("Shoot 5");
			handlerOut.sendMessage("Shoot 5");
			handlerOut.sendMessage("Shoot 5");
			handlerOut.sendMessage("Shoot 5");
		}
		// handlerOut.sendMessage("Sweep " + 2 + " 10 10 10");
	}
}
