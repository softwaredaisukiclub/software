import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ResultPanel extends JPanel {
	private JTextField textField;
	private JButton DownButton;
	private JButton BackButton;

	/**
	 * Create the panel.
	 */
	public ResultPanel(boolean result) {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(56, 99, 334, 22);
		add(textField);
		textField.setColumns(10);

		JPanel p = new JPanel();

		JLabel label1 = new JLabel("見つかりました！");
		JLabel label2 = new JLabel("見つかりませんでした（笑）");

		if(result == true) { p.add(label1); }
		else { p.add(label2); }

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
}
