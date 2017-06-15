package client.front;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import client.serverside.*;

public class SearchPanel extends JPanel {
	private JTextField textField;
	private JButton SearchButton;
	private JButton BackButton;
	private static Client client = new Client();
	private String filename;
		/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(null);
		textField = new JTextField();
		textField.setBounds(350, 300, 300, 22);
		add(textField);
		textField.setColumns(10);
		textField.addActionListener(new SearchButtonListener());
		
		SearchButton = new JButton("Search");
		SearchButton.setBounds(375, 400, 101, 25);
		add(SearchButton);
		SearchButton.addActionListener(new SearchButtonListener());

		BackButton = new JButton("Back");
		BackButton.setBounds(525, 400, 101, 25);
		add(BackButton);
		BackButton.addActionListener(new BackButtonListener());
	}

	public class SearchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			filename = textField.getText();
			mframe.showSearchResultPanel(client.find(filename));
			mframe.setVisible(true);
		}
	}

	public class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showInitPanel();
			mframe.setVisible(true);
		}
	}
}
