package com.example.remoatecommandsexcuter.Service.Helper;
public class RemoteConnectionUsingSSh extends RemoteConnection{

    public RemoteConnectionUsingSSh() {
        super();
    }

    public RemoteConnectionUsingSSh(String host, String userName, int port, String password,String enablePassword) {
        super(host, userName, port, password,enablePassword);
    }

    @Override
    public void login() {

    }

    @Override
    public String runCommand(String s) {
        return null;
    }

    @Override
    public void disconnect() {

    }
}


