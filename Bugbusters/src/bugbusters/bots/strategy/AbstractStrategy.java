/**
 * 
 */
package bugbusters.bots.strategy;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import bugbusters.bots.model.BotModel;
import bugbusters.bots.model.Message;
import bugbusters.bots.model.OutMessage;
import bugbusters.bots.model.World;

/**
 * @author User1
 *
 */
public abstract class AbstractStrategy extends Thread {
	private World world;
	private BotModel model;
	private Queue<Message> inMessages = new ConcurrentLinkedQueue<Message>();

	public AbstractStrategy(World world, BotModel model) {
		super();
		this.world = world;
		this.model = model;
	}

	public abstract List<OutMessage> decide();

	@Override
	public void run() {
		do {
			List<OutMessage> messages = decide();
			world.send(messages);
		} while (true);
	}

	public BotModel getModel() {
		return model;
	}

	public synchronized void setModel(BotModel model) {
		this.model = model;
		interrupt();
	}

	public void consume(Message inMsg) {
		inMessages.add(inMsg);
		interrupt();
	}
}
