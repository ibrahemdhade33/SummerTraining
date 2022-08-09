package com.example.remoatecommandsexcuter.Service.Helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class RemoteConnection {
    public String host ;
    public String userName ;
    public int port ;
    public String password ;
    public String enablePassword ;
    public abstract void login() throws IOException;

    public abstract String runCommand(String s);
    public abstract void disconnect();
}
