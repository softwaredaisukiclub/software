package client.front;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import client.serverside.*;
import module.*;
public class SetupPanel extends JPanel {
  private JTextField textField;
  private JLabel label;
  private JButton DecisionButton;
  private int hostname;


  /**
   * Create the panel.
   */
  public SetupPanel() {
    setLayout(null);

    textField = new JTextField();
    textField.setBounds(80, 93, 304, 22);
    add(textField);
    textField.setColumns(10);

    label = new JLabel("自分のPCのDのとなりにある3桁の番号を入力してください");
    label.setBounds(80, 143, 345, 44);
    add(label);

    DecisionButton = new JButton("決定");
    DecisionButton.setBounds(166, 244, 101, 25);
    add(DecisionButton);
    DecisionButton.addActionListener(new DecisionButtonListener());
  }
  public class DecisionButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      hostname = Integer.parseInt(textField.getText());
      AddressList.setHost(hostname);
      AddressList.setupServerList();
      MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
      mframe.showInitPanel();
      mframe.setVisible(true);
    }
  }
}
