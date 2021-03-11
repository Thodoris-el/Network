package com.example.Network;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import java.io.*;

public class CMD {
       /* public static void commandold(String outpout, String input) throws Exception {
            String com = "ogr2ogr -f \"GeoJSON\"" + outpout + input;
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", com);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        }*/
        public static void command(String output, String input){
            try {
                String com = "ogr2ogr -f \"GeoJSON\"" +" "+ output+ " " + input;
                System.out.println(com);
                String command = com;
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + command);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
