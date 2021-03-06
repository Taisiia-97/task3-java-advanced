package files;

import java.io.*;

public class InputReaderDemo {
    public static void main(String[] args) {

        try(
            BufferedReader reader = new BufferedReader(new FileReader("c:\\data\\data.txt"))) {
            while (reader.readLine()!=null){

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}

