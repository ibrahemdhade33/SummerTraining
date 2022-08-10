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
    @Autowired
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

    public String showExcute(String type) throws InterruptedException {
     //   try {
            String output=remoteConnection.runCommand("show " + type.replaceAll("_"," "));
        System.out.println(output);

            Show sh =  (Show)factory.getCommandObject(type);

            sh.setInfo((List<ComponentsParent>) sh.getParsedCommand(output));
            showRepo.insert(sh);
            return output ;
       // }
      //  catch (Exception e){
            //return "failed to run command please log in or be shure that the command is right";
       // }
    }
    public String dirExcute(String type) {
        try {
            String output= remoteConnection.runCommand("dir " + type+"\n");
            Dir dir =  (Dir) factory.getCommandObject(type);
            dir.setInfo((List<ComponentsParent>) dir.getParsedCommand(output));
            dirRepo.insert(dir);
            return output ;
        }
        catch (Exception e){
            return "failed to run command please log in or be shure that the command is right";
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
             remoteConnection.login();
        return ResponseEntity.status(HttpStatus.OK).body("logged in");
        }
        catch (NoClassDefFoundError e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failed Authentication");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
