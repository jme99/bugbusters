package bugbusters.bots;

import java.io.IOException;

import bugbusters.bots.model.Message;
import bugbusters.bots.model.outmessages.RotateMessage;
import bugbusters.bots.model.outmessages.Shoot;

public class FPBot extends AbstractBot {

	public FPBot() {
		super();
	}

	public static void main(String[] args) {
		new FPBot().run();
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
						if (shootTimes > 0) {
							handlerOut.sendMessage(new Shoot(energy));
							shootTimes--;
						}
						energy = 0.0;
						break;
					case ROBOTINFO:
						if (message.isYesNo()) {
							energy = 0;
						} else {
							energy = 5.0;
							shootTimes = 3;
							foundOne = true;
							speed = 0.01 * Math.signum(speed);
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
						if (Math.abs(speed) < 1) {
							speed += 0.1 * Math.signum(speed);
						}
						// speed = 0.5 * Math.signum(speed);
						break;
					default:
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (true); // TODO Spiel läuft

	}
}
