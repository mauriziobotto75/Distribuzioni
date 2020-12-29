

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	
	public static void saveFile(File file, String fileName) throws IOException{
		
        FileInputStream in = null;
        FileOutputStream out = null;
         
        File dir = new File ("C:/images"); //constructor con pathname
        if ( !dir.exists() )
           dir.mkdirs(); //Creates the directory 
         
        String targetPath =  "C:/images" + File.separator + fileName;
        File destinationFile = new File ( targetPath);
        try {
            in = new FileInputStream( file );
            out = new FileOutputStream( destinationFile );
            int c;
 
            while ((c = in.read()) != -1) {
                out.write(c);
            }
 
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
         
    }
}
