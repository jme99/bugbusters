package bugbusters.bots;

import java.io.IOException;
import java.util.StringTokenizer;

import bugbusters.io.MessageHandlerIn;

public class SimpleBot extends AbstractBot {

	public SimpleBot() {
		super();
	}

	public static void main(String[] args) {
		new SimpleBot().run();
	}

	@Override
	public void run() {
		do {
			try {
				if (bf.ready()) {
					String line = bf.readLine();
					StringTokenizer st = new StringTokenizer(line);
					handlerOut.echo("Empfangen: " + line);
					// TODO mach etwas mit der Nachricht
					String token = null;
					if (st.hasMoreTokens()) {
						token = st.nextToken();
					}
					int type = handlerIn.identifyMessageType(token);
					switch (type) {
					case MessageHandlerIn.INFO:

						break;

					case MessageHandlerIn.INITIALIZE:
						if ("1".equals(st.nextToken())) {
							handlerOut.sendMessage("Name " + model.getName()
									+ " Team: BUG-BUSTERS");
							handlerOut.sendMessage("Colour FF0000 00FF00");
						}
						break;

					case MessageHandlerIn.YOUR_COLOUR:
						model.setColor(st.nextToken());
						break;
					case MessageHandlerIn.GAME_STARTS:
						// um zu sehen ob wir laufen
						handlerOut.sendMessage("Shoot 1");
						model.setGameStarted(true);
						break;

					case MessageHandlerIn.EXIT_ROBOT:
						System.exit(0);
						break;

					case MessageHandlerIn.DEAD:
						model.setDead(true);

					case MessageHandlerIn.GAME_FINISHES:
						model.setGameStarted(false);
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
