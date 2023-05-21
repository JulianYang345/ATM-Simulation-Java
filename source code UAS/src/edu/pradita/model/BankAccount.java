package edu.pradita.model;

public class BankAccount {

	public static final String ADMIN_NUMBER = "2210101019"; // REPLACE THIS WITH YOUR NIM
	public static final String ADMIN_NAME = "Julian"; // REPLACE THIS WITH YOUR NAME
	public static final String DEFAULT_PASSWORD = "1111";
	private AccountType accountType = AccountType.REGULAR;
	private String accountNumber;
	private String name;
	private String password = DEFAULT_PASSWORD;
	private String transaction1 = "";
	private String transaction2 = "";
	private String transaction3 = "";
	private double balance = 0.0;

	public void setName(String name) {
		this.name = name;
	}

	public BankAccount(String accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public BankAccount(String accountNumber, String name, AccountType accountType) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.accountType = accountType;
	}
	
	public BankAccount(String accountNumber, String name, String password) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
	}
	
	public BankAccount(String accountNumber, String name, String password, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
	
	public BankAccount(String accountNumber, String name, String password, double balance, String transaction1) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.transaction1 = transaction1;
	}
	
	public BankAccount(String accountNumber, String name, String password, double balance, String transaction1, String transaction2) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.transaction1 = transaction1;
		this.transaction2 = transaction2;
	}
	
	public BankAccount(String accountNumber, String name, String password, double balance, String transaction1, String transaction2, String transaction3) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.transaction1 = transaction1;
		this.transaction2 = transaction2;
		this.transaction3 = transaction3;
	}
	

	public double getBalance() {
		return this.balance;
	}

	public double save(double amount) {
		this.balance += amount;
		return 0;
	}

	public double withdraw(double amount) {
		this.balance -= amount;
		return 0;
	}

	public String getName() {
		return this.name;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public String toString() {
		return "{" + this.accountNumber + ", " + this.name + ", " + this.balance + "}";
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTransaction1() {
		return transaction1;
	}
	public String getTransaction2() {
		return transaction2;
	}
	public String getTransaction3() {
		return transaction3;
	}
	public void setTransaction1(String transaction1) {
		this.transaction1 = transaction1;
	}
	public void setTransaction2(String transaction2) {
		this.transaction2 = transaction2;
	}
	public void setTransaction3(String transaction3) {
		this.transaction3 = transaction3;
	}
}