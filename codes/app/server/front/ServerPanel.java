package server.front;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import server.serverside.*;

public class ServerPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label;
	private JLabel lblD;
	private JButton DecisionButton;
	private String hostname;
	private String myname;



	/**
	 * Create the panel.
	 */
	public ServerPanel() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(80, 93, 304, 22);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(80, 195, 304, 22);
		add(textField_1);
		textField_1.setColumns(10);

		label = new JLabel("スライドにある番号を入力してください");
		label.setBounds(80, 45, 187, 35);
		add(label);

		lblD = new JLabel("自分のPCのDのとなりにある3桁の番号を入力してください");
		lblD.setBounds(80, 143, 345, 44);
		add(lblD);

		DecisionButton = new JButton("決定");
		DecisionButton.setBounds(166, 244, 101, 25);
		add(DecisionButton);
		DecisionButton.addActionListener(new DecisionButtonListener());
	}
	public class DecisionButtonListener implements ActionListener, Runnable {
		public void run() {
		Server server = new Server(myname,hostname);
		server.serverStart();
	 }

		public void actionPerformed(ActionEvent e){
			hostname = AddressList.getList(Integer.parseInt(textField.getText()));
			myname = AddressList.getList(Integer.parseInt(textField_1.getText()));
			Thread thread = new Thread(this);
			thread.start();
			ServerFrame mframe = (ServerFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showServerResultPanel();
			mframe.setVisible(true);
		}
	}
}
