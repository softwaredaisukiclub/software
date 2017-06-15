package client.front;
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
      label = new JLabel("It was found:)");
      label.setFont(new Font("Century", Font.BOLD, 16));      
      label.setBounds(435, 300, 200, 24);
    }else{
      label = new JLabel("It wasn't found");
      label.setFont(new Font("Century", Font.BOLD, 16));      
      label.setBounds(435, 300, 200, 24);
    }
    add(label);

    BackButton = new JButton("Back");
    BackButton.setBounds(450, 450, 101, 25);
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
