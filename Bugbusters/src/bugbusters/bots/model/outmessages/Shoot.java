package bugbusters.bots.model.outmessages;

import bugbusters.bots.model.OutMessage;

public class Shoot implements OutMessage {

	private double energy;

	public Shoot(double energy) {
		this.energy = energy;
	}

	@Override
	public String getMessageString() {
		return "Shoot " + energy;
	}

}
