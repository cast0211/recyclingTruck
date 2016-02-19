package com.francisco;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader bufReader = new BufferedReader(new FileReader("recyclingreport-mainstreet-2.txt"));){

        //create empty hashmap called myList
        HashMap<String, Integer> myList = new HashMap<>();


        //read line from file
        String line = bufReader.readLine();
        //set accumulator to 0
        int highest = 0;

        while (line != null) {

            //create new stack
            Stack<Character> stack = new Stack<>();
            //iterate over characters in line and pick out the integers
            for (char ch : line.toCharArray()) {
                // if character is an integer add it to the stack
                if (ch > 47 && ch < 58) {

                    stack.push(ch);
                }
            }
            //read the next line of file
            line = bufReader.readLine();
            // create a hashmap with the corresponding house number to crate number
            if (stack.size() == 2) {
                String xx = "" + stack.get(0);
                int yy = stack.get(1);
                myList.put(xx, yy-48);

            } else if (stack.size() == 3) {

                char a = stack.get(0);
                char b = stack.get(1);
                String x = "" + a + b;

                int xy = stack.get(2);
                myList.put(x, xy-48);

            }
            //calculate highest number in hashmap
            for (String house: myList.keySet()) {

                if (myList.get(house)>highest){
                    highest = myList.get(house);

                }
            }
                //display house number with most recycling
            } for (String house: myList.keySet()){
                if (myList.get(house)== highest){

                    System.out.println("House number "+house+" had the most crates");
                }
        }
        //display the highest number of crates
        System.out.println("The highest number of crates was: "+highest);

        bufReader.close();
    }



    catch (IOException ioe){
        System.out.println("Problems with File!");
    }
    }}







