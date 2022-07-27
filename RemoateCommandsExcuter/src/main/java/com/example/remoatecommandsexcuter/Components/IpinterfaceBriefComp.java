package com.example.remoatecommandsexcuter.Components;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor @Getter @Setter
@AllArgsConstructor
public class IpinterfaceBriefComp extends ComponentsParent{

    private String InterfaceId ;
    private String Ip_Address ;
    private boolean ok;
    private String Method;
    private String Status ;
    private String Protocol ;


 }