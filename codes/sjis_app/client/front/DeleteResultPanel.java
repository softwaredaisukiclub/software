package client.front;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteResultPanel extends JPanel {
  private JLabel label;
  private JButton BackButton;
  /**
   * Create the panel.
   */
  public DeleteResultPanel(boolean result) {
     setLayout(null);
    if(result){
      label = new JLabel("íœ‚µ‚Ü‚µ‚½");
    }else{
      label = new JLabel("íœ‚Å‚«‚Ü‚¹‚ñ‚Å‚µ‚½iÎj");
    }
    label.setBounds(185, 133, 200, 24);
    add(label);

    BackButton = new JButton("–ß‚é");
    BackButton.setBounds(257, 195, 101, 25);
    add(BackButton);
    BackButton.addActionListener(new BackButtonListener());
  }
  public class BackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
      mframe.showInitPanel();
      mframe.setVisible(true);
    }
  }
}
