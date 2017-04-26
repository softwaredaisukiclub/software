import java.util.zip.*;
import java.util.*;
import java.io.*;
public final class ZipClient {
	public static File compressZip( String rootPath, String[] inputFiles , String outputFile ) throws Exception {
    //ファイルを圧縮するメソッド
		if( rootPath     == null ){ throw new Exception(); }
		if( inputFiles   == null ){ throw new Exception(); }
		if( outputFile   == null ){ throw new Exception(); }
		try(
			FileOutputStream     out     = new FileOutputStream(outputFile);
			BufferedOutputStream bos     = new BufferedOutputStream(out);
			ZipOutputStream      archive = new ZipOutputStream(out);
			){
			archive.setLevel(9);//圧縮レベルの設定
			for( String fileName : inputFiles ) {
				ZipEntry entry   = new ZipEntry(fileName);
				archive.putNextEntry( entry );
				if( fileName.endsWith("/") ) { 
					archive.closeEntry();
					continue;
				}
				try(
					FileInputStream     fis = new FileInputStream(rootPath+fileName);
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
						bos.write( buf, 0, size );
					}
					files.add(file);
				}
			}
		}
		return files;
	}
}