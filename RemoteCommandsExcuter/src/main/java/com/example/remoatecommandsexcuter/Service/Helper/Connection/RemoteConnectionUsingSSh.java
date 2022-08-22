package com.example.remoatecommandsexcuter.Service.Helper.Connection;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
public class RemoteConnectionUsingSSh extends RemoteConnection{
    private final JSch jsch = new JSch();
    PrintStream ps ;
    InputStream input ;
    Session session ;
    Channel channel ;
    OutputStream ops ;
    public RemoteConnectionUsingSSh() {
        super();
    }

    public RemoteConnectionUsingSSh(String host, String userName, int port, String password,String enablePassword) {
        super(host, userName, port, password,enablePassword);
    }

    @Override
    public void login() throws JSchException, IOException {

         session = jsch.getSession(userName, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
         channel = session.openChannel("shell");
         ops = channel.getOutputStream();
         ps = new PrintStream(ops, true);
        channel.connect();

        ps.println("en");
        ps.println(enablePassword);
        ps.println("terminal length 0");
    }

    @Override
    public String runCommand(String command) throws Exception {
        try{
            ps.print(command);

            String result = printResult() ;
            Thread.sleep(100);

            disconnect();
            return result;
        }
        catch (Exception e)
        {
            return e.getMessage() ;
        }

    }

    @Override
    public void disconnect() {
    channel.disconnect();
    session.disconnect();
    }
    private String  printResult() throws Exception {
        try {
            input = channel.getInputStream();
            int SIZE = 4096;
            byte[] tmp = new byte[SIZE];

            while (true) {
                while (input.available() > 0) {
                    int i = input.read(tmp, 0, SIZE);
                    if (i < 0)
                        break;

                    String result = new String(tmp, 0, i);

                    return result;


                }
                if (channel.isClosed()) {

                    break;
                }
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return null ;
    }
}


