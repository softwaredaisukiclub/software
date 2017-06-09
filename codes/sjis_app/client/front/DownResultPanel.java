package client.front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import client.serverside.*;
public class DownResultPanel extends JPanel {

  private JLabel label;
  private JButton BackButton;
  /**
   * Create the panel.
   */
  public DownResultPanel(File file) {
    setLayout(null);
    if(file != null){
      label = new JLabel(file.getAbsolutePath());
    }else{
      label = new JLabel("å©Ç¬Ç©ÇËÇ‹ÇπÇÒÇ≈ÇµÇΩÅièŒÅj");
    }
    label.setBounds(20, 133, 400, 10);
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
