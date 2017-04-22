package software;
import java.util.*;
import java.io.*;
public class NetworkServer{
	//送受信されたデータを保存するディレクトリを設定するクラス変数
	private static String send_data_dir = "send_data/";
	private static String input_data_dir = "input_data/";
	private static String get_data_dir = "get_data/";
	//コンストラクタ。自分のアドレスと送信する相手のアドレスを配列でもつ。（まだ変更するかも）
	public NetworkServer(String address, String[] addressies){
		String myaddress = address;
		String[] myaddressies = addressies;
	}
	//圧縮系の細かいメソッドは長いからZipClientに分割しました。
	/*zipに圧縮するメソッド。今はファイルしか引数に持ってないけど、
	もしかしたら圧縮後のファイル名も引数でも足した方がいいかも
	（もしかしたらディレクトリごと送信できるようにするかもしれないから）*/
	public static File zip(File file) throws Exception {
		String filename[] = {file.getName()};
		String zip_file_name = filename[0] + ".zip";
		String send_path = send_data_dir+zip_file_name;
		return ZipClient.compressZip(input_data_dir, filename, send_path);
	}

	//zipを解凍するメソッドディレクトリを受け取った時を考えて戻り値をファイルの配列にしてある
	/*public static File[] unzip(File file) throws Exception {
		String filename = file.getName();
		return ZipClient.decompressZip(send_data_dir+filename, get_data_dir);
	}*/
	//とりあえずファイル一つだけしか圧縮しないことにする
	public static File unzip(File file) throws Exception {
		String filename = file.getName();
		return ZipClient.decompressZip(send_data_dir+filename, get_data_dir)[0];
/*
public void send(File file, String filename) {
		//文字列を送信するメソッド
	return;
}

public File get(){
		//文字列を受信するメソッド
}
*/

//テスト用のメインメソッド
/*
public static void main(String[] args) throws Exception {

	File file = new File("input_data/hoge.txt");
	System.out.println(file.getAbsolutePath());

	File zipfile = NetworkServer.zip(file);
	System.out.println(zipfile.getAbsolutePath());

	File unzipfile = NetworkServer.unzip(zipfile)[0];
	System.out.println(unzipfile.getAbsolutePath());
 }
 */
}