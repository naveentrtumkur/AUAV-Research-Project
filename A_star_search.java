/* 
   @Author Naveen T R
   @ Date 06/24/2018
   @ Version 1.0.0

   An Algorithm to implement A* Search for Space Exploration in order to find the Best Selfie.
   The conception of A* changes in our context:

   f(n) = g(n) + h(n)

   where g(n) is the cost to goal (Best Selfie), which should be maximum value
   		 h(n) is the heuristics (i.e Utility values) which can be obtained from KNN.


   while(!convergence)
   {
	compute g(n) and h(n)
	Keep Maximizing f(n)
   }

   return the computed f(n) value.

   */

   import java.util.*;
   import java.lang.*;


   public class A_star_search
   {
   		
   		static Double[] cur_cost = new Double[9];
   		static Double cost_g = 0.0;
   		static Double[] KNN_res = {1.33,1.2,1.02,0.87,0.67,0.45,1.21,1.3,1.11};

   		static Double[] final_fn = new Double[9];

   		// Method where astar_search happens based on
   		// the provided data.
   		public static String astar_search(Double[] cur_utility)
   		{

   			for(int i=0;i<9;i++)
   			{
   				cur_cost[i] = cost_g + cur_utility[i];
   			}

   			//Sort the cur_cost array and return the maximum cost value.
   			Arrays.sort(cur_cost);

   			System.out.println("val0="+cur_cost[0]+" val8="+cur_cost[8]);

   			//Calculate the final fn value and return the result.
   			for(int i=0;i<9;i++)
   			{
   				final_fn[i] = cur_cost[i] + KNN_res[i];
   			}

   			Arrays.sort(final_fn);
   			System.out.println("Max value = "+final_fn[8]);

   			return "lef";


   		}


   		// Main function where other methods are invoked.
   		public static void main(String[] args) {

   			Double[] cur_utility = {1.01,1.04,1.02,0.45,0.35,0.57,1.001,1.1,1.17};
   			
   			String direction = astar_search(cur_utility);

   			System.out.println("The Best direction to take: "+direction);


   		}
   }