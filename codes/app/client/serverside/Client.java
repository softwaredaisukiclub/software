package client.serverside;
import java.util.*;
import java.io.*;
import java.net.*;
import module.*;
public class Client extends NetworkServer implements Runnable {
	private String query;
	private ArrayList<String> results = new ArrayList<String>();
	private ArrayList<File> files = new ArrayList<File>();
	private int addport;
	private static int nowAddress = -1;
	private static int size = 0;

	public Client() {
		// address: 自分のアドレス
		// addresses: サーバーのアドレスの配列
		super(AddressList.getHost(),AddressList.getServerList());
		timeout = 10;
		if(size == 0) size = AddressList.getServerList().length;

		File zipdir = new File(PathList.zipDataPath);
		if(!zipdir.exists()) zipdir.mkdir();
		File unzipdir = new File(PathList.unzipDataPath);
		if(!unzipdir.exists()) unzipdir.mkdir();
	}



	private int getIndex() {
		nowAddress++;
		nowAddress %= size;
		return nowAddress;
	}

	private int getPort(String address) {
		if(address.equals("localhost")){
			return 50;
		}else{
			return Integer.parseInt(address.substring(4,7));
		}
	}

	public synchronized void addFile(ArrayList<File> getFiles) {
		files.addAll(getFiles);
	}

	public synchronized void addResult(String getResult) {
		if(!getResult.equals("failue")) results.add(getResult);
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
				addport = getPort(address);
				nowthread = new Thread(this);
				threads.add(nowthread);
				nowthread.start();
				sendString("find", address,0);
			}
			Thread.sleep(300);
			for(String address : myaddresses) sendString(filename, address,0);
			for(Thread thread : threads)      thread.join();
			return (results.size() > 0);
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
				addport = getPort(address);
				Thread thread = new Thread(this);
				threads.add(thread);
				thread.start();
				sendString("delete", address,0);
			}
			Thread.sleep(300);
			for(String address : myaddresses) sendString(filename, address,0);
			for(Thread thread : threads) thread.join();
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
				String address = myaddresses[getIndex()];
				addport = getPort(address);
				Thread thread = new Thread(this);
				thread.start();
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
				Thread thread = new Thread(this);
				String address = results.get(0);
				addport = getPort(address);
				thread.start();
				sendString("get", address,0);
				Thread.sleep(300);
				sendString(filename,address,0);
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


