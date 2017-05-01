package finance.financialSys.ccard;

import javax.persistence.Entity;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Customer;

@Entity
public abstract class CCardAccount extends Account
{
	double minimumPayment;
	double lastMonthBalance;
	protected String expiryDate;
	protected double charges;
	protected double credits;
	
	public CCardAccount()
	{
	}
	public CCardAccount(long acNbr)
	{
		this.accNumber=acNbr;
	}
	public CCardAccount(long accnum,boolean isActive,Customer cus)
	{
		this.accNumber=accnum;
		this.isActive=isActive;
		this.customer=cus;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getExpiryDate() {
		return this.expiryDate;
	}
	
	public double getLastMonthBalance()
	{
		return this.amount;
	}
	
	public double getTotalMonthlyCredits()
	{
		return credits;				
	}
	
	public double getTotalMonthlyCharges()
	{
		return charges;				
	}
	
	public void computeNewMonthlyBalance()
	{
		this.amount = this.amount + credits + charges + this.interestRate*(this.amount - credits);				
	}

	public double getMonthlyAmountDue()
	{
		return minimumPayment * this.amount;				
	}
	
	@Override
	public void addInterest() {
		computeNewMonthlyBalance();
	}

}
