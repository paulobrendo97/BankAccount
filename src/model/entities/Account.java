package model.entities;

import model.exception.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if (balance == 0.0) {
			throw new DomainException("No account balance, make a deposit!");
		}
		
		if (balance < amount) {
			throw new DomainException("The requested amount is greater than the available limit!");
		}
		
		if (withdrawLimit < amount) {
			throw new DomainException("requested amount greater than the withdraw limit");
		}
		
		balance -= amount;
	}

	@Override
	public String toString() {
		return "New balance: " + balance;
	}
	
	
	

}
