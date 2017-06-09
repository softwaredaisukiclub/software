package client.front;

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
					//UI�̃e�[�}��windows�ɂ���
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
		//�ŏ��͏�����ʕ\��
		showSetupPanel();
	}

	public void showSetupPanel() {
//���݂̃p�l����\��
		getContentPane().removeAll();

		setTitle("�ݒ���");
		getContentPane().add(new SetupPanel());
		setBounds(100, 100, 450, 300);
	}

	public void showInitPanel(){
		//���݂̃p�l����\��
		getContentPane().removeAll();

		setTitle("�������");
		getContentPane().add(new InitPanel());
		setBounds(100, 100, 450, 300);
	}

	public void showSearchPanel(){

		getContentPane().removeAll();

		setTitle("�������");
		getContentPane().add(new SearchPanel());
		setBounds(100, 100, 450, 300);
	}

	public void showDownPanel(){
		getContentPane().removeAll();

		setTitle("�_�E�����[�h���");
		getContentPane().add(new DownPanel());
		setBounds(100, 100, 450, 350);
	}

	public void showUpPanel(){
		getContentPane().removeAll();

		setTitle("�A�b�v���[�h���");
		getContentPane().add(new UpPanel());
		setBounds(100, 100, 500, 350);
	}

	public void showDeletePanel() {
		getContentPane().removeAll();

		setTitle("�폜���");
		getContentPane().add(new DeletePanel());
		setBounds(100, 100, 450, 350);
	}

	public void showUpResultPanel(boolean result){
		getContentPane().removeAll();

		setTitle("�A�b�v���[�h����");
		getContentPane().add(new UpResultPanel(result));
		setBounds(100, 100, 450, 350);
	}

	public void showDownResultPanel(File resultFile){
		getContentPane().removeAll();

		setTitle("�_�E�����[�h����");
		getContentPane().add(new DownResultPanel(resultFile));
		setBounds(100, 100, 450, 350);
	}

	public void showSearchResultPanel(boolean result){
		getContentPane().removeAll();

		setTitle("��������");
		getContentPane().add(new SearchResultPanel(result));
		setBounds(100, 100, 450, 350);
	}

	public void showDeleteResultPanel(boolean result){
		getContentPane().removeAll();

		setTitle("�폜����");
		getContentPane().add(new DeleteResultPanel(result));
		setBounds(100, 100, 450, 350);
	}

}
