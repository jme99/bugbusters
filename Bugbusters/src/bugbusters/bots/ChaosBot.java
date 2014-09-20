package bugbusters.bots;

import java.io.IOException;

import bugbusters.bots.model.Message;
import bugbusters.bots.model.MessageType;
import bugbusters.bots.model.ObjectType;

public class ChaosBot extends AbstractBot {

	private int speed = 0;

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

					if (speed == 0) {
						speed = 10;
						handlerOut.sendMessage("Accelerate 10");
					}

					if (message != null) {
						if (message.getType() == MessageType.RADAR) {
							Double distance = message.getDistance();
							Double angle = message.getAngle();
							if (message.getObjectType() == ObjectType.WALL) {
								if (distance < 1) {
									handlerOut.sendMessage("Rotate 7 1 90");
								}
							} else if (message.getObjectType() == ObjectType.MINE) {

								handlerOut.sendMessage("RotateTo 7 1" + angle);
								handlerOut.sendMessage("Shoot 1");
							} else if (message.getObjectType() == ObjectType.ROBOT) {
								handlerOut.sendMessage("Shoot 1");
								handlerOut.sendMessage("Shoot 1");
								handlerOut.sendMessage("Shoot 1");
								handlerOut.sendMessage("Shoot 1");
							} else if (message.getObjectType() == ObjectType.COOKIE) {

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
}
