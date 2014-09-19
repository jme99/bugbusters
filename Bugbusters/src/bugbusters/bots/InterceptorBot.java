package bugbusters.bots;

import java.awt.Point;

import bugbusters.bots.model.GameObject;

public class InterceptorBot extends AbstractBot {

	private static final double MAX_AGE = 10;

	@Override
	public void run() {
		do {
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
		} while (!getModel().isDead());

	}

	private double calculateRotationAngle(Point myPos, Point position) {
		// TODO Auto-generated method stub
		return 0;
	}
}