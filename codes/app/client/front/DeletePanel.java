package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import serverside.*;
public class DeletePanel extends JPanel {
	private JTextField textField;
	private JButton DeleteButton;
	private JButton BackButton;
	private static Client client = new Client();
	private String filename;
	/**
	 * Create the panel.
	 */
	public DeletePanel() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(56, 99, 334, 22);
		add(textField);
		textField.setColumns(10);
		textField.addActionListener(new DeleteButtonListener());

		DeleteButton = new JButton("削除");
		DeleteButton.setBounds(87, 195, 101, 25);
		add(DeleteButton);
		DeleteButton.addActionListener(new DeleteButtonListener());

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
	public class DeleteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			filename = textField.getText();
			mframe.showDeleteResultPanel(client.delete(filename));
			mframe.setVisible(true);
		}
	}
}
