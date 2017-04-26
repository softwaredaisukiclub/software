import java.util.*;
import java.io.*;
import java.net.*;
public class Server extends NetworkServer implements Runnable {
	public DataBase dataBase  = new DataBase();
	private static String host = "localhost";
	public Server(String address, String[] addresses) {
		// address: 自分のアドレス
		// addresses: 自分とクライアント以外のアドレス
		super(address, addresses);
	}
	
	public void serverStart() {
		//サーバを起動するメソッド
		//port 8000
		String filename;
		while(true) {
			String query = getString();
			switch(query) {
				case "find":
				filename = getString();
				sendData(dataBase.find(filename),host);
				break;
				case "delete":
				filename = getString();
				if(dataBase.delete(filename)) {
					sendString("success");
				}else{
					sendString("failue");
				}
				break;
				case "store":
				ArrayList<File> files = getData();
				if(dataBase.store(files)) {
					sendString("success");
				}else{
					sendString("failue");
				}
				break;
			}
		}
	}
}