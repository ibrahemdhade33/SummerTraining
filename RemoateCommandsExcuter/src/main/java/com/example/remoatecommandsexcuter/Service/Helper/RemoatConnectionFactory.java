package com.example.remoatecommandsexcuter.Service.Helper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@NoArgsConstructor
public abstract class RemoatConnectionFactory {
    public RemoteConnection getRemoteConnection(String connectionType){
        if(connectionType.equals("TelNet"))
            return new RemtotConnectionUsingTelNet();
        else if(connectionType.equals("SSH"))
            return new RemoteConnectionUsingSSh();
        return null ;
    }
}
