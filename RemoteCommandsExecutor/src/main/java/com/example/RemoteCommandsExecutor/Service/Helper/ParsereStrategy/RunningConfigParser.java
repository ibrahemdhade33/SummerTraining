package com.example.RemoteCommandsExecutor.Service.Helper.ParsereStrategy;

//parsing the show running-config command
public class RunningConfigParser extends Parser {
    @Override
    public Object parseCommand(String CommandOutput) throws Exception {
        if(CommandOutput.equals(""))
            throw new Exception("Error") ;
        else
            return CommandOutput ;
    }
}
