package bugbusters.bots;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import bugbusters.bots.model.GameObject;
import bugbusters.bots.model.OutMessage;
import bugbusters.io.MessageHandlerOut;

public class InterceptorBot extends AbstractBot {

	private static final double MAX_AGE = 10;

	private MessageHandlerOut out = new MessageHandlerOut();

	@Override
	public void run() {
		do {
			List<OutMessage> messages = new ArrayList<OutMessage>();
			Point myPos = getModel().getPosition();
			double minDist = Double.MAX_VALUE;
			GameObject myEnemy = null;
			for (GameObject enemy : getWorld().getEnemies()) {
				if (getModel().getGameTime() - enemy.getTimeStamp() < MAX_AGE) {
					double distance = myPos.distance(enemy.getPosition());
					if (distance < minDist) {
						minDist = distance;
						myEnemy = enemy;
					}
				}
			}
			double angle = calculateRotationAngle(myPos, myEnemy.getPosition());
			out.sendMessage("RotateAmount 7 3.14 " + angle);
		} while (!getModel().isDead());

	}

	private double calculateRotationAngle(Point myPos, Point position) {
		// TODO Auto-generated method stub
		return 0;
	}
}