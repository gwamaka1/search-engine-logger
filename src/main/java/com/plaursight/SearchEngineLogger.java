package com.plaursight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    private static final DateTimeFormatter FORMATTER =  DateTimeFormatter.ofPattern("yyyyu-MM-dd HH:mm:ss");
    private static final String FILE_NAME =" logs.txt";

    public static void main(String[] args) {
       try {
           logAction("Action");
           Scanner scanner = new Scanner(System.in);
           while(true){
               System.out.println("enter a search term(X to exit):");
               String searchTerm = scanner.nextLine();
               if ("X".equalsIgnoreCase(searchTerm)) {
                   logAction("exit");
                   break;
               }
               else {
                   logAction("search : " + searchTerm);
               }
               scanner.close();
           }

       } catch (IOException e) {
           throw new RuntimeException(e);
       }


    }
    public static void logAction(String Action) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            bw.write(LocalDateTime.now().format(FORMATTER) + " " + Action);
            bw.newLine();
            bw.close();
        }
        catch(IOException e){
            System.err.println("Error writing to the log file: " + e.getMessage());
        }



    }
}
