package com.example.remoatecommandsexcuter.Service;
import com.example.remoatecommandsexcuter.Command.CommandDocument;
import com.example.remoatecommandsexcuter.Entities.Dir;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Service.Helper.CommandsMangerFactory;
import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Repositories.CommandRepo;
import com.example.remoatecommandsexcuter.Repositories.DirRepo;
import com.example.remoatecommandsexcuter.Repositories.ShowRepo;
import com.example.remoatecommandsexcuter.Service.Helper.RemoatConnectionFactory;
import com.example.remoatecommandsexcuter.Service.Helper.RemoteConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class CommandService {
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private CommandRepo commandRepo ;

    @Autowired
   private CommandsMangerFactory factory ;
    RemoteConnection remoteConnection ;
    @Autowired
   private DirRepo dirRepo ;
    @Autowired
    private RemoatConnectionFactory remoatConnectionFactory ;
    public List<CommandDocument> getCommands() {
        return commandRepo.findAll() ;
    }

    public List<Show> getCommandsShow() {
        return showRepo.findAll();
    }

    public List<Show> getCommandsShowType(String type) {
        return showRepo.getCommandeType(type);
    }

    public Show showExcute(String type)  {
        String s=remoteConnection.runCommand("show " + type+"\n");
        Show sh =  (Show)factory.getCommandObject(type);
        sh.setInfo((List<ComponentsParent>) sh.getParsedCommand(s));
        showRepo.insert(sh);
        return sh ;
    }
    public Dir dirExcute(String type) {
        try {
            String outPut= remoteConnection.runCommand("dir " + type+"\n");
            Dir dir =  (Dir) factory.getCommandObject(type);
            dir.setInfo((List<ComponentsParent>) dir.getParsedCommand(outPut));
            dirRepo.insert(dir);
            return dir ;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null ;
    }
    public ResponseEntity<String> login(String type, RemoteConnection connectionInfo) throws IOException {
        try{
             remoteConnection = remoatConnectionFactory.getRemoteConnection(type);
             remoteConnection.setPort(connectionInfo.getPort());
             remoteConnection.setHost(connectionInfo.getHost());
             remoteConnection.setPassword(connectionInfo.getPassword());
             remoteConnection.setEnablePassword(connectionInfo.getEnablePassword());
             remoteConnection.setUserName(connectionInfo.getUserName());
             remoteConnection.login();
        return ResponseEntity.status(HttpStatus.OK).body("logged in");
        }
        catch (NoClassDefFoundError e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failed Authentication");
        }
    }

}
