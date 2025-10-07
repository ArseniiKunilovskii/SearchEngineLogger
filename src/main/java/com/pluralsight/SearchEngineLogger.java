package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        try {
            boolean done = false;

            Scanner in = new Scanner(System.in);
            FileWriter fileWriter = null;

            fileWriter = new FileWriter("logs.txt");

            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime date = LocalDateTime.now();

            System.out.println("Hello user! Welcome to browser.");

            bufWriter.write(date.format(formatter) + " launch \n");
            while(!done){
                    System.out.println("Please enter you search request (X to exit):");
                    String input = in.nextLine();
                    if(input.equalsIgnoreCase("X")){
                        done = true;
                        System.out.println("Thank you for using this service");
                        bufWriter.write(date.format(formatter) + " exit\n");
                    }
                    else {
                        System.out.println("Results of the search: " + input);
                        bufWriter.write(date.format(formatter) + " search : " + input +"\n");
                    }
            }
            bufWriter.close();
        } catch (Exception e){
            System.out.println("Something went worng");
        }

    }
}
