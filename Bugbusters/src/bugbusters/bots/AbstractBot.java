package bugbusters.bots;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Botklasse von der alle weiteren Bots erben sollen. 
 * 
 * @author Jannick
 *
 */
public class AbstractBot extends Thread {

	BufferedReader bf;
	
	public AbstractBot() {
		bf = new BufferedReader(new InputStreamReader(System.in));
	}
	
}
