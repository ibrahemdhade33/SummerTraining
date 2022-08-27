package com.example.RemoteCommandsExecutor.Controller;
import com.example.RemoteCommandsExecutor.Service.Helper.DTO.Parameter;
import com.example.RemoteCommandsExecutor.Entities.Dir;
import com.example.RemoteCommandsExecutor.Entities.Show;
import com.example.RemoteCommandsExecutor.Service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/Command")
public class CommandController {
    @Autowired
    private CommandService service;

    @RequestMapping("")
    public String Home(){
        return "Hello.....";
    }
//    @RequestMapping(value = "/",method = RequestMethod.GET)
//        public List<CommandDocument> get_Commands(){
//        return service.getCommands();
//    }
//    //get all the show commands
    @RequestMapping(value = "/Show",method = RequestMethod.GET)
    public List<Show> getCommandsShow(){
        return service.getCommandsShow();
    }

    @RequestMapping(value = "/Show/{type}",method = RequestMethod.GET)
    public List<Show> getCommandsShow(@PathVariable("type") String type){
        return service.getCommandsShowType(type);
    }
    @RequestMapping(value = "/Dir",method = RequestMethod.GET)
    public List<Dir> getCommandsDir(){

        return service.getCommandsDir();
    }

    @RequestMapping(value = "/Dir/{type}")
    public List<Dir> getCommandsDir(@PathVariable("type") String type)
    {
        return service.getCommandsDirType(type) ;
    }
    @RequestMapping(value = "/Execute/Dir/{type}",method = RequestMethod.GET)
    public Object dirExcute(@PathVariable("type") String type) throws Exception {

        return service.dirExcute(type);
    }
    @RequestMapping(value = "/Execute/Show/{type}",method = RequestMethod.GET)
    public Object showExcute(@PathVariable("type") String type) throws Exception {
      return service.showExcute(type);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Parameter loginInfo) throws IOException {
        return service.login(loginInfo.getType(),loginInfo.getRemoteConnection());
    }
    @GetMapping("/DirGetByHostIp/{hostIp}")
    public List<Dir>getDirByHostIp(@PathVariable("hostIp")String hostIp){
        return service.getDirByHostIp(hostIp) ;
    }
    @GetMapping("/ShowGetByHostIp")
    public List<Show> getShowByHostIp(@PathVariable("hostIp") String hostIp){
        return service.getShowByHostIp(hostIp);
    }
}
