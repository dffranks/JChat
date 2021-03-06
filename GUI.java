/* * * * * * * * * * * * *
 *     Daniel Franks     *
 *        Java II        *
 *      MiniProject      *
 *      Mar 04 2015      *
 * * * * * * * * * * * * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {

	JPanel top = new JPanel();
	JPanel mid = new JPanel();
	JPanel bot = new JPanel();
	public JTextField chatInput = new JTextField(8);
	public JButton submitB = new JButton("Send");
	public JTextArea chatDisplay;
	public String message;
	
	public GUI() {
		/****TopPanel****/
		JLabel title = new JLabel("CrappyChat!");
		title.setFont(new Font("serif", Font.BOLD, 23));
		title.setForeground(Color.BLUE);
		top.setLayout(new FlowLayout());
		top.add(title);

		/****MidPanel****/
		mid.setLayout(new FlowLayout());
		chatDisplay = new JTextArea(10, 40);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setEditable(false);
		JScrollPane scroller = new JScrollPane(chatDisplay);
		mid.add(scroller);

		/****BotPanel****/
		bot.setLayout(new GridLayout(0, 2));
		bot.add(chatInput);
		bot.add(submitB);

		this.setLayout(new BorderLayout());

		this.add(top, BorderLayout.NORTH);
		this.add(mid, BorderLayout.CENTER);
		this.add(bot, BorderLayout.SOUTH);

		this.setSize(460, 260);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public String message(String msg) {
	 	chatDisplay.append(msg + "\n");
		return msg;
	}

	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}