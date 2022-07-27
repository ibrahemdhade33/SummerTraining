package com.example.remoatecommandsexcuter.ContrllerService;
import com.example.remoatecommandsexcuter.Command.CommandDocument;
import com.example.remoatecommandsexcuter.Command.Show;
import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CommandController {
    @Autowired
    private CommandService service;

    @RequestMapping("/")
    public String Home(){
        return "Hello....." ;
    }
    @RequestMapping(value = "/Command",method = RequestMethod.GET)
        public List<CommandDocument> get_Commands(){
        return service.getCommands();
    }
    //get all the show commands
    @RequestMapping(value = "/Command/Show",method = RequestMethod.GET)
    public List<Show> getCommandsShow(){
        return service.getCommandsShow();
    }

    @RequestMapping(value = "/Command/Show/{type}",method = RequestMethod.GET)
    public List<Show> getCommandsShow(@PathVariable("type") String type){
        return service.getCommandsShowType(type);
    }

    @RequestMapping(value = "/Command/Execute/SSH/Show/{type}",method = RequestMethod.GET)
    public Show showExcute(@PathVariable("type") String type) throws IOException {
      return service.showExcute(type);
    }
}
