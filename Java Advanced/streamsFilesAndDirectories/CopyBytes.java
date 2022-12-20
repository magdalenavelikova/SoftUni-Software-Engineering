package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream in=new FileInputStream("Resources/input.txt");
        FileOutputStream out=new FileOutputStream("Resources/out.txt");
        int oneByte= in.read();
        while (oneByte!=-1){
            if(oneByte==10 || oneByte==32){
                out.write(oneByte);
            }else {
                String digit=String.valueOf(oneByte);
                for (int i = 0; i < digit.length(); i++) {
                    out.write(digit.charAt(i));
                }

            }
            oneByte= in.read();
        }
        in.close();
        out.close();
    }
}
