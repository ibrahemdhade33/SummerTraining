package com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy;
import com.example.RemoteCommandsExecutor.Service.Helper.Components.VersionComp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//parsing the show version command
public class VersionParser extends Parser {


    @Override
    public VersionComp parseCommand(String commandOutput) {
        System.out.println(commandOutput);
        String[]split = commandOutput.split("\n") ;
        String softwareFamily = null,softwareType = null,softwareVersion = null,systemImageFile = null,hostName = null;
        if (split.length>2){
           String regex = "(\\b[Cc]isco\\b)(.*)(\\bsoftware\\b)";
            Matcher matcher = getMatcher(regex,commandOutput) ;
            if (matcher.find()){
                String s = matcher.group(2);
                String [] split1 = s.split("-") ;
                softwareFamily = split1[0].trim();
                softwareType = split1[1].trim();
            }


           regex ="((\\bVersion\\b)\\s(\\d\\.\\d))";
            matcher = getMatcher(regex,commandOutput);
            if (matcher.find()){
                String s = matcher.group(3);
                System.out.println(s);
                softwareVersion = s ;
            }
            regex ="([Ss]ystem image file is)\\s(.*)";
            matcher = getMatcher(regex,commandOutput) ;
            if (matcher.find()){
                String s = matcher.group(2);
                System.out.println(s);
                systemImageFile = s ;
            }
        }
        return new VersionComp(softwareVersion,softwareType,softwareFamily,systemImageFile,hostName) ;
    }

    private Matcher getMatcher(String regex,String commandOutput){
        Pattern pattern = Pattern.compile(regex) ;
        return pattern.matcher(commandOutput);
    }

}
