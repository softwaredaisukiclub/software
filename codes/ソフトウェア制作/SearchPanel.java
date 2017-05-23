package ソフトウェア制作;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import serverside.*;

public class SearchPanel extends JPanel {
	private JTextField textField;
	private JButton SearchButton;
	private JButton BackButton;
	private static String myaddress = AddressList.getList(49);
	private static String[] servers = {AddressList.getList(49)};
	private static Client client = new Client(myaddress,servers);
	private String filename;
		/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(null);
		client =  new Client(myaddress, servers);
		textField = new JTextField();
		textField.setBounds(72, 126, 313, 22);
		add(textField);
		textField.setColumns(10);
		SearchButton = new JButton("検索");
		SearchButton.setBounds(97, 194, 101, 25);
		add(SearchButton);
		SearchButton.addActionListener(new SearchButtonListener());

		BackButton = new JButton("戻る");
		BackButton.setBounds(254, 194, 101, 25);
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
