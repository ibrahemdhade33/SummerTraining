package com.example.RemoteCommandsExecutor.Service.Helper.Connection;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@NoArgsConstructor
public  class RemoatConnectionFactory {
    public RemoteConnection getRemoteConnection(String connectionType){
        if(connectionType.equals("TelNet"))
            return new RemtotConnectionUsingTelNet();
        else if(connectionType.equals("SSH"))
            return new RemoteConnectionUsingSSh();
        return null ;
    }
}
