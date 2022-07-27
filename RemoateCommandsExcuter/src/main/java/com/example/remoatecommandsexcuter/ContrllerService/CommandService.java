package com.example.remoatecommandsexcuter.ContrllerService;

import com.example.remoatecommandsexcuter.Command.Command;
import com.example.remoatecommandsexcuter.Command.CommandDocument;
import com.example.remoatecommandsexcuter.Command.Show;
import com.example.remoatecommandsexcuter.CommandFactory.CommandsMangerFactory;
import com.example.remoatecommandsexcuter.CommandJob.IpInterfaceBrief;
import com.example.remoatecommandsexcuter.CommandJob.Types;
import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Repositories.CommandRepo;
import com.example.remoatecommandsexcuter.Repositories.ShowRepo;
import com.example.remoatecommandsexcuter.SSHConnection.RouterCommandExcuter;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RouterCommandExcuter excuter ;
    @Autowired
   private CommandsMangerFactory factory ;

    public List<CommandDocument> getCommands() {
        return commandRepo.findAll() ;
    }

    public List<Show> getCommandsShow() {
        return showRepo.findAll();
    }

    public List<Show> getCommandsShowType(String type) {
        return showRepo.getCommandeType(type);
    }



    public Show showExcute(String type) throws IOException {
        String s = excuter.readFile("/home/ibraheem/Desktop/Project/RemoateCommandsExcuter/src/main/java/com/example/remoatecommandsexcuter/Files/showStartupConfig.txt") ;
        Show sh =  (Show) factory.getCommandObject(type);
        sh.setInfo((List<ComponentsParent>) sh.getParsedCommand(s));
        showRepo.insert(sh);
        return sh ;
    }
}
