package server.serverside;
import java.util.zip.*;
import java.util.*;
import java.io.*;
public final class ZipClient {
	public static File compressZip( String rootPath, File[] inputFiles , String outputFile ) throws Exception {
		//ファイルを圧縮するメソッド
		if( rootPath     == null ){ throw new Exception(); }
		if( inputFiles   == null ){ throw new Exception(); }
		if( outputFile   == null ){ throw new Exception(); }
		ArrayList<File> files = new ArrayList<File>();
		try(
				FileOutputStream     out     = new FileOutputStream(outputFile);
				BufferedOutputStream bos     = new BufferedOutputStream(out);
				ZipOutputStream      archive = new ZipOutputStream(out);
				){
			files = allFiles(inputFiles);
			archive.setLevel(9);//圧縮レベルの設定
			for( File file : files ) {
				String fileName = file.getName();
				String filePath = file.getPath();
				ZipEntry entry   = new ZipEntry(fileName);
				archive.putNextEntry( entry );
				try(
						FileInputStream     fis = new FileInputStream(filePath);
						BufferedInputStream bis = new BufferedInputStream(fis);
						){
					int     size = 0;
					byte[]  buf = new byte[1024];
					while( (size = bis.read(buf)) > 0 ) {

						archive.write(buf, 0, size );
					}
				}
				archive.closeEntry();
			}
		}
		return new File(outputFile);
	}

//ファイルを解凍するメソッド
	public static ArrayList<File> decompressZip( String inputFile , String outputDir ) throws Exception {
		ArrayList<File> files = new ArrayList<File>();
		try(
				FileInputStream fis = new FileInputStream(inputFile);
				ZipInputStream  archive = new ZipInputStream(fis);
				){
			ZipEntry entry   = null;
			while( ( entry = archive.getNextEntry() ) != null ) {
				File file = new File( outputDir + "/" + entry.getName() );
				if( entry.isDirectory() ) {
					file.mkdirs();
					continue;
				}
				if( !file.getParentFile().exists() ){ file.getParentFile().mkdirs(); }
				try(
						FileOutputStream fos = new FileOutputStream( file );
						BufferedOutputStream bos = new BufferedOutputStream( fos );
						){
					int     size = 0;
					byte[]  buf  = new byte[ 1024 ];
					while( (size = archive.read(buf)) > 0 ) {
						bos.write(buf, 0, size );
					}
					files.add(file);
				}
			}
		}
		return files;
	}

	private static ArrayList<File> allFiles(File[] files) {
		ArrayList<File> allfiles = new ArrayList<File>();
		for(File file : files ) {
			if(file.isDirectory()) {
				allfiles.addAll(allFiles(file.listFiles()));
			}
			else {
				allfiles.add(file);
			}
		}
		return allfiles;
	}
}