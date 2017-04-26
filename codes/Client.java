import java.util.*;
import java.io.*;
import java.net.*;
public class Client extends NetworkServer implements Runnable {
	private String query;
	private ArrayList<String> results = new ArrayList<String>();
	private ArrayList<File> files = new ArrayList<File>();

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
		switch(query) {
			case "find":
			ArrayList<File> getFiles = getData();
			if(getFiles != null) {
				addFile(getFiles);
			}
			break;
			case "delete":
			result = getString();
			addResult(result);
			break;
			case "store":
			result = getString();
			addResult(result);
			break;
		}
	}

	public ArrayList<File> find(String filename) {
		files.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Thread nowthread;
		query = "find";
		for(String address : myaddresses) {
			nowthread = new Thread(this);
			threads.add(nowthread);
			nowthread.start();
			sendString("find", address);
			sendString(filename, address);
		}
		for(String address : myaddresses) {
			sendString(filename, address);
		}
		for(Thread thread : threads) {
			thread.join();
		}
		return files;
	}

	public boolean delete(String filename) {
		results.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "delete";
		for(String address : myaddresses) {
			Thread thread = new Thread(this);
			threads.add(thread);
			thread.start();
			sendString("delete", address);
		}
		for(String address : myaddresses) {
			sendString(filename, address);
		}
		for(Thread thread : threads) {
			thread.join();
		}
		return results.contains("success");
	}
	//今はファイル一つづつしか保存できないようにする
	public boolean store(File file) {
		files.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "find";
		String filename = file.getName();
		for(String address : myaddresses) {
			Thread thread = new Thread(this);
			threads.add(thread);
			thread.start();
			sendString("find", address);
		}
		for(String address : myaddresses) {
			sendString(filename, address);
		}
		for(Thread thread : threads) {
			thread.join();
		}
		if(files.isEmpty()){
			query = "store";
			results.clear();
			Thread thread = new Thread(this);
			thread.start();
			int size = myaddresses.size();
			String address = myaddresses[new Random().nextInt(size)];//まだ実装をちゃんと考えていない。とりあえすランダムに保存
			sendString("store", address);
			File files[] = {file};
			sendData(files, address);
			thread.join();
			return results.contains("success");
		}else{
			return false;
		}
	}
}


