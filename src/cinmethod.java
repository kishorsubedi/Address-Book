import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cinmethod {

	public static String cinmethod() //this method returns the string of what is written to the console.
	{
	    BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
	    String input = "";
		try {
	   	  input = readConsole.readLine();
	   }
	   catch(IOException e)
	   {
	       System.out.println( e );
	   }
	   return input;
	}
	
}
