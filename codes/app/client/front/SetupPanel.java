package client.front;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

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
    textField.setBounds(350,250,304,22); //80, 93, 304, 22
    add(textField);
    textField.setColumns(10);
    textField.addActionListener(new DecisionButtonListener());

    label = new JLabel("Please input 3 digits of number which is next to written D to your PC");//自分のPCのDのとなりにある3桁の番号を入力してください
    label.setBounds(215,300,800,44); //80, 143, 345, 44
    label.setFont(new Font("Century", Font.BOLD, 16));
    add(label);

    DecisionButton = new JButton("OK"); //決定
    DecisionButton.setBounds(450, 375, 101, 25);
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
