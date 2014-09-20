package bugbusters.bots;

import java.io.IOException;

import bugbusters.bots.model.Message;
import bugbusters.bots.model.MessageType;
import bugbusters.bots.model.ObjectType;
import bugbusters.bots.model.outmessages.RotateMessage;
import bugbusters.bots.model.outmessages.Shoot;

public class FPBot extends AbstractBot {

	public FPBot() {
		super();
	}

	public static void main(String[] args) {
		new ChaosBot().run();
	}

	@Override
	public void run() {
		boolean firstTime = true;
		double energy = 1;
		double speed = 1;
		boolean foundOne = false;
		boolean foundOneOld = false;
		int shootTimes = 0;
		do {
			try {
				if (bf.ready()) {
					String line = bf.readLine();// TODO
					handlerOut.echo("Empfangen: " + line);
					Message message = parseMessage(line);
					switch (message.getType()) {
					case ENERGY:
						energy = 0.0;
						break;
					case ROBOTINFO:
						if (message.isYesNo()) {
							energy = 0;
						} else {
							energy = 5.0;
							shootTimes = 30;
							foundOne = true;
							speed = 0.05 * Math.signum(speed);
						}
						break;
					case COORDINATES:
						handlerOut.echo("foundone : " + foundOne
								+ "  foundoneOld : " + foundOneOld);

						if (!foundOne && foundOneOld) {
							speed *= -1;
							handlerOut.echo("RICHTUGNS WECHSEL");
						}
						handlerOut.sendMessage(new RotateMessage(
								RotateMessage.CANON + RotateMessage.RADAR,
								speed));
						break;
					case RADAR:
						foundOneOld = foundOne;
						foundOne = false;
						handlerOut.echo("RADAR: foundone : " + foundOne
								+ "  foundoneOld : " + foundOneOld);
						if (Math.abs(speed) < 2) {
							speed += 0.025 * Math.signum(speed);
						}
						// speed = 0.5 * Math.signum(speed);
						break;
					default:
						break;
					}
					if (shootTimes > 0) {
						handlerOut.sendMessage(new Shoot(energy));
						shootTimes--;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (true); // TODO Spiel läuft

	}

	public void run2() {
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
							handlerOut.sendMessage("RotateAmount 2 7 3.14");
						} else if (message.getType() == MessageType.RADAR) {
							Double distance = message.getDistance();
							Double angle = message.getAngle();
							if (message.getObjectType() == ObjectType.WALL) {
								ausweichen(distance);
							} else if (message.getObjectType() == ObjectType.MINE) {
								ausweichen(distance);
								handlerOut.sendMessage("Shoot 1");
							} else if (message.getObjectType() == ObjectType.ROBOT) {
								umdrehen(distance);
							} else if (message.getObjectType() == ObjectType.COOKIE) {
								// vorwärts
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

	private void ausweichen(Double distance) {
		if (distance < 10.0) {
			handlerOut.sendMessage("Brake 1");
			handlerOut.sendMessage("RotateAmount " + 7 + " " + 3.14 / 3);
		} else {
			handlerOut.sendMessage("Brake 0");
			handlerOut.sendMessage("Accelerate 1");
		}
	}

	private void umdrehen(Double distance) {
		if (distance < 10.0) {
			handlerOut.sendMessage("Brake 1");
			handlerOut
					.sendMessage("RotateAmount " + (7) + " " + 5 + " " + 3.14);
		} else {
			handlerOut.sendMessage("Brake 0");
			handlerOut.sendMessage("Accelerate 1");
		}
	}
}
