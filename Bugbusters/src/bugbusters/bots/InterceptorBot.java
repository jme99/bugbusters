package bugbusters.bots;

public class InterceptorBot extends AbstractBot {

	@Override
	public void run() {
		do {
           getPosition()
		} while (!getModel().isDead());

	}
}