package ソフトウェア制作;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIのテーマをwindowsにする
					String winTheme = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					UIManager.setLookAndFeel(winTheme);

					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);

		//最初は初期画面表示
		showInitPanel();
		/*setBounds(100, 100, 450, 300);
		contentPane = new InitPanel();*/
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));*/
		/*setContentPane(contentPane);
		contentPane.setLayout(null);*/
	}

	public void showInitPanel(){
		//現在のパネル非表示
		getContentPane().removeAll();

		setTitle("初期画面");
		getContentPane().add(new InitPanel());
		setBounds(100, 100, 450, 300);
	}

	public void showSearchPanel(){
		getContentPane().removeAll();

		setTitle("検索画面");
		getContentPane().add(new SearchPanel());
		setBounds(100, 100, 450, 300);
	}

	public void showDownPanel(){
		getContentPane().removeAll();

		setTitle("ダウンロード画面");
		getContentPane().add(new DownPanel());
		setBounds(100, 100, 450, 350);
	}

	public void showUpPanel(){
		getContentPane().removeAll();

		setTitle("アップロード画面");
		getContentPane().add(new UpPanel());
		setBounds(100, 100, 500, 350);
	}
	public void showResultPanel(boolean result){
		getContentPane().removeAll();
		
		setTitle("検索結果");
		getContentPane().add(new ResultPanel(result));
		setBounds(100, 100, 500, 350);
	}
}
