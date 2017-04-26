import java.io.*;
import java.util.*;
public class DataBase {
	private ArrayList<File> files = new ArrayList<File>();
	private HashSet<String> filenames = new HashSet<String>();
	public DataBase(){
	}

	public File[] find(String filename) {//今は名前が完全一致じゃないと見つけられない
		int number = files.indexOf(filename);
		if(number == -1) {
			return null;
		}else{
			File ansFiles[] = {files.get(number)};
			return ansFiles;
		}
	}

	public boolean delete(String filename) {//今は名前が完全一致じゃないと見つけられない
		int number = files.indexOf(filename);
		if(number == -1) {
			return false;
		}else{
			files.remove(number);
			return true;
		}
	}

	public Boolean store(ArrayList<File> files) {//今は名前が完全一致じゃないと見つけられない
		return false; //まだ未実装
	}
	
}