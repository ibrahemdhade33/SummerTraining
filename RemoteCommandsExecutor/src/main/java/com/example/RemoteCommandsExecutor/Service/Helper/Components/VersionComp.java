package com.example.RemoteCommandsExecutor.Service.Helper.Components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class VersionComp extends ComponentsParent {
    private String softwareVersion ;
    private String softwareType ;
    private String softwareFamily ;
    private String systemImageFile ;
    private String hostName ;
}
