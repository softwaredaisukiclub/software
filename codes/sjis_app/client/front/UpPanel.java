package client.front;
import java.awt.Component;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import client.serverside.*;
public class UpPanel extends JPanel {
	//private JTextField textField;
	private JButton UpButton;
	private JButton BackButton;
	private JTextArea textArea;
	private static Client client = new Client();
	private ArrayList<File> upFiles;
	/**
	 * Create the panel.
	 */

	public UpPanel() {
		setLayout(null);


		upFiles = new ArrayList<File>();
		UpButton = new JButton("�A�b�v���[�h");
		UpButton.setBounds(64, 263, 101, 25);
		add(UpButton);
		UpButton.addActionListener(new UpButtonListener());
		BackButton = new JButton("�߂�");
		BackButton.setBounds(331, 263, 101, 25);
		add(BackButton);
		BackButton.addActionListener(new BackButtonListener());
		textArea = new JTextArea();
		textArea.setBounds(12, 13, 470, 237);
		add(textArea);
		//�h���b�v�����L���ɂ���
		textArea.setTransferHandler(new DropFileHandler());

	}
	public class UpButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			Boolean result = client.store(upFiles.get(0));//����1�����̃t�@�C���𑗐M����悤�ɂ���
			upFiles.clear();
			mframe.showUpResultPanel(result);
			mframe.setVisible(true);
		}
	}
	public class BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			upFiles.clear();
			mframe.showInitPanel();
			mframe.setVisible(true);
		}
	}
	public class DropFileHandler extends TransferHandler {
		/*�h���b�v���ꂽ���̂��󂯎�邩���f(�t�@�C���̎������󂯎��)*/
		public boolean canImport(TransferSupport support){
			if(!support.isDrop()){
				//�h���b�v����ł͂Ȃ��ꍇ�͎󂯎��Ȃ�
				return false;
			}
			if(!support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
				return false;
			}
			return true;
		}
		/*�h���b�v���ꂽ�t�@�C�����󂯎��*/
		@SuppressWarnings("unchecked") public boolean importData(TransferSupport support){
			//�󂯎���Ă������m�F����
			List<File> files = null;
			if(!canImport(support)){
				return false;
			}
			Transferable t = support.getTransferable();
			try{
				files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
				//�e�L�X�g�G���A�ɕ\������t�@�C�������X�g���쐬����
				StringBuffer fileList = new StringBuffer();
				for(File file : files){
					upFiles.add(file);
					fileList.append(file.getAbsolutePath());
					fileList.append("\n");
				}
				//�e�L�X�g�G���A�Ƀt�@�C���p�X�̃��X�g��\������
				textArea.setText(fileList.toString());
				return true;
			}catch(UnsupportedFlavorException | IOException e){
				e.printStackTrace();
				return false;
			}
		}
	}
}
