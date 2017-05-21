
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

public class UpPanel extends JPanel {
	//private JTextField textField;
	private JButton UpButton;
	private JButton BackButton;
	private JTextArea textArea;
	//private Client client = new Client("三つ引数");
	/**
	 * Create the panel.
	 */
	public UpPanel() {
		setLayout(null);

		UpButton = new JButton("アップロード");
		UpButton.setBounds(64, 263, 101, 25);
		add(UpButton);
		//UpButton.addActionListener(new UpButtonListener());

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
			mframe.showUpResultPanel();
			mframe.setVisible(true);
		}
	}
	public class BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MainFrame mframe = (MainFrame)SwingUtilities.getWindowAncestor((Component)e.getSource());
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
		public boolean importData(TransferSupport support){
			//受け取っていいか確認する
			List<File> files = null;
			File returnFile = null;
			if(!canImport(support)){
				return false;
			}
			Transferable t = support.getTransferable();
			try{
				files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
				//テキストエリアに表示するファイル名リストを作成する
				StringBuffer fileList = new StringBuffer();
				for(File file : files){
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
