import java.io.*;
import java.util.*;
public class DataBase {
	private ArrayList<String> files = new ArrayList<String>();
	private String stragePath ="unzip_data/";
	public DataBase(){
	}

	public boolean find(String filename) {//今は名前が完全一致じゃないと見つけられない
		int number = files.indexOf(filename);
		if(number == -1) {
			return false;
		}else{
			//File ansFiles[] = {files.get(number)};
			//return ansFiles;
			return true;
		}
	}

	public boolean delete(String filename) {//今は名前が完全一致じゃないと見つけられない
		int number = files.indexOf(filename);
		if(number == -1) {
			return false;
		}else{
			File file = new File(stragePath+filename);
			file.delete();
			files.remove(number);
			return true;
		}
	}

	public Boolean store(File storeFile) {//今は名前が完全一致じゃないと見つけられない
		try{
			storeFile.createNewFile();
			files.add(storeFile.getName());
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}