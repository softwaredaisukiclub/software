package ソフトウェア制作;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import serverside.*;
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
      label = new JLabel("見つかりませんでした（笑）");
    }
    label.setBounds(185, 133, 38, 24);
    add(label);

    BackButton = new JButton("戻る");
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
