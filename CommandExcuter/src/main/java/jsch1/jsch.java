package jsch1;
import java.io.*;
import java.util.Properties;
import com.jcraft.jsch.*;
//this code has a problem that when open more than one channel the session is closed "showing the error session is down"
public class jsch {
    public static void main(String[] args) throws JSchException, IOException, InterruptedException {
            Session session = createSession();
            //run the command here
            //every line represent a command(split every shell input with \n'supose you are writing in a real shell')
            runcommand(session,"en\n1234\n");
            
            session.disconnect();
    }
    //creating the session
public static Session createSession() throws JSchException {
        //set you machene info here
    String host = "";
    String user = "";
    String password = "";
    JSch jsch = new JSch();
    Session session = jsch.getSession(user,host, 22);
    session.setPassword(password);
    Properties config = new Properties();
    config.put("StrictHostKeyChecking", "no");
    session.setConfig(config);
    session.connect(6000);
    return session ;

}
//run the command
public static void runcommand(Session session,String Command) throws JSchException, InterruptedException, IOException {
        //create the channel for the command
        ChannelShell channel = (ChannelShell) session.openChannel("shell");
        //send the command to channel
    channel.setInputStream(new ByteArrayInputStream(Command.getBytes()));
    //define where the output should be
    channel.setOutputStream(System.out);
    channel.connect();
    //wait to return the command output
    Thread.sleep(100);
}
}
