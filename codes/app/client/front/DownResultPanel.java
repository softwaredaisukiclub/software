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
      label = new JLabel("Success!");
      label.setFont(new Font("Century", Font.BOLD, 16));      
      label.setBounds(470, 300, 400, 24);
    }else{
      label = new JLabel("It wasn't found:(");
      label.setFont(new Font("Century", Font.BOLD, 16));      
      label.setBounds(435, 300, 400, 24);
    }
    add(label);

    BackButton = new JButton("Back");
    BackButton.setBounds(450, 450, 101, 25);
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
