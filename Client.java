/* * * * * * * * * * * * *
 *     Daniel Franks     *
 *        Java II        *
 *      MiniProject      *
 *      Mar 04 2015      *
 * * * * * * * * * * * * */

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
	GUI gui = new GUI();

	private String host = "localhost";
	private int port = 9004;
	private Socket clientSock;
	private BufferedReader inFromServer;
	private PrintWriter outToServer;
	private String msg;
	
	public Client() {
		gui.setTitle("CrappyChat! - Client");

		gui.submitB.addActionListener(this);
		
		try {
			clientSock = new Socket(host, port);

			System.out.println("Connected to " + host + " on port " + port + ".");

			inFromServer = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));

			String in = inFromServer.readLine();

			gui.chatDisplay.append(in + "\n");

		}catch(Exception e) {
			System.out.println("FAIL - " + e);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			msg = gui.message(gui.chatInput.getText());

			outToServer = new PrintWriter(clientSock.getOutputStream(), true);
			
			outToServer.println(msg);

		}catch(IOException ioe) {
			System.out.println("IO Exception - " + ioe);
		}catch(Exception e) {
			System.out.println("Oops! - " + e);
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
	}
}