package com.example.remoatecommandsexcuter.DTO;

import com.example.remoatecommandsexcuter.Service.Helper.RemoteConnection;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter

@NoArgsConstructor
@ToString
public class Parameter {
    @JsonProperty()
    private RemoteConnection remoteConnection ;
    private String type ;

    public Parameter(RemoteConnection remoteConnection, String type) {
        this.remoteConnection = remoteConnection;
        this.type = type;
    }
}
