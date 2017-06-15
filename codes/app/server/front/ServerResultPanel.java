package server.front;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class ServerResultPanel extends JPanel {
  private JLabel label;
  private JButton ExitButton;
/*  private ImageIcon icon;
  private URL url;
*/
  /**
   * Create the panel.
   */
  public ServerResultPanel() {
    setLayout(null);
    label = new JLabel("Setting has been completed"); //設定が完了しました。現在稼働中です
    label.setBounds(425, 300, 300, 24);
    add(label);

    label = new JLabel("Now working...");
    label.setBounds(475, 350, 200, 24);
    add(label);

/*
    try {
	url = new URL("http://4.bp.blogspot.com/-OtfkvQ6YhEI/V5XczoV8lOI/AAAAAAAA8uM/ks16au6Xssw78rdg9F6VDRhv6naz2jqlgCLcB/s800/job_it_dokata.png");
    } catch(Exception e) {
	e.printStackTrace();
    }

    icon = new ImageIcon(url);
    label = new JLabel("0.1", icon, JLabel.LEFT);
    label.setBounds(0, 0, 600, 600);
    add(label);
*/
	
    ExitButton = new JButton("Finish");
    ExitButton.setBounds(600, 430, 101, 25); //257, 195, 101, 25
    add(ExitButton);
    ExitButton.addActionListener(new ExitButtonListener());
  }
  public class ExitButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.exit(0);
    }
  }
}
