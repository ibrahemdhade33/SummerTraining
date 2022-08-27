package com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy;

//parsing the startup-config command
public class StartupConfigParser extends Parser {
    @Override
    public String parseCommand(String CommandOutput) throws Exception {
        if(CommandOutput.equals(""))
            throw new Exception("Error") ;
        else
            return CommandOutput ;

    }
}
