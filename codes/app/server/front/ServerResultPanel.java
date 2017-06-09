package server.front;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ServerResultPanel extends JPanel {
  private JLabel label;
  private JButton ExitButton;
  /**
   * Create the panel.
   */
  public ServerResultPanel() {
    setLayout(null);
    label = new JLabel("設定が完了しました。現在稼働中です");
    label.setBounds(185, 133, 200, 24);
    add(label);

    ExitButton = new JButton("終了");
    ExitButton.setBounds(257, 195, 101, 25);
    add(ExitButton);
    ExitButton.addActionListener(new ExitButtonListener());
  }
  public class ExitButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.exit(0);
    }
  }
}
