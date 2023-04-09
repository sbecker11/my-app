package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify the path of the JSON file.");
            return;
        }
        String fileName = args[0];
        try {
            // Read the contents of the JSON file into a String
            String jsonContent = new String(Files.readAllBytes(Paths.get(fileName)));
            // Use the ObjectMapper class from the Jackson library to parse the JSON String into a Java object
            ObjectMapper objectMapper = new ObjectMapper();
            MyObject myObject = objectMapper.readValue(jsonContent, MyObject.class);
            // Print the contents of the Java object to the console
            System.out.println(myObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyObject {
    // Replace with the fields of your JSON object
    String field1;
    int field2;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "MyObject [field1=" + field1 + ", field2=" + field2 + "]";
    }
}
