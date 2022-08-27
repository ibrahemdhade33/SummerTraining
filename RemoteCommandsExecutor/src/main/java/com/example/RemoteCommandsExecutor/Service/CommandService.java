package com.example.RemoteCommandsExecutor.Service;
import com.example.RemoteCommandsExecutor.Entities.CommandDocument;
import com.example.RemoteCommandsExecutor.Entities.Dir;
import com.example.RemoteCommandsExecutor.Entities.Show;
import com.example.RemoteCommandsExecutor.Service.Helper.Command.CommandsMangerFactory;
import com.example.RemoteCommandsExecutor.Repositories.CommandRepo;
import com.example.RemoteCommandsExecutor.Repositories.DirRepo;
import com.example.RemoteCommandsExecutor.Repositories.ShowRepo;
import com.example.RemoteCommandsExecutor.Service.Helper.Connection.RemoatConnectionFactory;
import com.example.RemoteCommandsExecutor.Service.Helper.Connection.RemoteConnection;
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

    public Object showExcute(String type)   {
     try {
        type = type.toLowerCase() ;
        if(type.equalsIgnoreCase("storagePartition"))
            type="?" ;
        else
            type+="\n" ;
        String output=remoteConnection.runCommand("show " + type);


            Show sh =  (Show)factory.getCommandObject(type.trim().toLowerCase().replaceAll("\n",""));

            sh.setInfo(sh.getParsedCommand(output));
            sh.setHostIp(hostIp);
            showRepo.insert(sh);

            return sh ;
             }
              catch (Exception e){
                  return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in Running Command");
             }
        }

    public Object dirExcute(String type)  {
    try {
            type = type.toLowerCase() ;
            if(type.equalsIgnoreCase("storagePartition"))
                type="?" ;
            else
                type+="\n" ;
            String output= remoteConnection.runCommand("dir " + type);
            Dir dir =  (Dir) factory.getCommandObject(type);
            dir.setInfo( dir.getParsedCommand(output));
            dir.setHostIp(hostIp);
            dirRepo.insert(dir);
            return dir ;
       }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in Running Command");
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

    public List<Dir> getDirByHostIp(String hostIp) {
        return dirRepo.getByHostIp(hostIp) ;
    }

    public List<Show> getShowByHostIp(String hostIp) {
        return showRepo.getByHostIp(hostIp) ;
    }
}
