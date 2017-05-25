package serverside;
import java.io.*;
import java.util.*;
import serverside.*;
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
	}
}*/

	public static void main(String[] args) {
		//アドレスの番号二桁を入れる
		String myaddress = AddressList.getList(49);
		String host = AddressList.getList(49);
		Server server = new Server(myaddress,host);
		System.out.println("server start");
		server.serverStart();
	}
}
