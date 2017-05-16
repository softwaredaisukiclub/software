import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UpPanel extends JPanel {
	private JTextField textField;
	private JButton BrowseButton;
	private JButton UpButton;
	private JButton BackButton;

	/**
	 * Create the panel.
	 */
	public UpPanel() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(37, 127, 310, 22);
		add(textField);
		textField.setColumns(10);

		BrowseButton = new JButton("参照");
		BrowseButton.setBounds(359, 126, 101, 25);
		add(BrowseButton);

		UpButton = new JButton("アップロード");
		UpButton.setBounds(83, 208, 101, 25);
		add(UpButton);

		BackButton = new JButton("戻る");
		BackButton.setBounds(274, 208, 101, 25);
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
}
