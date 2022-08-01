package com.example.remoatecommandsexcuter.Service.Helper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;

@NoArgsConstructor
@Service
public class CommandExcuterUsingSSH {

    public String readFile(String path) throws IOException {
        File file =new File(path) ;
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder result = new StringBuilder();
        while ((st = br.readLine()) != null)
            result.append("\n").append(st);
        return result.toString();
    }

    }


