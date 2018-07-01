import java.util.*;

public class Sample_test
{
	public static void main(String[] args) {
		
		String cur_str = "1_1_1";

		//string nstr 
		
                int val =  (cur_str.charAt(4) - '0') + 1 ;
                cur_str =  cur_str.substring(0,4) + Integer.toString(val) ;
                System.out.println("In fwd="+cur_str);
		System.out.println(val);
	}
}