import java.util.*;
import java.io.*;
import java.net.*;
public class Client extends NetworkServer implements Runnable {
	private String filename;
	private String query;
	private String result;
	private ArrayList<File> files;

	public Client(String address, String[] myaddress) {
		// address: 自分のアドレス
		// addressies: サーバーのアドレスの配列
		super(address,myaddress);
	}

	public void run() {
		switch(query) {
			case "find":
			files =	getData(filename);
			break;
			case "delete":
			result = getString();
			break;
			case "store":
			result = getString();
			break;
		}
	}

	public ArrayList<File> find(String name) {
		files.clear();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		filename = name;
		Thread nowthread;
		query = "find";
		for(String address : myaddress) {
			nowthread = new Thread(this);
			threads.add(thread);
			thread.start();
			sendString("find", address);
			sendString(filename, address);
		}
		for(Thread thread : threads) {
			thead.join();
		}
		return files;
	}

	public boolean delete(String name) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "delete";
		for(String address : myaddress) {
			Thread thread = new Thread(this);
			threads.add(thread);
			thread.start();
			sendString("delete", address);
			sendString(name, address);
		}
		for(Thread thread : threads) {
			thead.join();
		}
		return result.equals("success");
	}

	public boolean store(File file) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		query = "store";
		for(String address : myaddress) {
			Thread thread = new Thread(this);
			threads.add(thread);
			thread.start();
			sendString("store", address);
			sendString(filename, address);
		}
		for(Thread thread : threads) {
			thead.join();
		}
		return result.equals("success");
	}
}