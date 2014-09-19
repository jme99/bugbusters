package bugbusters.io;

import bugbusters.bots.model.OutMessage;

/**
 * Soll ein Kommando, dass der Roboter ausführen soll an den Server senden. Evtl
 * weitere Methoden?!?!?
 * 
 * @author Jannick
 *
 */
public class MessageHandlerOut {

	public void sendMessage(String message) {
		echo(message);
		System.out.println(message);
		System.out.flush();
	}

	public void sendMessage(OutMessage message) {
		sendMessage(message.getMessageString());
	}

	public final void echo(String s) {
		System.out.println("Print " + s);
		System.out.flush();
	}
}
