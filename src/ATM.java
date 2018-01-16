/**
 * An ATM that accesses a bank
 */
public class ATM 
{
	private int customerNumber;
	private Customer currentCustomer;
	private BankAccount currentAccount;
	private Bank theBank;
	private int currentState = -1;
	
	/**
	 * Constructs an ATM for a given bank.
	 * @param aBank the bank that connects to the ATM
	 */
	public ATM(Bank aBank)
	{
		theBank = aBank;
	}
	/**
	 * Sets the current customer number.
	 * @param number the customer number
	 */
	public void SetCustomerNumber(int number)
	{
		customerNumber = number;
	}
	/**
	 * Finds current customer in bank.
	 * @param pin the customer pin
	 */
	public void SelectCustomer(int pin)
	{
		currentCustomer = theBank.findCustomers(customerNumber, pin);
		if(currentCustomer == null)
		{
			
			System.out.println("User not found or password is incorrect, " + 
								"please try again.");
		} 
		else if(currentCustomer != null)
		{
			currentState = 1;
		}
		
	}
	/**
	 * Sets current bank account to checking or savings.
	 * @param account the checking or savings account
	 */
	public void SelectAccount(int account)
	{
		if(account == 1)
		{
			currentAccount = currentCustomer.getCheckingAccount();
		}
		else if(account == 2)
		{
			currentAccount = currentCustomer.getSavingsAccount();
		}
		
	}
	/**
	 * Withdraws amount from selected account.
	 * @param value the amount to withdraw
	 */
	public void Withdraw(double value)
	{
		currentAccount.withdraw(value);
	}
	/**
	 * Deposits the amount to selected account.
	 * @param value the amount to deposit
	 */
	public void Deposit(double value)
	{
		currentAccount.deposit(value);
	}
	/**
	 * Gets the balance of the selected account.
	 * @return the current balance
	 */
	public double getBalace()
	{
		return currentAccount.getBalance();
	}
	public int getState()
	{
		return currentState;
	}
	
}