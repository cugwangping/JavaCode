import com.synjones.wsinvoke.CryptUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        try 
        {
            String str = readFileContent(args[2]);
            String[] str_arr = CryptUtil.encrypt(args[0], args[1], str);
            System.out.println("###");
            File file_fmsg = new File(args[3]);
            file_fmsg.createNewFile();
            BufferedWriter out1 = new BufferedWriter(new FileWriter(file_fmsg));
            out1.write(str_arr[0]);
            out1.flush();
            out1.close();
            File file_gmsg = new File(args[4]);
            file_gmsg.createNewFile();
            BufferedWriter out2 = new BufferedWriter(new FileWriter(file_gmsg));
            out2.write(str_arr[1]);
            out2.flush();
            out2.close();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    private static String readFileContent(String fileName) throws IOException {

        File file = new File(fileName);

        BufferedReader bf = new BufferedReader(new FileReader(file));

        String content = "";
        StringBuilder sb = new StringBuilder();

        while(content != null){
            content = bf.readLine();

            if(content == null){
                break;
            }

            sb.append(content.trim());
        }

        bf.close();
        return sb.toString();
    }
}
