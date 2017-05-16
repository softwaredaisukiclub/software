import java.io.*;
import java.util.*;
public class DataBase {
	private HashSet<String> files = new HashSet<String>();
	public DataBase(){
		File tmpFile = new File(PathList.stragePath);
		String[] filelist = tmpFile.list();
		if(filelist != null){
			for(String filename:filelist) {
				files.add(filename);
			}
		}
	}

	public boolean find(String filename) {//今は名前が完全一致じゃないと見つけられない
		if(files.contains(filename)) {
			return true;
		}else{
			return false;
		}
	}

	public boolean delete(String filename) {//今は名前が完全一致じゃないと見つけられない
		if(files.contains(filename)) {
			File file = new File(PathList.stragePath+filename);
			file.delete();
			files.remove(filename);
			return true;
		}else{
			return false;
		}
	}

	public boolean store(File storeFile) {//今は名前が完全一致じゃないと見つけられない
		try{
			storeFile.createNewFile();
			files.add(storeFile.getName());
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public File get(String filename) {
		File file = new File(PathList.stragePath+filename);
		return file;
	}

}