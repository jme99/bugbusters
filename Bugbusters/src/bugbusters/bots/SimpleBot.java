package bugbusters.bots;

import java.io.IOException;
import java.util.StringTokenizer;

import bugbusters.io.MessageHandlerIn;

public class SimpleBot extends AbstractBot {

	public SimpleBot() {
		super();
	}

	@Override
	public void run() {
		do {
			try {
				if (bf.ready()) {
					StringTokenizer st = new StringTokenizer(bf.readLine());
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
							handlerOut
									.sendMessage("Name S-Bot Team: BUG-BUSTERS");
							handlerOut.sendMessage("Colour FF0000 00FF00");
						}

						break;
					case MessageHandlerIn.GAME_STARTS:
						handlerOut.sendMessage("Shoot 1");
						break;

					case MessageHandlerIn.EXIT_ROBOT:
						System.exit(0);
						break;

					case MessageHandlerIn.DEAD:
						// TODO
						break;

					case MessageHandlerIn.GAME_FINISHES:
						// TODO
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
