package com.example.remoatecommandsexcuter.Service;
import com.example.remoatecommandsexcuter.Entities.CommandDocument;
import com.example.remoatecommandsexcuter.Entities.Dir;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Service.Helper.Command.CommandsMangerFactory;
import com.example.remoatecommandsexcuter.Service.Helper.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Repositories.CommandRepo;
import com.example.remoatecommandsexcuter.Repositories.DirRepo;
import com.example.remoatecommandsexcuter.Repositories.ShowRepo;
import com.example.remoatecommandsexcuter.Service.Helper.Connection.RemoatConnectionFactory;
import com.example.remoatecommandsexcuter.Service.Helper.Connection.RemoteConnection;
import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
//implement all business logic for commands
@Service
public class CommandService {
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private CommandRepo commandRepo ;
    @Autowired
   private CommandsMangerFactory factory ;
    @Autowired
    RemoteConnection remoteConnection ;
    @Autowired
   private DirRepo dirRepo ;
    @Autowired
    private RemoatConnectionFactory remoatConnectionFactory ;
    private String hostIp ;
    public List<CommandDocument> getCommands() {
        return commandRepo.findAll() ;
    }

    public List<Show> getCommandsShow() {
        return showRepo.findAll();
    }

    public List<Show> getCommandsShowType(String type) {
        return showRepo.getCommandeType(type);
    }

    public String showExcute(String type) {
     try {
            String output=remoteConnection.runCommand("show " + type);


            Show sh =  (Show)factory.getCommandObject(type);

            sh.setInfo((List<ComponentsParent>) sh.getParsedCommand(output));
            sh.setHostIp(hostIp);
            showRepo.insert(sh);

            return output ;
             }
              catch (Exception e){
            return "failed to run command please log in or be sure that the command is right";
             }
        }

    public String dirExcute(String type){
        try {
            String output= remoteConnection.runCommand("dir " + type);
            Dir dir =  (Dir) factory.getCommandObject(type);
            dir.setInfo((List<ComponentsParent>) dir.getParsedCommand(output));
            dir.setHostIp(hostIp);
            dirRepo.insert(dir);

            return output ;
        }
        catch (Exception e){
            return "failed to run command please log in or be sure that the command is right";
        }

    }
    public ResponseEntity<String> login(String type, RemoteConnection connectionInfo) throws IOException {
        try{
             remoteConnection = remoatConnectionFactory.getRemoteConnection(type);
             remoteConnection.setPort(connectionInfo.getPort());
             remoteConnection.setHost(connectionInfo.getHost());
             remoteConnection.setPassword(connectionInfo.getPassword());
             remoteConnection.setEnablePassword(connectionInfo.getEnablePassword());
             remoteConnection.setUserName(connectionInfo.getUserName());
             hostIp = remoteConnection.getHost();
             remoteConnection.login();
        return ResponseEntity.status(HttpStatus.OK).body("logged in");
        }
        catch (NoClassDefFoundError e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failed Authentication");
        } catch (InterruptedException | JSchException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Dir> getCommandsDir() {
        return dirRepo.findAll();
    }

    public List<Dir> getCommandsDirType(String type) {
        return dirRepo.getCommandeType(type) ;
    }
}
