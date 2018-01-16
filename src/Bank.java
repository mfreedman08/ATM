import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
/**
 * A bank that contains customers accounts.
 */
public class Bank
{
	ArrayList<Customer> customers = new ArrayList<Customer>();
	/**
	 * Constructs a bank with no customers.
	 */
	public Bank()
	{
		customers = new ArrayList<Customer>(); 
	}
	/**
	 * Reads the customer numbers and pins from the file.
	 * @param fileName the name of file to read
	 * @throws IOException If an input or output exception occurred
	 */
	public void readCustomers(String fileName) throws IOException 
	{
		Scanner in = new Scanner(new File(fileName));
		while(in.hasNext())
		{
			int number = in.nextInt();
			int pin = in.nextInt();
			Customer c = new Customer(number, pin);
			addCustomer(c);
			
		}
		in.close();
	}
	/**
	 * Adds a customer to the bank.
	 * @param c the customer to add
	 */
	public void addCustomer(Customer c)
	{
		customers.add(c);
	}
	/**
	 * Finds a customer in a bank.
	 * @param aNumber a customer number
	 * @param aPin a customer pin
	 * @return the matching customer, or null if no customer matches
	 */
	public Customer findCustomers(int aNumber, int aPin)
	{
		for(Customer c : customers)
		{
			
			if(c.match(aNumber, aPin))
			{
				return c;
			}
		}
		return null;
	}
}