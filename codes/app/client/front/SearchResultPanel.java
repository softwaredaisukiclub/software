package front;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchResultPanel extends JPanel {
  private JLabel label;
  private JButton BackButton;
  /**
   * Create the panel.
   */
  public SearchResultPanel(boolean result) {
     setLayout(null);
    if(result){
      label = new JLabel("見つかりました！");
    }else{
      label = new JLabel("見つかりませんでした（笑）");
    }
    label.setBounds(185, 133, 200, 24);
    add(label);

    BackButton = new JButton("戻る");
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
