package bankaccountapp;

public class Savings extends Account {
	// List properties specific to the Saving Account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	// Constructor to initialize setting for the Savings properties
	public Savings(String name,String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	// Set Rate for Savings
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
	
	// Create Safety Box
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
	}
	// List any methods specific to Savings Account
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Savings Account Features" +
		"\nSafety Deposit Box ID: " + safetyDepositBoxID +
		"\nSafety Deposit Box Key: " + safetyDepositBoxKey);
	}
}
