package server.serverside;
import java.util.*;
import java.io.*;
import java.net.*;
import module.*;
public class Server extends NetworkServer {
	public DataBase dataBase  = new DataBase();
	private static String host;
	private int addport;
	public Server(String address, String getHost) {
		// address: 自分のアドレス
		// addresses: 自分とクライアント以外のアドレス
		super(address, null);
		host = getHost;
		if(address =="localhost"){
			addport = 50;
		}else{
		addport = Integer.parseInt(address.substring(5,7));
	}
		File stragedir = new File(PathList.stragePath);
		if(!stragedir.exists()){
			stragedir.mkdir();
		}
		File zipdir = new File(PathList.zipDataPath);
		if(!zipdir.exists()){
			zipdir.mkdir();
		}
	}

	public void serverStart() {
		//サーバを起動するメソッド
		//port 8000+addport
		String filename;
		File file;
		while(true) {
			String query = getString(0);
			switch(query) {
				case "find":
				filename = getString(0);
				System.out.println("find");
				if(dataBase.find(filename)) {
					sendString(myaddress,host,addport);
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
				file = getData(0).get(0);//今は一つだけ
				System.out.println("store");
				if(dataBase.store(file)) {
					sendString("success",host,addport);
				}else{
					sendString("failue",host,addport);
				}
				break;
				case "get":
				filename = getString(0);
				System.out.println("get");
				File files[] = {dataBase.get(filename)};
				sendData(files,host,addport);
				break;
				case "test":
				System.out.println("test");
				break;

			}
		}
	}
}
