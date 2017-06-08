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
		UpButton = new JButton("アップロード");
		UpButton.setBounds(64, 263, 101, 25);
		add(UpButton);
		UpButton.addActionListener(new UpButtonListener());
		BackButton = new JButton("戻る");
		BackButton.setBounds(331, 263, 101, 25);
		add(BackButton);
		BackButton.addActionListener(new BackButtonListener());
		textArea = new JTextArea();
		textArea.setBounds(12, 13, 470, 237);
		add(textArea);
		//ドロップ操作を有効にする
		textArea.setTransferHandler(new DropFileHandler());

	}
	public class UpButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
			Boolean result = client.store(upFiles.get(0));//今は1つだけのファイルを送信するようにする
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
		/*ドロップされたものを受け取るか判断(ファイルの時だけ受け取る)*/
		public boolean canImport(TransferSupport support){
			if(!support.isDrop()){
				//ドロップ操作ではない場合は受け取らない
				return false;
			}
			if(!support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
				return false;
			}
			return true;
		}
		/*ドロップされたファイルを受け取る*/
		@SuppressWarnings("unchecked") public boolean importData(TransferSupport support){
			//受け取っていいか確認する
			List<File> files = null;
			if(!canImport(support)){
				return false;
			}
			Transferable t = support.getTransferable();
			try{
				files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
				//テキストエリアに表示するファイル名リストを作成する
				StringBuffer fileList = new StringBuffer();
				for(File file : files){
					upFiles.add(file);
					fileList.append(file.getAbsolutePath());
					fileList.append("\n");
				}
				//テキストエリアにファイルパスのリストを表示する
				textArea.setText(fileList.toString());
				return true;
			}catch(UnsupportedFlavorException | IOException e){
				e.printStackTrace();
				return false;
			}
		}
	}
}
