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

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(null);
		String myaddress = AddressList.getList(48);
		String servers[] = {AddressList.getList(48),AddressList.getList(48)} ;
		Client client =  new Client(address, servers);
		textField = new JTextField();
		textField.setBounds(72, 126, 313, 22);
		add(textField);
		textField.setColumns(10);
		//String str = textField.getText();

		SearchButton = new JButton("検索");
		SearchButton.setBounds(97, 194, 101, 25);
		add(SearchButton);
		//SearchButton.addActionListener(new SearchButtonListener());

		BackButton = new JButton("戻る");
		BackButton.setBounds(254, 194, 101, 25);
		add(BackButton);
		BackButton.addActionListener(new BackButtonListener());
	}

	/*public class SearchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showResultPanel();
			mframe.setVisible(true);
		}
	}*/

	public class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showInitPanel(Client.find(str));
			mframe.setVisible(true);
		}
	}
}
