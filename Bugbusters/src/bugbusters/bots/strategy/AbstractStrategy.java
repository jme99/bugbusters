/**
 * 
 */
package bugbusters.bots.strategy;

import java.util.List;

import bugbusters.bots.AbstractBot;
import bugbusters.bots.model.OutMessage;

/**
 * @author User1
 *
 */
public abstract class AbstractStrategy extends Thread {
	protected AbstractBot bot;

	public AbstractStrategy(AbstractBot bot) {
		super();
		this.bot = bot;
	}

	public abstract List<OutMessage> decide();

	@Override
	public void run() {
		do {
			List<OutMessage> messages = decide();
			// world.send(messages);
		} while (true);
	}

}
