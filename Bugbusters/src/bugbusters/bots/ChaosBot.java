package bugbusters.bots;

import java.io.IOException;

import bugbusters.bots.model.Message;

public class ChaosBot extends AbstractBot {

	private Double angle;
	private Double distance;

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
							handlerOut.sendMessage("Name ChaosBot"
									+ " Team: BUG-BUSTERS");
							handlerOut.sendMessage("Colour FF0000 00FF00");
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
		handlerOut.sendMessage("Rotate 1 0");
		handlerOut.sendMessage("Accelerate " + model.getMaxAcceleartion());
	}

	private void consumeRadar(Message message) {
		Double distance = message.getDistance();
		angle = message.getAngle();
		distance = message.getDistance();
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
			handlerOut.sendMessage("RotateAmount " + 1 + " " + 1000 / distance
					+ " " + angle);
			new Thread() {
				public void run() {
					for (int i = 0; i < 5; i++) {
						handlerOut.sendMessage("Shoot 5");
						try {
							sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
			}.start();
		}
		// handlerOut.sendMessage("Sweep " + 2 + " 10 10 10");
	}
}
