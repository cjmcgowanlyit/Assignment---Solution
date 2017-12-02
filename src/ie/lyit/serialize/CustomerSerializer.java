package ie.lyit.serialize;

import java.util.ArrayList;
import ie.lyit.hotel.Customer;
import java.io.*;
import java.util.*;

public class CustomerSerializer 
{
	//Create an arraylist of customers
	private ArrayList<Customer> customers;
	
	//create a filename called customers.ser
	private final String FILENAME = "customers.ser";
	
	//DEFAULT CONSTRUCTOR
	public CustomerSerializer()
	{
		//Construct CustomerList ArrayList
		customers = new ArrayList<Customer>();
		
	}
	
	public void add()
	{
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();
		// And add it to the customers ArrayList
		
		customers.add(customer);
	}
	
	public Customer view(){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);		

		// Read in the customer number from the user
		System.out.println("ENTER CUSTOMER NUMBER : ");
		int customerToView=keyboard.nextInt();
			
		
		// for every Customer object in customers
	    for(Customer tmpCustomer:customers)
	    {
	    	// if it's number equals the number of the customerToView
	    	if(tmpCustomer.getNumber() == customerToView)
		   {
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    // if we reach this code the book was not found so return null
	    return null;
	}
	
	
	
	public void delete()
	{
		
		// Call view() to find, display, & return the customer to delete
				Customer tempCustomer = view();
				// If the customer != null, i.e. it was found then...
			    if(tempCustomer != null)
				   // ...remove it from customers
			       customers.remove(tempCustomer);
			    //Display that it has been deleted
			    System.out.println("Customer " +tempCustomer + " has been deleted ");
			    
		
	}
	
	public void edit()
	{
	
		// Call view() to find, display, & return the customer to edit
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
	    if(tempCustomer != null){
		   // get it's index
		   int index=customers.indexOf(tempCustomer);
		   // read in a new customer and...
		   tempCustomer.read();
		   // reset the object in customers
		   customers.set(index, tempCustomer);
		   //Display that it has been edited
		   System.out.print(tempCustomer +" Customers have been edited ");
	    }
		
	}
	
	public void list(){
		// for every Customer object in customers
        for(Customer tmpCustomer:customers)
			// display it
			System.out.println(tmpCustomer);
	}
	
	// This method will serialize the customers ArrayList when called, 
		// i.e. it will write it to a file called customers.ser
		public void writeRecordsToFile(){
			ObjectOutputStream os = null;
			try {
				// Serialize the ArrayList...
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
				os = new ObjectOutputStream(fileStream);
					
				os.writeObject(customers);
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store customers.");
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			finally {
				try {
					os.close();
				}
				catch(IOException ioE){
					System.out.println(ioE.getMessage());
				}
			}
		}
		
		// This method will deserialize the books ArrayList when called, 
		// i.e. it will restore the ArrayList from the file customers.ser
		@SuppressWarnings("unchecked")
		public void readRecordsFromFile(){
			ObjectInputStream is=null;
			
			try {
				// Deserialize the ArrayList...
				FileInputStream fileStream = new FileInputStream(FILENAME);
			
				 is = new ObjectInputStream(fileStream);
					
							
					
				customers = (ArrayList<Customer>)is.readObject();	
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store books.");
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			finally {
				try {
					is.close();
				}
				catch(IOException ioE){
					System.out.println(ioE.getMessage());
				}
			}
		
		}
	
}
