package com.example.remoatecommandsexcuter.SSHConnection;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;

@NoArgsConstructor
@Service
public class RouterCommandExcuter {





    public String readFile(String path) throws IOException {
        File file =new File(path) ;
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder result = new StringBuilder();
        while ((st = br.readLine()) != null)
            result.append("\n"+st);
        return result.toString();
    }

    }


