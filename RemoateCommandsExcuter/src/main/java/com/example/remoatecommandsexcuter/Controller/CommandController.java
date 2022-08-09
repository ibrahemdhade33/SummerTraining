package com.example.remoatecommandsexcuter.Controller;
import com.example.remoatecommandsexcuter.Command.CommandDocument;
import com.example.remoatecommandsexcuter.DTO.Parameter;
import com.example.remoatecommandsexcuter.Entities.Dir;
import com.example.remoatecommandsexcuter.Entities.Show;
import com.example.remoatecommandsexcuter.Service.CommandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/Command/Execute/Show/{type}",method = RequestMethod.GET)
    public Show showExcute(@PathVariable("type") String type) throws InterruptedException {
      return service.showExcute(type);
    }
    @RequestMapping(value = "/Command/Execute/Dir/{type}",method = RequestMethod.GET)
    public Dir dirExcute(@PathVariable("type") String type){
        return service.dirExcute(type);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Parameter loginInfo) throws IOException {
        System.out.println(loginInfo.toString());
        return service.login(loginInfo.getType(),loginInfo.getRemoteConnection());

    }
}
