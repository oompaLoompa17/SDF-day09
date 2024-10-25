package day09;

import java.io.*;
import java.util.*;


public class App {
    public static void main(String[] args) {
        String csvFilePath = args[0];
        System.out.println(csvFilePath);
        try {
            Map<String, Customer> customerMap = parseCSV(csvFilePath);
            System.out.println(customerMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    private static Map<String, Customer> parseCSV (String filepath){
        Map<String, Customer> customerMap = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String[] headers = parseLine(br.readLine());
            System.out.println()
        }
        return null;
    }
    private static void parseLine(String value){
        List<String> values = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < value.length(); i++){
            char currentChar = value.charAt(i);
            if (currentChar == '\"'){
                insideQuotes = !insideQuotes;
            } else if (currentChar == ',' && !insideQuotes){
                values.add(currentField.toString().trim());
                currentField.setLength(0);
            } else {
                // add char to current field
                currentField.append(currentChar);
            }
        }
        values.add(currentField.toString().trim());
        
    }
}
