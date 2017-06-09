package client.front;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class InitPanel extends JPanel {
	private JButton ExitButton;
	private JButton UpButton;
	private JButton DownButton;
	private JButton SearchButton;
	private JButton DeleteButton;

	/**
	 * Create the panel.
	 */
	public InitPanel() {
		setLayout(null);

		ExitButton = new JButton("�I��");
		ExitButton.setBounds(262, 180, 101, 25);
		add(ExitButton);
		ExitButton.addActionListener(new ExitButtonListener());

		UpButton = new JButton("�A�b�v���[�h");
		UpButton.setBounds(262, 77, 101, 25);
		add(UpButton);
		UpButton.addActionListener(new UpButtonListener());

		DownButton = new JButton("�_�E�����[�h");
		DownButton.setBounds(92, 77, 101, 25);
		add(DownButton);
		DownButton.addActionListener(new DownButtonListener());

		SearchButton = new JButton("����");
		SearchButton.setBounds(92, 180, 101, 25);
		add(SearchButton);
		SearchButton.addActionListener(new SearchButtonListener());

		DeleteButton = new JButton("�폜");
		DeleteButton.setBounds(177, 128, 101, 25);
		add(DeleteButton);
		DeleteButton.addActionListener(new DeleteButtonListener());
	}

	public class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}

	public class UpButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showUpPanel();
			mframe.setVisible(true);
		}
	}

	public class DownButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showDownPanel();
			mframe.setVisible(true);
		}
	}

	public class SearchButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showSearchPanel();
			mframe.setVisible(true);
		}
	}

		public class DeleteButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			mframe.showDeletePanel();
			mframe.setVisible(true);
		}
	}
}
