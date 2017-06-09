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
					//UI�̃e�[�}��windows�ɂ���
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
		/*setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		showServerPanel();
	}

	public void showServerPanel(){
		//���݂̃p�l����\��
		getContentPane().removeAll();

		setTitle("�T�[�o�[");
		getContentPane().add(new ServerPanel());
		setBounds(100, 100, 450, 300);
	}

	public void showServerResultPanel(){
		//���݂̃p�l����\��
		getContentPane().removeAll();

		setTitle("�T�[�o�[");
		getContentPane().add(new ServerResultPanel());
		setBounds(100, 100, 450, 300);
	}


}
