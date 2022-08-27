package Regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.* ;
public class RegexForVersion {
    public static void main(String[]args) throws IOException {

        Path filePath = Path.of("/home/ibraheem/Desktop/shversion.txt");

        String CommandOutput = Files.readString(filePath);


        //System.out.println(CommandOutput);
        Pattern p = Pattern.compile("(\\bcisco\\b)(.*)(\\bsoftware\\b)");
        Matcher m = p.matcher(CommandOutput) ;
        if (m.find()){
            String s = m.group(2);
            System.out.println(s);
        }


        Pattern p1 = Pattern.compile("((\\bVersion\\b)\\s(\\d\\.\\d))");
        Matcher m1 = p1.matcher(CommandOutput) ;
        if (m1.find()){
            String s = m1.group(3);
            System.out.println(s);
        }


        Pattern p2 = Pattern.compile("(System image file is)\\s(.*)");
        Matcher m2 = p2.matcher(CommandOutput) ;
        if (m2.find()){
            String s = m2.group(2);
            System.out.println(s);
        }
}
}
