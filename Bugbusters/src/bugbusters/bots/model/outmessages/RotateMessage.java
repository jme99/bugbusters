package bugbusters.bots.model.outmessages;

import bugbusters.bots.model.OutMessage;

public class RotateMessage implements OutMessage {

	public final static int ROBOT = 1;
	public final static int CANON = 2;
	public final static int RADAR = 4;
	private int object;
	private double angularVelocity;

	public RotateMessage(int object, double angularVelocity) {
		this.object = object;
		this.angularVelocity = angularVelocity;
	}

	@Override
	public String getMessageString() {
		return "Rotate " + object + " " + angularVelocity;
	}
}
