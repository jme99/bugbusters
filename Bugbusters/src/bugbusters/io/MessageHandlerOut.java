package bugbusters.io;

/**
 * Soll ein Kommando, dass der Roboter ausf�hren soll an den Server senden. Evtl
 * weitere Methoden?!?!?
 * 
 * @author Jannick
 *
 */
public class MessageHandlerOut {

	public void sendMessage(String message) {
		System.out.println(message);
		System.out.flush();
	}

	public final void echo(String s) {
		sendMessage("Print " + s);
	}
}
