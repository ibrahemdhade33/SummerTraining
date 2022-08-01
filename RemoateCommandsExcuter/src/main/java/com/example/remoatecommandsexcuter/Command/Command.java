package com.example.remoatecommandsexcuter.Command;
import com.example.remoatecommandsexcuter.Components.ComponentsParent;
import com.example.remoatecommandsexcuter.Service.Helper.Parser;
import org.springframework.data.annotation.Transient;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


/*this class has the main information that we want to store for each command
*Parser that is the parent for all CommandParsing classes
* when need to parse a command in this command  we initialize it for the Appropriate Parser
*See the package commandjob to see the commands that the system provide and don't forget to see the parent for it
* when define the entities the command from the same type stores in one collection in the database for ex :
* the command show is entity and has 5 child's commands(ipInternetBrief,runningConfig,Running config,vrf,version)
*the command dir has 2 child's (boot-flash and storage)
*every child for each command has it's own parser that responsible for parsing the and get the information from it,,,please ParserStrategy package
* every type of these children have a Components defines in Components Package
*
* */
public class Command {

    @Transient
    public transient Parser commandParser;
    private LocalDateTime localDateTime;
    public List<ComponentsParent> info;
    public Command(){
        this.localDateTime = LocalDateTime.now();
    }
    @Transient
    public  Collection<ComponentsParent> getParsedCommand(String CommandOutput){
        return commandParser.parseCommand(CommandOutput);
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }



    public void setInfo(List<ComponentsParent> info) {
        this.info = info;
    }




}
