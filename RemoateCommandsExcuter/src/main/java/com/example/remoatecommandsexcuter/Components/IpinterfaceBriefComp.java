package com.example.remoatecommandsexcuter.Components;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
@AllArgsConstructor
public class IpinterfaceBriefComp extends ComponentsParent{

    private String interfaceId;
    private String ipAddress;
    private boolean ok;
    private String method;
    private String status;
    private String protocol;


 }