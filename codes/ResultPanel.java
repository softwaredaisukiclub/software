import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ResultPanel extends JPanel {
	private JPanel p = new JPanel();
	private JButton DownButton;
	private JButton BackButton;
  private JLabel label1 = new JLabel("見つかりました！");
	private JLabel label2 = new JLabel("見つかりませんでした（笑）");
	/**
	 * Create the panel.
	 */
	public ResultPanel(boolean result) {
		setLayout(null);
    p.setBounds(56, 99, 334, 22);

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
