import java.util.*;
import java.io.*;
import java.net.*;
public class Client extends NetworkServer implements Runnable {
	private String query;
	private ArrayList<String> results = new ArrayList<String>();
	private ArrayList<File> files = new ArrayList<File>();
	private int addport;
	public Client(String address, String[] addresses) {
		// address: 自分のアドレス
		// addressies: サーバーのアドレスの配列
		super(address,addresses);
	}

	public synchronized void addFile(ArrayList<File> getFiles) {
		files.addAll(getFiles);
	}

	public synchronized void addResult(String getResult) {
		results.add(getResult);
	}

	public void run() {
		String result;
		ArrayList<File> files;
		switch(query) {
			case "find":
			result = getString(addport);
			addResult(result);
			break;
			case "delete":
			result = getString(addport);
			addResult(result);
			break;
			case "store":
			result = getString(addport);
			addResult(result);
			break;
			case "get":
			files = getData(addport);
			addFile(files);
			break;
		}
	}

	public boolean find(String filename) {
		results.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Thread nowthread;
		query = "find";
		try{
			for(String address : myaddresses) {
				addport = Integer.parseInt(address.substring(4,7));
				nowthread = new Thread(this);
				threads.add(nowthread);
				nowthread.start();
				sendString("find", address,0);
			}
			Thread.sleep(1000);
			for(String address : myaddresses) {
				sendString(filename, address,0);
			}
			for(Thread thread : threads) {
				thread.join();
			}
			return results.contains("success");
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String filename) {
		results.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "delete";
		try{
			for(String address : myaddresses) {
				addport = Integer.parseInt(address.substring(4,7));
				Thread thread = new Thread(this);
				threads.add(thread);
				thread.start();
				sendString("delete", address,0);
			}
			Thread.sleep(1000);
			for(String address : myaddresses) {
				sendString(filename, address,0);
			}
			for(Thread thread : threads) {
				thread.join();
			}
			return results.contains("success");
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	//今はファイル一つづつしか保存できないようにする
	public boolean store(File file) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		String filename = file.getName();
		try{
			if(!find(file.getName())) {
				query = "store";
				results.clear();
				Thread thread = new Thread(this);
				thread.start();
				int size = myaddresses.length;
			String address = myaddresses[new Random().nextInt(size)];//まだ実装をちゃんと考えていない。とりあえすランダムに保存
			sendString("store", address,0);
			File files[] = {file};
			sendData(files, address,0);
			thread.join();
			return results.contains("success");
		}else{
			return false;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return false;
}

public File get(String filename) {
	try{
		if(find(filename)) {
			query = "get";
			files.clear();
			Thread thread = new Thread(this);
			String address = myaddresses[results.indexOf("success")];
			addport = Integer.parseInt(address.substring(4,7));
			thread.start();
			sendString("get", address,0);
			thread.join();
			return files.get(0);
		}else{
			return null;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
}
}


