import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SearchPanel extends JPanel {
	private JTextField textField;
	private JButton SearchButton;
	private JButton BackButton;
	private String myaddress = AddressList.getList(48);
	private String[] servers = {AddressList.getList(48),AddressList.getList(48)};
	private Client client;
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
		filename = textField.getText();

		SearchButton = new JButton("検索");
		SearchButton.setBounds(97, 194, 101, 25);
		add(SearchButton);
		//SearchButton.addActionListener(new SearchButtonListener());

		BackButton = new JButton("戻る");
		BackButton.setBounds(254, 194, 101, 25);
		add(BackButton);
		BackButton.addActionListener(new BackButtonListener());
	}

	public class SearchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showResultPanel(client.find(filename));
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
