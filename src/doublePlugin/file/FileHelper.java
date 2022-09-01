package doublePlugin.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class FileHelper {
	private final File file;
	public FileHelper(File file) {
		this.file = file;
	}

	public void copyFile(File target, ArrayList<String> ignoreFileName) {
		copyFile(file, target, ignoreFileName);
	}
	
	private void copyFile(File file, File target, ArrayList<String> ignoreFileName) {
		try {
	        if(!ignoreFileName.contains(file.getName())) {
	            if(file.isDirectory()) {
	                if(!target.exists())
	                    if (!target.mkdirs())
	                        throw new IOException("Couldn't create world directory!");
	                String files[] = file.list();
	                for (String filz : files) {
	                    File srcFile = new File(file, filz);
	                    File destFile = new File(target, filz);
	                    copyFile(srcFile, destFile, ignoreFileName);
	                }
	            } else {
	                InputStream in = new FileInputStream(file);
	                OutputStream out = new FileOutputStream(target);
	                byte[] buffer = new byte[1024];
	                int length;
	                while ((length = in.read(buffer)) > 0)
	                    out.write(buffer, 0, length);
	                in.close();
	                out.close();
	            }
	        }
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void fileDelete() {
		fileDelete(file);
	}
	
	private void fileDelete(File file) {
		if(file.isDirectory()) {
            String files[] = file.list();
            for (String str : files) {
            	fileDelete(new File(file, str));
            }
        }
        
        file.delete();
	}
}
