package com.example.remoatecommandsexcuter.DTO;

import com.example.remoatecommandsexcuter.Service.Helper.RemoteConnection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Parameter {
    private RemoteConnection remoteConnection ;
    private String type ;
}
