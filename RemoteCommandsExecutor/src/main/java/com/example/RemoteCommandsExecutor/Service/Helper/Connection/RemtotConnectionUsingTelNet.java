package com.example.RemoteCommandsExecutor.Service.Helper.Connection;

import lombok.NoArgsConstructor;
import org.apache.commons.net.telnet.TelnetClient;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor
public class RemtotConnectionUsingTelNet extends RemoteConnection {
    private final TelnetClient telnet = new TelnetClient();

    public RemtotConnectionUsingTelNet(String host, String userName, int port, String password,String enablePassword) {
        super(host, userName, port, password,enablePassword);

    }
    public String readUntil1()  {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            byte[] buf = new byte[1024];
            int len ;
            Thread.sleep(750L);
            while ((len = telnet.getInputStream().read(buf)) != 0) {
                stringBuilder.append(new String(buf, 0, len, StandardCharsets.UTF_8));
                Thread.sleep(750L);
                if (telnet.getInputStream().available() == 0)
                    break;
            }
            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void write(String value) {
        try {
            value+="\n";
            telnet.getOutputStream().write(value.getBytes());
            telnet.getOutputStream().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String runCommand(String command) {
        try{ write(command);
            String result = readUntil1();
            disconnect();
            return result ;
        }
        catch (Exception e){
            return e.getMessage() ;
        }


    }
    @Override
    public void disconnect() {
        try {
            telnet.disconnect();
          }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void login() throws IOException, InterruptedException {
        try{
        telnet.connect(host, port);
        readUntil1();
        write(userName);
        readUntil1();
        write(password);
        readUntil1();
        write("enable");
        readUntil1();
        write(enablePassword);
        readUntil1();
        write("terminal length 0");
            readUntil1();
        }
        catch (Exception e){

        }

    }
}
