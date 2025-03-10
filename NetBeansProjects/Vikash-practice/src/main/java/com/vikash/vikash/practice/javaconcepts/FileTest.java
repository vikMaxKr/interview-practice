package com.vikash.vikash.practice.javaconcepts;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileTest {

    public static void main(String[] args) {

      //  FileInputStream in=new FileInputStream("");
        BufferedInputStream in=null;
        FileReader reader=null;
        BufferedReader br=null;

        try {
            in = new BufferedInputStream(new FileInputStream("abc.jpg"));
            reader=new FileReader("abc.txt");
            br=new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt"), StandardCharsets.UTF_8));
            reader.read();
        }catch(Exception e)
        {
            System.out.println("catch"+e);
        }
        finally {
            try{

                assert in != null;
                in.close();
            }
            catch(Exception e)
            {
                System.out.println("exception"+e.getMessage());
            }
        }
    }
}
