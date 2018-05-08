import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class main {
	
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
	
  public static void main(String[] args) {
    
	  
    System.out.println("What do you want to do? \n C for Create new addressbook \n O for Open new addressbook");
    String user_input = cinmethod();
    
    //sodyo ani user_input ma store vayo
    if (user_input.equals("C")){
    	System.out.println("Creating a new address book.....");
    	System.out.println("What do you like your new addressbook be called? \n");
    	
    	String filename = cinmethod();
    	addressbook book = new addressbook("C", filename);
    	book.askingmethod(filename);
    }
    else 
    	if(user_input.equals("O")){
    		System.out.println("Opening a new address book.....");
    		System.out.println("What is the file name of the address book you want to open?\n");
    		
    		String filename = cinmethod();
    		addressbook book = new addressbook("O", filename);
    		book.askingmethod(filename); 
    		
    	}
    return ;
  }
}

