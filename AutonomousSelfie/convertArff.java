import java.util.*;
import java.lang.*;
import java.io.*;

import java.io.File;
import java.nio.file.*;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//Import printWriter and JSON library.
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Date;
import java.sql.Timestamp;

// Import weka specific libraries
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class convertArff
{
    public static void main(String args[]) throws Exception
    {
	
	String file = "sample_drone_feature.txt";
	//File file = new File(filename);
	BufferedReader br = new BufferedReader(new FileReader(file));
        
	String st;
	st = br.readLine();
  	//while ((st = br.readLine()) != null)
    	//System.out.println(st);


	String[] par = st.split(",");
	for(String s :par)
	    System.out.println(s.strip("="));
  }
}	
