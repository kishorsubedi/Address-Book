import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

class main extends cinmethod{
	
	
  public static void main(String[] args) {
    
	String user_input ;
	
	do {
    System.out.println("What do you want to do? \n C for Create new addressbook \n O for Open new addressbook");
    user_input = cinmethod();
	}
	while(!user_input.equals("C") && !user_input.equals("O"));
	

    //sodyo ani user_input ma store vayo
    if (user_input.equals("C")){
    	
    	File f;
    	String filename;
    	do {
        	System.out.println("Creating a new address book.....");
        	System.out.println("What do you like your new addressbook be called? \n");
        	
        	filename = cinmethod();
        	f = new File("src/books/"+filename);
    	}
    	while(f.exists()==true);
    	
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

