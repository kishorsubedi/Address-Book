
import java.util.* ;
import java.util.Formatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
		// .txt file banaune
		//arraylist lai initialize gardiney
		//Add Edit Delete Save and Close options for this addressbook dine
	}
	
	void readfile(String filename)
	{
		this.listofpeople = new ArrayList<Person>();
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
			man.phone = x.next();
			
			listofpeople.add(no_of_people++, man);
		}
		x.close();
		System.out.println("File bata stream vayera listofpeople ma basyo no_of_people =" + no_of_people);
		
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
					buffW.write(listofpeople.get(i).lname + "\t");
					buffW.write(listofpeople.get(i).address + "\t");
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
		
	}
	
	void editperson()
	{
		
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
		    
		    System.out.println(user_input);
		    switch(user_input)
		    {
		    
		    case 1: //wants to add a new entry to the address book.
		    	this.addperson();
		    	break;
		    case 2:
		    	
		    case 3:
		    	
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
