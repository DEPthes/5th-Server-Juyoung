package week1;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        String fileName = "test.txt";
        File file = new File(fileName);
        try{
            file.createNewFile();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        String folderName = "test";
        File folder = new File(folderName);
        folder.mkdir();
        
    }
}
