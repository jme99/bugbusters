package bugbusters.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterBotComm {

	/** Interface to implement by those that wants to listen to other bots. */
	public interface OtherBotsDataListener {
		public void digestData(int port, String s);
	}

	private final static int START_PORT = 13333;
	private final ServerSocket serverSocket;

	private int port;
	private final Map<Integer, PrintWriter> otherBots = new HashMap<>();
	private final Collection<OtherBotsDataListener> listeners = new ArrayList<>();

	/**
	 * Does the main work of setting up the connection with the other bots. It
	 * first start to claim the port <code>START_PORT</code>. If succesful, it
	 * waits on connections to other bots. Else, it knows that the port is
	 * claimed by another bot and connects to this. It then tries to claim the
	 * next port.
	 * 
	 * @throws IOException
	 */
	public InterBotComm() throws IOException {
		ServerSocket tryServerSocket = null;
		for (int i = 0; i < 100; i++) {
			try {
				port = START_PORT + i;
				tryServerSocket = new ServerSocket(port);
				break;
			} catch (BindException e) {
			} // do nothing
		}
		serverSocket = tryServerSocket;

		for (int i = START_PORT; i < port; i++) {
			Socket socket = new Socket("localhost", i);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			otherBots.put(i, pw);
			pw.println("CONNECT TO:" + port);
			pw.flush();
		}

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						final Socket socket = serverSocket.accept();
						Thread thread = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Scanner scanner = new Scanner(socket.getInputStream());
									String firstLine = scanner.nextLine();
									Pattern pattern = Pattern.compile("CONNECT TO:(\\d+)");
									Matcher matcher = pattern.matcher(firstLine);
									Socket socketWriter = null;
									if (matcher.matches()) {
										int port = Integer.parseInt(matcher.group(1));
										socketWriter = new Socket("localhost", port);
										otherBots.put(port, new PrintWriter(socketWriter.getOutputStream()));
									} else {
										receiveData(socket.getPort(), firstLine);
									}
									while (scanner.hasNextLine()) {
										receiveData(socket.getPort(), scanner.nextLine());
									}
									if (socketWriter != null)
										socketWriter.close();
									scanner.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
						thread.setDaemon(true);
						thread.start();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
	}

	/** Digest the received data in the form of the string <code>s</code> */
	private void receiveData(int port, String s) {
		for (OtherBotsDataListener listener : listeners) {
			listener.digestData(port, s);
		}
	}

	/** Add a listener whose role it is to digest the received data */
	public void addOtherBotsDataListener(OtherBotsDataListener listener) {
		listeners.add(listener);
	}

	/**
	 * Sends the String representation of <code>obj</code> to the other
	 * connected bots
	 * 
	 * @param obj
	 */
	public synchronized void sendData(Object obj) {
		for (Entry<Integer, PrintWriter> entry : otherBots.entrySet()) {
			PrintWriter pw = entry.getValue();
			pw.println(obj.toString());
			pw.flush();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		InterBotComm comm = new InterBotComm();
		comm.addOtherBotsDataListener(new OtherBotsDataListener() {
			@Override
			public void digestData(int port, String s) {
				System.out.println("from port " + port + ": " + s);
			}
		});
		while (true) {
			Thread.sleep(1000);
			comm.sendData("XX:" + comm.hashCode());
		}
	}
}
