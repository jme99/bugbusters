package bugbusters.bots;

import java.io.IOException;
import java.util.StringTokenizer;

import bugbusters.bots.AbstractBot;
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
