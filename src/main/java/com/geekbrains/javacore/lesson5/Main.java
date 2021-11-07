package com.geekbrains.javacore.lesson5;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String args[]) throws IOException {
        String[] header;
        header = new String[3];
        header[0] = "biba";
        header[1] = "kuka";
        header[2] = "boba";
        int[][] data;
        data = new int[1][3];
        data[0][0] = 1;
        data[0][1] = 2;
        data[0][2] = 3;
        AppData baba = new AppData(header, data);

        //-------------1.
        String name = "data.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(name));
        for (int i =0 ; i<data.length+1; i++)
        {
            String [] record = baba.getRow(i);
            writer.writeNext(record);
        }
        writer.close();

       //---------------2.
        CSVReader reader = new CSVReader(new FileReader("data.csv"), ',', '"', 0);
        List<String[]> allRows = reader.readAll();
        AppData baba1 = new AppData(header, data);
        baba1.saveResult(allRows);
        for(String[] row : allRows){
            System.out.println(Arrays.toString(row));
        }
    }
}
