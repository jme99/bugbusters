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

	BufferedReader bf;
	MessageHandlerIn in;
	MessageHandlerOut out;
	
	
	public AbstractBot() {
		bf = new BufferedReader(new InputStreamReader(System.in));
		in = new MessageHandlerIn();
		out = new MessageHandlerOut();
	}
	
}
