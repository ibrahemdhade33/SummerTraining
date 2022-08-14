package com.example.remoatecommandsexcuter.Service.Helper;

import com.jcraft.jsch.JSchException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.IOException;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public  class RemoteConnection {
    public String host ;
    public String userName ;
    public int port ;
    public String password ;
    public String enablePassword ;
    public  void login() throws IOException, InterruptedException, JSchException {

    }

    public  String runCommand(String s) throws Exception {
     return null;
    }
    public  void disconnect(){

    }
}
