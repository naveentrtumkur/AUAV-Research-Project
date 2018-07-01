/*

	Drone should take off from a random position (Given the seed, X,Y,Z,Gimbal positions) -- Requirement

	This is the piece of code which allows drone to take-off randomly and reach an initial position.
	A random position is formed and drone reaches that random position initially. The AutoSelfie Routine
	begins from this point onwards. */


	import java.util.*;
	import java.lang.*;
	import java.util.Random;

	public class Drone_random_takeoff
	{
		static Random rnd = new Random(40);
		public static int yield_random(int seed)
		{
			//Sets the seed value according to argument specified.
			rnd.setSeed(seed);

			//Create an int array of 20 random numbers.
			int[] rand_nos = new int[20];

			for(int i=0;i<20;i++)
			{
				rand_nos[i] = rnd.nextInt(2); //Create a random number between 0 and 1.
			}

			//Choose an index randomly between 0 and 19.
			int index = (int) (Math.random() * 20 );

			System.out.println("index="+index);

			return rand_nos[index];
		}

		public static void main(String[] args) {
			
			/*Random rnd = new Random(40);
			for(int i=0;i<15;i++)
			{
				System.out.println("first="+rnd.nextInt(2));
			}

			rnd.setSeed(195);
			for(int i=0;i<15;i++)
			{
				System.out.println("second="+rnd.nextInt(2));
			}
			//System.out.println("second="+rnd.nextInt(2));

			rnd.setSeed(15);
			for(int i=0;i<15;i++)
			{
				System.out.println("third="+rnd.nextInt(2));
			}
			//System.out.println("third="+rnd.nextInt(2)); */

			//Choose an index randomly between 0 and 19.

			/*rnd.setSeed(rnd.nextInt(50));
			//int index = rnd.nextInt(20);

			int index = (int) (Math.random() * 20 );

			System.out.println(index); */

			int x_pos = yield_random(35);
			int y_pos = yield_random(145);
			int z_pos = yield_random(236);

			System.out.println("x="+x_pos+"y="+y_pos+"z="+z_pos);

			String start_pos = Integer.toString(x_pos)+"_"+Integer.toString(y_pos)+"_"+Integer.toString(z_pos);

			System.out.println("Starting position = = = "+start_pos);


		}
	}