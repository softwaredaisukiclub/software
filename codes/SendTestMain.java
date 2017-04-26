import java.io.*;
import java.util.*;
public class SendTestMain {
	//送信テスト用のメインメソッド
	public static void main(String[] args) throws Exception {
		File file = new File("row_data/"+"hoge.in");
		System.out.println("send start");
		String myaddress = "hoge";
		String addressies[] = {"hoge"};
		NetworkServer net = new NetworkServer(myaddress,addressies);
		net.sendData(file, "localhost");
		System.out.println("ended");
	}
}