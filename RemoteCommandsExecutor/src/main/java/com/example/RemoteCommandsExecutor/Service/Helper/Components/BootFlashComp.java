package com.example.RemoteCommandsExecutor.Service.Helper.Components;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BootFlashComp extends ComponentsParent {
    private String permission ;
    private Long Size;
    private String dateTime;
    private String fileName ;
}
