package client.front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import client.serverside.*;
public class UpResultPanel extends JPanel {

  private JLabel label;
  private JButton BackButton;
  /**
   * Create the panel.
   */
  public UpResultPanel(boolean result) {
    setLayout(null);
    if(result){
      label = new JLabel("Success!");
    }else{
      label = new JLabel("Failure");
    }
    label.setBounds(185, 133, 200, 24);
    add(label);

    BackButton = new JButton("Back");
    BackButton.setBounds(151, 234, 101, 25);
    add(BackButton);
    BackButton.addActionListener(new BackButtonListener());
  }
  public class BackButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
      mframe.showInitPanel();
      mframe.setVisible(true);
    }
  }
}
