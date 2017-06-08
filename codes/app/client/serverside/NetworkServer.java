package client.serverside;
import java.util.*;
import java.io.*;
import java.net.*;
public class NetworkServer {
	//送受信されたデータを保存するディレクトリを設定するクラス変数
	public static final int PORT = 8000;
	protected String myaddress;
	protected String[] myaddresses;
	//コンストラクタ。自分のアドレスと送信する相手のアドレスを配列でもつ。（まだ変更するかも）
	public NetworkServer(String address, String[] addresses) {
		myaddress = address;
		myaddresses = addresses;
	}



	//複数のファイルを引数に持たせると一つのzipファイルになる
	private File zip(File[] files) throws Exception {
		String zipFilename ="data.zip";
		String zipPath = PathList.zipDataPath+zipFilename;
		return ZipClient.compressZip(PathList.rowDataPath, files, zipPath);
	}


	//解凍時に複数のファイルになることがあるのでリストで返すようにした
	private ArrayList<File> unzip(File file) throws Exception {
		String filename = file.getName();
		return ZipClient.decompressZip(PathList.zipDataPath+filename, PathList.unzipDataPath);
	}

	public void sendString(String data, String host,int num) {
		//ファイル名を送信するメソッド
		Socket socket = new Socket();
		try{
			// ソケットの準備
			socket.connect(new InetSocketAddress(host, PORT+num),1000);
			//socket = new Socket(host, PORT+num);
			// 送信バッファ設定
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

			out.println(data);	// String送信
			socket.close();
			if(data.equals("test")){
				AddressList.addServerList(host);
			}
		} catch(Exception e) {
			if(!data.equals("test")){
				e.printStackTrace();
			}
		}
	}

	public String getString(int num) {
		//ファイル名を受信するメソッド
		// ソケットの準備
		Socket socket = null;
		String str= null;
		try {
			ServerSocket s = new ServerSocket(PORT+num);
			socket = s.accept();	// コネクション設定要求を待つ
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	// データ受信用バッファの設定
				 str = in.readLine();	// ファイル名受信
				 socket.close();
				 s.close();
				 return str;
				}catch(Exception e){
					e.printStackTrace();
					return str;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return str;
		}

		public void sendData(File[] sendFiles,String host,int num) {
			byte[] buffer = new byte[512];      // ファイル送信時のバッファ
			try{
				File file = zip(sendFiles); // 送信するファイルのオブジェクト
			// ソケットの準備
				Socket socket = new Socket(host, PORT+num);
			// ストリームの準備
				InputStream  inputStream  = new FileInputStream(file);
				OutputStream outputStream = socket.getOutputStream();

				int fileLength;
				while ((fileLength = inputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, fileLength);
				}
				// 終了処理
				socket.close();
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				file.delete();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		public ArrayList<File> getData(int num) {
		String filepath = PathList.zipDataPath+UUID.randomUUID()+".zip";       // 受信したファイルの保存先
		byte[] buffer = new byte[512]; // ファイル受信時のバッファ
		ArrayList<File> data = null;
		try{
			// ソケットの準備
			ServerSocket serverSocket = new ServerSocket(PORT+num);
			Socket       socket       = serverSocket.accept();
			// ストリームの準備
			InputStream  inputStream  = socket.getInputStream();
			OutputStream outputStream = new FileOutputStream(filepath);
			// ファイルをストリームで受信
			int fileLength;
			while ((fileLength = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, fileLength);
			}
			// 終了処理
			socket.close();
			serverSocket.close();
			outputStream.flush();
			outputStream.close();
			inputStream.close();
			File getData = new File(filepath);
			data = unzip(getData);
			getData.delete();
			return data;
		}catch(Exception e){
			e.printStackTrace();
			return data;
		}
	}
}