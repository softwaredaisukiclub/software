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
		switch(query) {
			case "find":
			//ArrayList<File> getFiles = getData(addport);
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
		}
	}

	public boolean find(String filename) {
		//files.clear();
		results.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Thread nowthread;
		query = "find";
		try{
			for(String address : myaddresses) {
				nowthread = new Thread(this);
				threads.add(nowthread);
				//addport =  address.hashCode();
				addport = Integer.parseInt(address.substring(4,6));
				nowthread.start();
				sendString("find", address,addport);
				Thread.sleep(100);
				sendString(filename, address,addport);
			}
			Thread.sleep(100);
			for(String address : myaddresses) {
				sendString(filename, address,addport);
			}
			for(Thread thread : threads) {
				thread.join();
			}
			//return files;
			return results.contains("success");
		}catch(Exception e){
			e.printStackTrace();
		}
		//return files;
		return false;
	}

	public boolean delete(String filename) {
		results.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "delete";
		try{
			for(String address : myaddresses) {
				Thread thread = new Thread(this);
				threads.add(thread);
				//addport =  address.hashCode();
				addport = Integer.parseInt(address.substring(4,6));
				thread.start();
				sendString("delete", address,addport);
			}
			Thread.sleep(100);
			for(String address : myaddresses) {
				sendString(filename, address,addport);
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
		files.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "find";
		String filename = file.getName();
		try{
		for(String address : myaddresses) {
			Thread thread = new Thread(this);
			threads.add(thread);
			//addport =  address.hashCode();
			addport = Integer.parseInt(address.substring(4,6));
			thread.start();
			sendString("find", address,addport);
		}
		Thread.sleep(100);
		for(String address : myaddresses) {
			sendString(filename, address,addport);
		}
		for(Thread thread : threads) {
			thread.join();
		}
		if(files.isEmpty()) {
			query = "store";
			results.clear();
			Thread thread = new Thread(this);
			thread.start();
			int size = myaddresses.length;
			String address = myaddresses[new Random().nextInt(size)];//まだ実装をちゃんと考えていない。とりあえすランダムに保存
			sendString("store", address,addport);
			File files[] = {file};
			sendData(files, address,addport);
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
}


