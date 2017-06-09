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
      label = new JLabel("ê›íËÇ™äÆóπÇµÇ‹ÇµÇΩÅBåªç›â“ì≠íÜÇ≈Ç∑");
    label.setBounds(185, 133, 200, 24);
    add(label);

    ExitButton = new JButton("èIóπ");
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
