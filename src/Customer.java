/**
 * A bank customer with a checking and a savings account.
 */
public class Customer
{
	private int customerNumber;
	private int customerPin;
	private BankAccount checkingAccount;
	private BankAccount savingsAccount;
	/**
	 * Constructs a new customer with given id and pin.
	 * @param id the customer number
	 * @param pin the customer pin
	 */
	public Customer(int id, int pin)
	{
		customerNumber = id;
		customerPin = pin;
		checkingAccount = new BankAccount();
		savingsAccount = new BankAccount();
	}
	/**
	 * Validates credentials.
	 * @param aNumber user number entered
	 * @param aPin user pin entered
	 * @return user number if user credentials match
	 */
	public boolean match(int aNumber, int aPin)
	{
		return customerNumber == aNumber && customerPin == aPin;
	}
	/**
	 * Gets the balance of customers checking account.
	 * @return the checking account
	 */
	public BankAccount getCheckingAccount()
	{
		return checkingAccount;
	}
	/**
	 * Gets the balance of customers savings account.
	 * @return the savings account
	 */
	public BankAccount getSavingsAccount()
	{
		return savingsAccount;
	}
}