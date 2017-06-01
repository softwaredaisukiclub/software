package ソフトウェア制作;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

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
		setBounds(400, 400, 400, 400);
		//最初は初期画面表示
		showSetupPanel();
	}

	public void showSetupPanel() {
//現在のパネル非表示
		getContentPane().removeAll();

		setTitle("設定画面");
		getContentPane().add(new SetupPanel());
		setBounds(100, 100, 450, 300);
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

	public void showDeletePanel() {
		getContentPane().removeAll();

		setTitle("削除画面");
		getContentPane().add(new DeletePanel());
		setBounds(100, 100, 450, 350);
	}

	public void showUpResultPanel(boolean result){
		getContentPane().removeAll();

		setTitle("アップロード結果");
		getContentPane().add(new UpResultPanel(result));
		setBounds(100, 100, 450, 350);
	}

	public void showDownResultPanel(File resultFile){
		getContentPane().removeAll();

		setTitle("ダウンロード結果");
		getContentPane().add(new DownResultPanel(resultFile));
		setBounds(100, 100, 450, 350);
	}

	public void showSearchResultPanel(boolean result){
		getContentPane().removeAll();

		setTitle("検索結果");
		getContentPane().add(new SearchResultPanel(result));
		setBounds(100, 100, 450, 350);
	}

	public void showDeleteResultPanel(boolean result){
		getContentPane().removeAll();

		setTitle("削除結果");
		getContentPane().add(new DeleteResultPanel(result));
		setBounds(100, 100, 450, 350);
	}

}
