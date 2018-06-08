import java.util.HashMap;
import java.*;

//sockets
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.ObjectInputStream;

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

//import org.json.simple.*;
import weka.classifiers.*;
//import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.*;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;

public class wekaExample
{
    public static void main(String[] args) throws Exception
        {
		System.out.println("Inside main");
		//BufferedReader datafile = readDataFile("iris.arff");
 		String filename = "iris.arff";
		System.out.println("after reading data");
		Instances data = new Instances(new BufferedReader(new FileReader(filename)));
		data.setClassIndex(data.numAttributes() - 1);

		//DataSource source = new DataSource(filename);
		
		System.out.println("Data source instance success");
 		//Instances instances = source.getDataSet();
 

		//System.out.println("Raw data="+instances.toSummaryString());


		//do not use first and second
		Instance first = data.instance(0);
		Instance second = data.instance(1);
		data.delete(0);
		data.delete(1);
 
		Classifier ibk = new IBk();		
		ibk.buildClassifier(data);
 
		double class1 = ibk.classifyInstance(first);
		double class2 = ibk.classifyInstance(second);
 
		System.out.println("first: " + class1 + "\nsecond: " + class2);

	}

	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader; 
	}
}
