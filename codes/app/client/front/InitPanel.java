package client.front;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

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

		ExitButton = new JButton("Finish");
		ExitButton.setFont(new Font("century", Font.BOLD, 16));
		//ExitButton.setBounds(262, 180, 101, 25);
		ExitButton.setBounds(0, 400, 300, 100);
		add(ExitButton);
		ExitButton.addActionListener(new ExitButtonListener());

		UpButton = new JButton("Upload");
		UpButton.setFont(new Font("century", Font.BOLD, 16));
		UpButton.setBounds(0, 0, 300, 100);
		add(UpButton);
		UpButton.addActionListener(new UpButtonListener());

		DownButton = new JButton("Download");
		DownButton.setFont(new Font("century", Font.BOLD, 16));
		DownButton.setBounds(0, 100, 300, 100);
		add(DownButton);
		DownButton.addActionListener(new DownButtonListener());

		SearchButton = new JButton("Search");
		SearchButton.setFont(new Font("century", Font.BOLD, 16));
		SearchButton.setBounds(0, 200, 300, 100);
		add(SearchButton);
		SearchButton.addActionListener(new SearchButtonListener());

		DeleteButton = new JButton("Delete");
		DeleteButton.setFont(new Font("century", Font.BOLD, 16));
		DeleteButton.setBounds(0, 300, 300, 100);
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
