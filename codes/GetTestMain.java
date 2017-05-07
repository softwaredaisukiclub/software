import java.io.*;
import java.util.*;
public class GetTestMain {
		//受信テスト用のメインメソッド
	public static void main(String[] args) throws Exception {
		System.out.println("get start");
		String myaddress = "hoge";
		String addressies[] = {"hoge"};
		NetworkServer net = new NetworkServer(myaddress,addressies);
		ArrayList<File> files = net.getData();
		for(File file:files){
		System.out.println(file.getPath());
	}
	}
}