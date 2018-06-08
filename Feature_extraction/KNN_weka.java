/*  @Naveen T R
    June 7th 2018
    Implementation of KNN (K nearest neighbors) to find the k-nearest neighbors to choose from.
    
    In our context near would mean nearest matching features as to current position's features.
    
    Steps followed in this process are:-
    1. Compile featureSet which would be for every image in every cube.
    2. Drone takes off and an image is taken.
    3. Read-in the image taken and extract the current X-Y-Z position.
    4. Find the closest possible positions drone could move to from current position.
    5. Then for each of the possible positions:
          do 
          {
            Find the K-nearest neighbors
            Average their utility
           }
    6. Return the position where max of utility could be achieved.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

//Import libraries for file-handling
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
 
//Import librarries for weka classification
import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;

public class KNN_weka
{
	 //Declaration of global variables.
	static  List<List<Integer>> possibilities = new ArrayList<>();
	 public static void findOneHopNeighbors(String current)
	{
	    //ArrayList<ArrayList<Integer>> possibilities = new ArrayList<>(); // Maintains a list of possible neighbors.
	    //Extract X-axis, Y-axis and Z-axis co-ordinates from the current position.
	    List<Integer> Pos = new ArrayList<>();
	    String[] axis = current.split(",");
	    for(String i:axis)
	    {
		Pos.add(Integer.valueOf(i));
		//System.out.println(i);
	    }
	    for(int i=0;i <Pos.size();i++)
	    {
		System.out.println(Pos.get(i));
	    }
	    // Get the current X-Y-Z co-ordinates.
	    int X = Pos.get(0);
	    int Y = Pos.get(1);
	    int Z = Pos.get(2);
	    System.out.println("x="+X+", y="+Y+",z="+Z);
	    
	    // Try to add every possible nearest position to list.
	    for(int i=0;i<3;i++) //Loop for six times.
	    {
		if(i==0)
		{
		   List<Integer> temp = new ArrayList<>();
		   int temp_X = X;
		   if(temp_X +1 < 2)
		   {
		       temp.add(temp_X+1);
		       temp.add(Y);
		       temp.add(Z);
		       possibilities.add(temp);
		   }
		   temp = new ArrayList<>();
		   if (temp_X -1 >=0)
		   { 
		       temp.add(temp_X-1);
		       temp.add(Y);
		       temp.add(Z);
		       possibilities.add(temp);
		   }
		}
		else if(i ==1)
		{
		    List<Integer> temp = new ArrayList<>();
		    int temp_Y = Y;
		    if(temp_Y +1 < 3)
                    {
		       temp.add(X);
		       temp.add(temp_Y+1);
		       temp.add(Z);
		       possibilities.add(temp);
		}
		temp = new ArrayList<>();
                   if (temp_Y -1 >=0)
                   {
		       temp.add(X);
		       temp.add(temp_Y-1);
		       temp.add(Z);
		       possibilities.add(temp);
		    }
		}
		else
		{
		    List<Integer> temp = new ArrayList<>();
		    int temp_Z = Z;
		    if(temp_Z +1 < 2)
                    {
		       temp.add(X);
		       temp.add(Y);
		       temp.add(temp_Z+1);
		       possibilities.add(temp);
		    }
		   temp = new ArrayList<>();
                   if (temp_Z -1 >=0)
                   {
		       temp.add(X);
		       temp.add(Y);
		       temp.add(temp_Z);
		       possibilities.add(temp);
		   }
		}
	    }
	    
	    for(List<Integer> list:possibilities)
		System.out.println(list);
	    //System.out.println(current.split(","));
	    //System.out.println( Integer.valueOf(current.split(",")));
	    //System.out.pritnln(Pos[0]+Pos[1]+Pos[2]);
	    //return possibilities;
	 }
    
   /* This function uses weka's K-Nearest neighbors to find the K-Nearest neighbor values and return the average of utilities of those values.
      The X-Y-Z co-ordiantes of nearest one hop is passed as the input and we will get average utility value (A double value)
    */
    public static Double KNN_avg_utility(List<Integer> points)
    {
      
	Double avg_utility = 0.0; //Initialize the average utility value to zero.
        //BufferedReader raw_data = readDataFile("./DLIBFeatureset"); #Read the featureset from the file.
	//Instances instances = new Instances(raw_data); //Construct instances from data i.e this is what weka requires.
	
	//System.println("Data=\n"+instances);
	List<Double> list_utility = Arrays.asList(5.5, 4.5, 6.0, 3.3, 2.0); // This is the result which we will get after implementing the KNN algorithm.
	
	for(Double d:list_utility)
	    avg_utility += d;

	avg_utility =  avg_utility/list_utility.size();

	System.out.println("Average==="+avg_utility);

	return avg_utility;
	 
    }


    public static void main(String args[])
    {
	try{
        System.out.println("Inside main function");
        System.out.println("Drone is taking off and an image is captured");

        // drone_capture() This function can be written later. Right now I'm reading an image.
	ProcessBuilder pb = new ProcessBuilder("python3"," /Users/naveentr/Drone_codebase/external/python/3dPosition/3D_Coordinates.py"," "+"SelfieCube22_Up_s.JPG");
        //String Image = (args[0]);
	//System.out.println("img name="+Image);
	Process p = pb.start();
	//System.out.println("pb="+pb); 
	BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	//String ret = new String(in.readLine());
	//System.out.println("value is : "+ret);

	List<String> possible = new ArrayList<>(); // Create a list of possible movements possible from the current Drone position.
        findOneHopNeighbors("1,0,1"); //ret would hold the current position of drone.

	List<Integer> list = new ArrayList<>();
	list.add(1);
	list.add(2);
	list.add(0);
	
	//Double val = KNN_avg_utility(list); This is working fine.

	
	 //For each of the nearest hop, calculate K-Nearest neighbor using weka's API.
	// Average the utility of K-NN at every point and return the highest average-utility.
	int len = possibilities.size();
	Map<List<Integer>, Double> max_avg = new HashMap<>();

	for(int i=0;i<len;i++)
	{
	    List<Integer> hop_list = possibilities.get(i);
	    Double val = KNN_avg_utility(hop_list);
	    max_avg.put(hop_list,val);
	}

	//Now we need to return the utility and position to choose from current position.
	// Iterate through the HashMap and return the List value(i.e next X-Y-Z co-ordinates with maximum utility

	Double maxVal = Double.MIN_VALUE; //Initialize max value with minimum possible value
	List<Integer> maxBenefit = new ArrayList<>();
	for(Map.Entry<List<Integer>, Double> entry: max_avg.entrySet())
	{
	    List<Integer> list1 = entry.getKey();
	    Double curVal = entry.getValue();
	    
	    if(curVal > maxVal)
	    {
		maxVal = curVal;
		maxBenefit = new ArrayList<>(list1);
	    }    
	}
	
	System.out.println("Best Selfie achieved when you move to X-Y-Z=("+maxBenefit.get(0)+","+maxBenefit.get(1)+","+maxBenefit.get(2)+")");
	}

        catch(Exception e){
            e.printStackTrace();
        }

	}

}  
