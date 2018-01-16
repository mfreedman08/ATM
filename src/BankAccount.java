/**
 * A bank account has a customers checking and savings accounts.
 */
public class BankAccount 
{
	private double balance;
	/**
	 * Constructs a empty bank account.
	 */
	public BankAccount() 
	{
		balance = 0.0;
	}
	/**
	 * Withdraws from customers account.
	 * @param value the amount to withdraw
	 */
	public void withdraw(double value)
	{
		balance = balance - value;
	}
	/**
	 * Deposits to customers account.
	 * @param value the amount to deposit
	 */
	public void deposit(double value)
	{
		balance = balance + value;
	}
	/**
	 * Gets customers account balance.
	 * @return balance the amount in customer account
	 */
	public double getBalance()
	{
		return balance;
	}	
}