package TelNet;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main
{
    private TelnetClient telnet = new TelnetClient();
    public Main(String server, String user, String password,String enablePassword) {
        try {
            // login via telnet
            telnet.connect(server, 23);
            System.out.println( readUntil1());
            write(user);
            System.out.println( readUntil1());
            write(password);
            System.out.println( readUntil1());
            //the enabled password
            write("enable");
            System.out.println(readUntil1());
            write(enablePassword);
            System.out.println(readUntil1());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String readUntil1() throws IOException {
        //for reading the output stream from telnet channel
        StringBuffer strBuffer;
        try {
            strBuffer = new StringBuffer();
            byte[] buf = new byte[1000000];
            int len = 0;
            Thread.sleep(750L);
            while ((len = telnet.getInputStream().read(buf)) != 0) {
                strBuffer.append(new String(buf, 0, len,StandardCharsets.UTF_8));
                Thread.sleep(750L);
                if (telnet.getInputStream().available() == 0)
                    break;
            }
            return strBuffer.toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return null;
    }

    public void write(String value) {
        //write the command on telnet output stream
        try {
            value+="\n";
            telnet.getOutputStream().write(value.getBytes());
            telnet.getOutputStream().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //for executing command
    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        public void disconnect() {
            try {
                telnet.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public static void main(String[] args) {
        try {
            //put the host ip and username and password and enabled password respectively
            Main telnet = new Main("", "", "","");

            for (int i = 0; i < 20; i++) {
                //scan multiple commands to execute
                Scanner scanner = new Scanner(System.in);
                String Command = scanner.nextLine();
                System.out.println(telnet.sendCommand(Command));
            }
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}