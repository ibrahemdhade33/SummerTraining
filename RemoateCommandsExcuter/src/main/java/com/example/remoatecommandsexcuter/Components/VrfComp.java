package com.example.remoatecommandsexcuter.Components;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter  @NoArgsConstructor @AllArgsConstructor
public class VrfComp extends ComponentsParent {
    private List<VrfComp1> vrfComp1;
    private List<VrfComp2>vrfComp2;
}
