package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CreateRandomInts {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\ints.txt");
            if(! file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
