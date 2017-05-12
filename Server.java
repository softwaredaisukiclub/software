import java.util.*;
import java.io.*;
import java.net.*;
public class Server extends NetworkServer {
	public DataBase dataBase  = new DataBase();
	private static String host = "localhost";
	private int addport = 1;
	public Server(String address, String[] addresses) {
		// address: 自分のアドレス
		// addresses: 自分とクライアント以外のアドレス
		super(address, addresses);
		//addport = address.hashCode();
		addport = Integer.parseInt(address.substring(4,6));
	}

	public void serverStart() {
		//サーバを起動するメソッド
		//port 8000+addport
		String filename;
		while(true) {
			String query = getString(0);
			switch(query) {
				case "find":
				filename = getString(0);
				System.out.println("find");
				if(dataBase.find(filename)) {
					sendString("success",host,addport);
				}else{
					sendString("failue",host,addport);
				}
				break;
				case "delete":
				filename = getString(0);
				System.out.println("delete");
				if(dataBase.delete(filename)) {
					sendString("success",host,addport);
				}else{
					sendString("failue",host,addport);
				}
				break;
				case "store":
				File file = getData(0).get(0);//今は一つだけ
				System.out.println("store");
				if(dataBase.store(file)) {
					sendString("success",host,addport);
				}else{
					sendString("failue",host,addport);
				}
				break;
			}
		}
	}
}
