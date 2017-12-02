package ie.lyit.hotel;
import java.io.Serializable;
import javax.swing.*;

public class Customer extends Person implements Serializable{// INHERITANCE - Customer IS-A Person
	
	//Used as a version identifier for a Serializable class
	private static final long serialVersionUID = 1;
	//Customer has an email and number
	private String emailAddress;    
	private int number;			    

	private static int nextNumber=1;// static for unique number - starts off at 1
	
	// Default Constructor
	public Customer()
	{
		super();			// NOTE:Don't need to call super() explicitly.
		//Set email to null
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;	
	
	}
	
	
	// Initialization Constructor
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
		
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return super.toString() +", "  + emailAddress +", " + number; 		//add customer number
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress(){
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber()
	{
		return number;
	}	
	
	public Name getName(){
		return name;
	}
	
	//public int getCustomerNumber() {
		//return number;
    //	}
	
	public void read()
	{
	      //Create JTextFields for adding customer information
		  JTextField txtNumber = new JTextField();
	      txtNumber.setText("" +this.getNumber());
	      //Make customer number read only
	      txtNumber.setEditable(false);
	      
	      JTextField txtTitle = new JTextField();
	      //mouse starts on the tile JTextField
	      txtTitle.requestFocus();
	      JTextField txtFirstName = new JTextField();
	      JTextField txtLastName = new JTextField();
	      JTextField txtAddress = new JTextField();
	      JTextField txtPhoneNumber = new JTextField();
	      JTextField txtEmail = new JTextField();
	   

	      Object[] message = {
    		  "Customer Number", txtNumber, 
	          "Title:", txtTitle,
	          "First Name:", txtFirstName,
	          "Last Name:", txtLastName,
	          "Address:", txtAddress,
	          "Phone Number:", txtPhoneNumber,
	          "Email:", txtEmail,
	      };

	      int option = JOptionPane.showConfirmDialog(null, message, "Enter customer details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION)
	      {

	    	  //Name consists of a title, first name and last name
	    	  setName(new Name(txtTitle.getText(), txtFirstName.getText(), txtLastName.getText()));
	          this.address = txtAddress.getText();
	          this.phoneNumber = txtPhoneNumber.getText();
	          this.emailAddress = txtEmail.getText();
	      
	      } 
	 
		}

	

	
	
	
}
