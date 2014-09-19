package bugbusters.bots;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bugbusters.io.MessageHandlerIn;
import bugbusters.io.MessageHandlerOut;

/**
 * Botklasse von der alle weiteren Bots erben sollen. 
 * 
 * @author Jannick
 *
 */
public class AbstractBot extends Thread {

	protected BufferedReader bf;
	protected MessageHandlerIn handlerIn;
	protected MessageHandlerOut handlerOut;
	
	public AbstractBot() {
		bf = new BufferedReader(new InputStreamReader(System.in));
		handlerIn = new MessageHandlerIn();
		handlerOut = new MessageHandlerOut();
	}
	
}
