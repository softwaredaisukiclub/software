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
		switch(query) {
			case "find":
			ArrayList<File> getFiles = getData();
			addFile(getFiles);
			break;
			case "delete":
			String getResult = getString();
			addResult(getResult);
			break;
			case "store":
			String getResult = getString();
			addResult(getResult);
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
		for(Thread thread : threads) {
			thead.join();
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
			sendString(filename, address);
		}
		for(Thread thread : threads) {
			thead.join();
		}
		return result.indexOf("success") != -1;
	}

	public boolean store(File file) {
		results.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "store";
		String filename = file.getName();
		for(String address : myaddresses) {
			Thread thread = new Thread(this);
			threads.add(thread);
			thread.start();
			sendString("store", address);
			sendString(filename, address);
		}
		for(Thread thread : threads) {
			thead.join();
		}
		return result.indexOf("success") != -1;
	}
}


