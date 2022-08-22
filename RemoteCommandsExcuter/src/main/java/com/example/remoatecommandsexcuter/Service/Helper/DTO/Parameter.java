package com.example.remoatecommandsexcuter.Service.Helper.DTO;

import com.example.remoatecommandsexcuter.Service.Helper.Connection.RemoteConnection;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
//DTO for login parameters
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
        this.type = type ;
    }
}
