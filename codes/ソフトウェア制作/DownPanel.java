package ソフトウェア制作;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import serverside.*;
public class DownPanel extends JPanel {
	private JTextField textField;
	private JButton DownButton;
	private JButton BackButton;
	private static String myaddress = AddressList.getList(49);
	private static String[] servers = {AddressList.getList(49)};
	private static Client client = new Client(myaddress,servers);
	private String downFilename;
	/**
	 * Create the panel.
	 */
	public DownPanel() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(56, 99, 334, 22);
		add(textField);
		textField.setColumns(10);
		downFilename = textField.getText();
		textField.addActionListener(new DownButtonListener());

		DownButton = new JButton("ダウンロード");
		DownButton.setBounds(87, 195, 101, 25);
		add(DownButton);
		DownButton.addActionListener(new DownButtonListener());

		BackButton = new JButton("戻る");
		BackButton.setBounds(257, 195, 101, 25);
		add(BackButton);
		BackButton.addActionListener(new BackButtonListener());
	}
	public class BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showInitPanel();
			mframe.setVisible(true);
		}
	}
	public class DownButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showDownResultPanel(client.get(downFilename));
			mframe.setVisible(true);
		}
	}
}
