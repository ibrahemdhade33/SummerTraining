package com.example.remoatecommandsexcuter.Service;


import com.example.remoatecommandsexcuter.Command.CommandDocument;
import com.example.remoatecommandsexcuter.Entities.Dir;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Service.Helper.CommandsMangerFactory;

import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Repositories.CommandRepo;
import com.example.remoatecommandsexcuter.Repositories.DirRepo;
import com.example.remoatecommandsexcuter.Repositories.ShowRepo;
import com.example.remoatecommandsexcuter.Service.Helper.CommandExcuterUsingSSH;
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
    private CommandExcuterUsingSSH excuter ;
    @Autowired
   private CommandsMangerFactory factory ;
    @Autowired
   private DirRepo dirRepo ;

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
        String s = excuter.readFile("/home/ibraheem/Desktop/Project/RemoateCommandsExcuter/src/main/java/com/example/remoatecommandsexcuter/Files/showIpInterfaceBrief.txt") ;
        Show sh =  (Show) factory.getCommandObject(type);
        sh.setInfo((List<ComponentsParent>) sh.getParsedCommand(s));
        showRepo.insert(sh);
        return sh ;
    }
    public Dir dirExcute(String type) throws IOException {
        String s = excuter.readFile("/home/ibraheem/Desktop/Project/RemoateCommandsExcuter/src/main/java/com/example/remoatecommandsexcuter/Files/showIpInterfaceBrief.txt") ;
        Dir dir =  (Dir) factory.getCommandObject(type);
        dir.setInfo((List<ComponentsParent>) dir.getParsedCommand(s));
        dirRepo.insert(dir);
        return dir ;
    }

}
