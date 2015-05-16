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

public class Server implements ActionListener {
	GUI gui = new GUI();

	private int port = 9004;
	private ServerSocket serverSock;
	private Socket clientSock;
	private PrintWriter outToClient;
	private BufferedReader inFromClient;
	private String msg;
	
	public Server() {
		gui.setTitle("CrappyChat! - Server");

		gui.submitB.addActionListener(this);
		
		try {
			serverSock = new ServerSocket(port);

			System.out.println("Server Ready on port " + port + ".");

			clientSock = serverSock.accept();

			inFromClient = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));

			String in = inFromClient.readLine();

			gui.chatDisplay.append("Client: " + in + "\n");

		}catch(UnknownHostException uhe) {
			System.out.println("Unknown Host - " + uhe);
		}catch(IOException ioe) {
			System.out.println("IO Exception - " + ioe);
		}catch(Exception e) {
			System.out.println("Oops! - " + e);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			msg = gui.message(gui.chatInput.getText());

			outToClient = new PrintWriter(clientSock.getOutputStream(), true);
			
			outToClient.println("Server: " + msg);

		}catch(IOException ioe) {
			System.out.println("IO Exception - " + ioe);
		}catch(Exception e) {
			System.out.println("Oops! - " + e);
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
	}
}