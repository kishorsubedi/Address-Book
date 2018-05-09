import java.util.* ;
import java.util.Formatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.util.ArrayList;


public class addressbook {
	
	private String filepath = "src/books/";
	private ArrayList<Person> listofpeople; //every address book object has a private member arraylist of person objects.
	private static Integer no_of_people = 0;
	
	addressbook(String coro, String filename)
	{
		listofpeople = null ;

			if(coro.equals("O"))
			{
				readfile(filename);
				//stream the file from filepath, make a read function to stream to a new address book.
			}
	}
	
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
	
	void readfile(String filename)
	{
		this.listofpeople = new ArrayList<Person>();
		
		BufferedReader br = null;
		try
		 {
			 File file = new File(filepath + filename);
			 br = new BufferedReader(new FileReader(file));
			 
		 	String line ;
		 	Person man = new Person();
		 	
		 	while((line = br.readLine()) != null)
		 	{
		 		man.fname = line;
		 		man.lname = br.readLine();
		 		man.address = br.readLine();
		 		man.city = br.readLine();
		 		man.state = br.readLine();
		 		man.zip = br.readLine();
		 		man.phone = br.readLine();
		 		
		 		listofpeople.add(no_of_people++, man);
		 	}
		 	
		 }
		 catch (IOException e)
		 {
			 System.out.println(e);
		 }
		 finally
		 {
			 try {
			       br.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		 }
		
		 /*
	
		Scanner x = null;
		try
		{
			x = new Scanner(new File(filepath+filename));
		}
		catch(Exception e)
		{
			System.out.println(filename + " not found");
			return;
		}
		
		while(x.hasNext())
		{
			Person man = new Person();
			man.fname = x.next();
			man.lname = x.next();
			man.address = x.next();
			man.city = x.next();
			man.state = x.next();
			man.zip = Integer.parseInt(x.next());
			man.phone = x.next();
			
			listofpeople.add(no_of_people++, man);
		}
		x.close();
		*/

	}
	
 void writetofile(ArrayList<Person> listofpeople, String fullfilepath)
	{		
		File newFile = new File(fullfilepath);
		if(newFile.exists())
		{
			System.out.println("The file already exists");
			newFile.delete() ;
			//remove tyo file
		}
		
		try {
			newFile.createNewFile();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			FileWriter fileW = new FileWriter(newFile);
			BufferedWriter buffW = new BufferedWriter(fileW);
			
			if(listofpeople != null)
			{
				for(int i=0; i< listofpeople.size(); i++)
				{
					buffW.write(listofpeople.get(i).fname + "\t");
					buffW.newLine();
					buffW.write(listofpeople.get(i).lname + "\t");
					buffW.newLine();
					buffW.write(listofpeople.get(i).address + "\t");
					buffW.newLine();
					buffW.write(listofpeople.get(i).city + "\t");
					buffW.newLine();
					buffW.write(listofpeople.get(i).state + "\t");
					buffW.newLine();
					buffW.write(listofpeople.get(i).zip + "\t");
					buffW.newLine();
					buffW.write(listofpeople.get(i).phone + "\t");
						buffW.newLine();
					}
				}
				buffW.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
 
	void addperson()
	{
		Person man = new Person();
		BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please enter person's first name\n") ;
	    	 man.fname = readConsole.readLine();
	    	 
	    	 System.out.println("Please enter person's last name\n") ;
	    	 man.lname = readConsole.readLine();
	    	 
	    	 System.out.println("Please enter person's address\n") ;
	    	 man.address = readConsole.readLine();
	    	 
	    	 System.out.println("Please enter person's city\n") ;
	    	 man.city = readConsole.readLine();
	    	 
	    	 System.out.println("Please enter person's state\n") ;
	    	 man.state = readConsole.readLine();
	    	 
	    	 System.out.println("Please enter person's zip\n") ;
	    	 man.zip = readConsole.readLine();
	    	 
	    	 System.out.println("Please enter person's phone number\n") ;
	    	 man.phone = readConsole.readLine();
	    }
	    catch(IOException e)
	    {
	        System.out.println( e );
	    }
		//person object created and populated
		
		if(this.listofpeople == null)
		{
			this.listofpeople = new ArrayList<Person>();
		}
		this.listofpeople.add(no_of_people++, man);
		
	}
	
	void deleteperson()
	{
		String firstname = "";
		System.out.println("What is the name of the person whose entry you want to DELETE?\n");
		firstname = cinmethod();
		
		for(int i=0; i<listofpeople.size(); i++)
		{
			if(listofpeople.get(i).fname.equals(firstname))
			{
				listofpeople.remove(i);
				System.out.println("Deleted successfully");
				break;
			}
		}
		System.out.println("Person with the name "+ firstname + " not found in file" );
	}
	
	void editperson()
	{
		boolean found = false;
		String firstname = "";
		int user_input = 0;
		
		String updated = "";
		int index = 0;
		
		while(found == false)
		{
			System.out.println("What is the name of the person whose entry you want to modify ?\n");
			firstname = cinmethod();
			//loop listofpeople to retrieve the index, print the object and edit it.
			for(int i=0; i<listofpeople.size(); i++)
			{
				if(listofpeople.get(i).fname.equals(firstname))
				{
					found = true;
					index = i ;
					listofpeople.get(i).printPerson();
					break;
				}
			}
			if(found ==false)
				System.out.println("You want to edit the person who is not here in this address book.");
		}
		
		System.out.println("Do you want to edit this entry's last name(1), address(2), city(3), state(4), zip(5), phone(6) ? 7 if editing is done \n");
		user_input = Integer.parseInt(cinmethod());
		
		while(user_input != 7)
		{
			switch(user_input)
			{
			case 1:
				System.out.println("What is the new last name?\n");
				updated = cinmethod();
				listofpeople.get(index).lname = updated;
				//user_input = 1;
				break ;
				
			case 2:
				System.out.println("What is the new address ?\n");
				updated = cinmethod();
				listofpeople.get(index).address = updated;
				//user_input = 2;
				break;
				
			case 3:
				System.out.println("What is the new city ?\n");
				updated = cinmethod();
				listofpeople.get(index).city = updated;
				//user_input = 3;
				break;
			
			case 4:
				System.out.println("What is the new state ?\n");
				updated = cinmethod();
				listofpeople.get(index).state = updated;
				//user_input = 4;
				break;
				
			case 5:
				System.out.println("What is the new zip ?\n");
				updated = cinmethod();
				listofpeople.get(index).zip = Integer.parseInt(updated);
				//user_input = 5;
				break;
				
			case 6:
				System.out.println("What is the new phone ?\n");
				updated = cinmethod();
				listofpeople.get(index).phone = updated;
				//user_input = 6;
				break;
			}
			System.out.println("Do you want to edit this entry's last name(1), address(2), city(3), state(4), zip(5), phone(6) ? 7 if editing is done \n");
			user_input = Integer.parseInt(cinmethod());
		}
		System.out.println("EDITING DONE");
	}
	
	void print_address_book()
	{
		System.out.println("Here are all the entries in this address book");
		for(int i=0; i< listofpeople.size(); i++)
		{
			listofpeople.get(i).printPerson();
		}
	}
	
	void saveandclose(String filename)// it gets file name as parameter. opens it and transfers arraylist to the infile.txt.
	{
		//transfer the arraylist to the txt file and is DONE!!
		
		if(this.listofpeople != null)
		{
			writetofile(listofpeople, filepath+filename);
			this.print_address_book();
		}	
	}
	
	void askingmethod(String filename)
	{
		boolean isloop = true ;
		while(isloop)
		{
			System.out.println("Do you want to add(1), edit(2), delete(3) an entry from this address book or save and close (4) ?\n");
			BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
		    int user_input = 0;
		    try {
		    	 user_input = Integer.parseInt( readConsole.readLine() );
		    }
		    catch(IOException e)
		    {
		        System.out.println( e );
		    }
		    
		    switch(user_input)
		    {
		    
		    case 1: //wants to add a new entry to the address book.
		    	this.addperson();
		    	break;
		    	
		    case 2:
		    	this.editperson();
		    	break;
		    	
		    case 3:
		    	this.deleteperson();
		    	break;
		    	
		    case 4:
		    	isloop = false;
		    	saveandclose(filename);
		    	break;
		    	
		    default:
		    	continue;
		    }
		}
	}
	
}
