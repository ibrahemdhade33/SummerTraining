package jsh1;
import java.io.*;
import java.util.Properties;
import com.jcraft.jsch.*;
public class jsch {
    public static void main(String[] args) throws JSchException, IOException, InterruptedException {
            Session session = createSession();
            runcommand(session,"en\n1234\n");
            runcommand(session,"sh run\n");
            session.disconnect();
    }
public static Session createSession() throws JSchException {

    String host = "192.168.203.174";
    String user = "ibraheem";
    String password = "24122001";
    JSch jsch = new JSch();
    Session session = jsch.getSession(user,host, 22);
    session.setPassword(password);
    Properties config = new Properties();
    config.put("StrictHostKeyChecking", "no");
    session.setConfig(config);
    session.connect(6000);
    return session ;

}
public static void runcommand(Session session,String Command) throws JSchException, InterruptedException, IOException {

        ChannelShell channel = (ChannelShell) session.openChannel("shell");
    channel.setInputStream(new ByteArrayInputStream(Command.getBytes()));
    channel.setOutputStream(System.out);
    channel.connect();
    Thread.sleep(100);
}
}