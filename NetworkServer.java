import java.util.*;
import java.io.*;
import java.net.*;
public class NetworkServer {
	//送受信されたデータを保存するディレクトリを設定するクラス変数
	public static final int PORT = 8000;
	private static String zipDataDir = "zip_data/";//圧縮したデータを保存しておくディレクトリ
	private static String rowDataDir = "row_data/";//送受信に使う生データを保存しておくディレクトリ
	private static String unzipDataDir = "unzip_data/";//回答したファイルを保存しておくディレクトリ
	//コンストラクタ。自分のアドレスと送信する相手のアドレスを配列でもつ。（まだ変更するかも）
	public NetworkServer(String address, String[] addressies){
		String myaddress = address;
		String[] myaddressies = addressies;
	}
	//圧縮系の細かいメソッドは長いからZipClientに分割しました。
	/*zipに圧縮するメソッド。今はファイルしか引数に持ってないけど、
	もしかしたら圧縮後のファイル名も引数でも足した方がいいかも
	（もしかしたらディレクトリごと送信できるようにするかもしれないから）*/
	private File zip(File file) throws Exception {
		String filename[] = {file.getName()};
		String zipFilename = filename[0] + ".zip";
		String zipPath = zipDataDir+zipFilename;
		return ZipClient.compressZip(rowDataDir, filename, zipPath);
	}

	//zipを解凍するメソッドディレクトリを受け取った時を考えて戻り値をファイルの配列にしてある
	/*public static File[] unzip(File file) throws Exception {
		String filename = file.getName();
		return ZipClient.decompressZip(send_data_dir+filename, get_data_dir);
	}*/

	//とりあえずファイル一つだけしか圧縮しないことにする
	private File unzip(File file) throws Exception {
		String filename = file.getName();
		return ZipClient.decompressZip(zipDataDir+filename, unzipDataDir)[0];
	}
/*
public void sendString(String data, String host) {
	//ファイル名を送信するメソッド
}

public String getString() {
		//ファイル名を受信するメソッド
}

*/
public void sendData(File sendFile,String host) throws Exception {
		File file = zip(sendFile); // 送信するファイルのオブジェクト
			byte[] buffer = new byte[512];      // ファイル送信時のバッファ
			try(
			// ソケットの準備
				Socket socket = new Socket(host, PORT);

			// ストリームの準備
				InputStream  inputStream  = new FileInputStream(file);
				OutputStream outputStream = socket.getOutputStream();

				){
				int fileLength;
				while ((fileLength = inputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, fileLength);
				}

			// 終了処理
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				socket.close();
			}
		}

		public File getData(String filename) throws Exception {
		String filepath = zipDataDir+filename+".zip";       // 受信したファイルの保存先
		byte[] buffer = new byte[512]; // ファイル受信時のバッファ
		try(
			// ソケットの準備
			ServerSocket serverSocket = new ServerSocket(PORT);
			Socket       socket       = serverSocket.accept();

			// ストリームの準備
			InputStream  inputStream  = socket.getInputStream();
			OutputStream outputStream = new FileOutputStream(filepath);
			){

			// ファイルをストリームで受信
			int fileLength;
			while ((fileLength = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, fileLength);
			}

			// 終了処理
			outputStream.flush();
			outputStream.close();
			inputStream.close();
			socket.close();
			serverSocket.close();
			return unzip(new File(filepath));
		}
	}
}