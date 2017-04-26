import java.io.*;
import java.util.*;
public class SendTestMain {
	//送信テスト用のメインメソッド
	public static void main(String[] args) throws Exception {
		File[] files = {new File("row_data/"+"hoge")};
		System.out.println("send start");
		String myaddress = "hoge";
		String addressies[] = {"hoge"};
		NetworkServer net = new NetworkServer(myaddress,addressies);
		net.sendData(files, "localhost");
		System.out.println("ended");
	}
}