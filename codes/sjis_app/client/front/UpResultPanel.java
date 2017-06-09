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
      label = new JLabel("ê¨å˜ÇµÇ‹ÇµÇΩÅI");
    }else{
      label = new JLabel("ê¨å˜ÇµÇ‹ÇπÇÒÇ≈ÇµÇΩÅièŒÅj");
    }
    label.setBounds(185, 133, 200, 24);
    add(label);

    BackButton = new JButton("ñﬂÇÈ");
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
