package com.example.remoatecommandsexcuter.Entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import java.util.Map;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("SnmpInterfaces")
@ToString
public class SnmpInterfaces {
    private String hostIp;
    private Map<String,String> oidValue;
    private LocalDateTime localDateTime;
}
