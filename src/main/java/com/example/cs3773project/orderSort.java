package com.example.cs3773project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class orderSort {
    private static ArrayList<String> list = new ArrayList<String>();

    public static void main (String[] args) throws Exception{
        File file = new File("textFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while (br.readLine() != null) {
            list.add(br.readLine());
        }
    }
}
