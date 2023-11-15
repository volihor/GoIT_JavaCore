package mod_10_IOStreams;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberFinder {
    public static void main(String[] args) throws IOException {
        FileReader fReader = new FileReader("src/main/java/mod_10_IOStreams/filePhoneNumber.txt");
        BufferedReader bfr = new BufferedReader(fReader);

        String phoneRegex = "(\\d{3}-\\d{3}-\\d{4})|(\\(\\d{3}\\) \\d{3}-\\d{4})";
        Pattern pattern = Pattern.compile(phoneRegex);

        String strLine = bfr.readLine();
        while(strLine != null) {
            Matcher matcher = pattern.matcher(strLine);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
            strLine = bfr.readLine();
        }

        bfr.close();
        fReader.close();

//        (xxx) xxx-xxxx
//        xxx-xxx-xxxx
//        "(?\\d{3}\\)?[\s-]\\d{3}[\s-]\\d{4}"
//        ||\d{3}-\d{3}-\d{4}
    }
}
