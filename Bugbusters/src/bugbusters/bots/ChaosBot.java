package bugbusters.bots;

import java.io.IOException;

import bugbusters.bots.model.Message;
import bugbusters.bots.model.MessageType;
import bugbusters.bots.model.ObjectType;

public class ChaosBot extends AbstractBot {

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

					handlerOut.sendMessage("Shoot 1");

					if (message != null) {
						if (message.getType() == MessageType.GAMEOPTION) {
							continue;
						} else if (message.getType() == MessageType.GAMESTARTS) {
							handlerOut.sendMessage("Accelerate "
									+ model.getMaxAcceleartion());
						} else if (message.getType() == MessageType.RADAR) {
							Double distance = message.getDistance();
							Double angle = message.getAngle();
							if (message.getObjectType() == ObjectType.WALL) {
								if (distance < 2.0) {
									handlerOut.sendMessage("Brake 1");
									handlerOut.sendMessage("RotateAmount " + 7
											+ " " + 1 + " " + 1.57);
								} else {
									handlerOut.sendMessage("Brake 0");
									handlerOut.sendMessage("Accelerate 1");
								}
							} else if (message.getObjectType() == ObjectType.MINE) {

								handlerOut.sendMessage("Shoot 1");
							} else if (message.getObjectType() == ObjectType.ROBOT) {
								handlerOut.sendMessage("Shoot 5");
							} else if (message.getObjectType() == ObjectType.COOKIE) {
								moveToCookie(message);
							}
						}

					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		} while (true); // TODO Spiel läuft

	}

	private void moveToCookie(Message m) {
		handlerOut.sendMessage("RotateTo " + 7 + " " + 1 + " " + m.getAngle());
		handlerOut.sendMessage("Accelerate " + model.getMaxAcceleartion());
		handlerOut.sendMessage("Shoot 1");
	}
}
