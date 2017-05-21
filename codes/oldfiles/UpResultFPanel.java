
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class UpResultFPanel extends JPanel {
  private JLabel label;
  private JButton BackButton;

  /**
   * Create the panel.
   */
  public UpResultFPanel() {
    setLayout(null);

    label = new JLabel("失敗");
    label.setBounds(183, 130, 57, 16);
    add(label);

    BackButton = new JButton("戻る");
    BackButton.setBounds(167, 233, 101, 25);
    add(BackButton);
    BackButton.addActionListener(new BackButtonListener());
  }
  public class BackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
      mframe.showUpPanel();
      mframe.setVisible(true);
    }
  }

}
