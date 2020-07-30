package bankaccountapp;

public abstract class Account implements IBaseRate {
	//List common properties for savings and checking accounts
	private String name;
	private String sSN;
	private double balance;
	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	
	//Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		index++;
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		// Set account number
		this.accountNumber = setAccountNumber();
		// call abstract methods from 
		setRate();
		
	}
	
	// Call the interface
	public abstract void setRate();
	
	//Create Account Number
	private String setAccountNumber() {
		String latTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int)(Math.random() * Math.pow(10, 3));
		return latTwoOfSSN + uniqueID + randomNumber;
	}
	
	//Create Compound Interest
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	
	//List common methods
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	// Print Information about the Users
	public void showInfo() {
		System.out.println(
				"NAME:" + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance +
				"\nRATE: " + rate + "%"
				);
	}
}
