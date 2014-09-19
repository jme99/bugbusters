package bugbusters.bots;

import java.io.IOException;
import java.util.StringTokenizer;

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
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (true); // TODO Spiel läuft

	}
}
