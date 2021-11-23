

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelNumber {
    public static void main(String[] args) throws IOException {
        String pattern = "\\(\\d\\d\\d\\) \\d\\d\\d-\\d\\d\\d\\d";
        String pattern1 = "\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";



        BufferedReader br = new BufferedReader(new FileReader("fileTelNumber.txt"));
        for(String line; (line = br.readLine()) != null;){
            Pattern ptrn = Pattern.compile(pattern);
            Pattern ptrn1 = Pattern.compile(pattern1);
            Matcher matcher = ptrn.matcher(line);
            Matcher matcher1 = ptrn1.matcher(line);
            if(matcher.find() || matcher1.find()){
                System.out.println(line);
            }
        }
        br.close();
    }

}
