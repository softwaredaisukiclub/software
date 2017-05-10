import java.io.*;
import java.util.*;
public class GetTestMain {
		//受信テスト用のメインメソッド
	/*public static void main(String[] args) throws Exception {
		System.out.println("get start");
		String myaddress = "hoge";
		String addressies[] = {"hoge"};
		NetworkServer net = new NetworkServer(myaddress,addressies);
		ArrayList<File> files = net.getData(11);
		for(File file:files){
		System.out.println(file.getPath());
	}*/

	public static void main(String[] args) {
		String myaddress = "localhost";
		String addressies[] = {"localhost"};
		Server server = new Server(myaddress,addressies);
		System.out.println("server start");
		server.serverStart();
	}
}
