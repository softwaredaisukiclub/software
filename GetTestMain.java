import java.io.*;
import java.util.*;
class GetTestMain {
		//受信テスト用のメインメソッド
	public static void main(String[] args) throws Exception {
		System.out.println("get start");
		String myaddress = "hoge";
		String addressies[] = {"hoge"};
		NetworkServer net = new NetworkServer(myaddress,addressies);
		File file = net.getData("hoge",8000);
		System.out.println(file.getPath());
	}
}