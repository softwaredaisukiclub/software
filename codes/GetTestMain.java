import java.io.*;
import java.util.*;
public class GetTestMain {
		//受信テスト用のメインメソッド
	public static void main(String[] args) throws Exception {
		System.out.println("get start");
		String myaddress = "hoge";
		String addressies[] = {"hoge"};
		NetworkServer net = new NetworkServer(myaddress,addressies);
		ArrayList<File> file = net.getData("hoge");
		System.out.println(file.get(0).getPath());
	}
}