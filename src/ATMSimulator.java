import java.io.IOException;
import java.util.Scanner;
/**
 * A text-based program of an ATM.
 */
public class ATMSimulator 
{
	private static Scanner in;

	public static void main(String[] args)
	{
		ATM theATM;
		
		try
		{
			Bank theBank = new Bank();
			theBank.readCustomers("customers.txt");
			theATM = new ATM(theBank);
		}
		catch(IOException e)
		{
			System.out.println("Error opening accounts file.");
			return;
		}
	
		in = new Scanner(System.in);
		
		boolean active = true;
		
		
		while(active)
		{
			if(theATM.getState() == -1)
			{
				System.out.print("Enter customer #: ");
				int num = in.nextInt();
				theATM.SetCustomerNumber(num);
				System.out.println("Enter PIN #: ");
				int pin = in.nextInt();
				theATM.SelectCustomer(pin);
			}
				if(theATM.getState() == 1)
				{
					
					System.out.println("CHECKING (1) / SAVINGS (2) / EXIT (0):");
					int accountType = in.nextInt();
					
					if(accountType != 0 && accountType != 1 && accountType != 2)
					{
						System.out.println("Please try again.");
					}
						if(accountType == 1)
						{
							theATM.SelectAccount(accountType);
							System.out.println("WITHDRAW (1) / DEPOSIT (2):"); 
							int selection = in.nextInt();
					
							if(selection == 2)
							{
								System.out.println("Please enter amount: ");
								double amount = in.nextDouble();
								theATM.Deposit(amount);
							}
						else if(selection == 1)
							{
								System.out.println("Please enter amount: ");
								double amount = in.nextDouble();
								theATM.Withdraw(amount);
							}
						}
						else if(accountType == 2)
						{
							theATM.SelectAccount(accountType);
							theATM.SelectAccount(accountType);
							System.out.println("DEPOSIT (1) / WITHDRAW (2) "); 
							int selection = in.nextInt();
					
							if(selection == 1)
							{
								System.out.println("Please enter amount: ");
								double amount = in.nextDouble();
								theATM.Deposit(amount);
							}
							else if(selection == 2)
							{
								System.out.println("Please enter amount: ");
								double amount = in.nextDouble();
								theATM.Withdraw(amount);
							}
						}
							else if(accountType == 0)
							{
								active = false;
								System.exit(0);
							}
				}
		}
	} 
}	