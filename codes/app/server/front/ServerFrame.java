package server.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.UIManager;

public class ServerFrame extends JFrame {

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showServerPanel();
	}

	public void showServerPanel(){
		//現在のパネル非表示
		getContentPane().removeAll();

		setTitle("サーバー");
		getContentPane().add(new ServerPanel());
		setBounds(100, 100, 450, 300);
	}

	public void showServerResultPanel(){
		//現在のパネル非表示
		getContentPane().removeAll();

		setTitle("サーバー");
		getContentPane().add(new ServerResultPanel());
		setBounds(100, 100, 450, 300);
	}


}
