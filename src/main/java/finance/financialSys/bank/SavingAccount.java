package finance.financialSys.bank;

import java.util.List;

import javax.persistence.Entity;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Customer;

@Entity
public class SavingAccount extends Account {

	public SavingAccount(Long accNumber,  boolean isActive, Customer customer) {
		super(accNumber, isActive, customer);
		setInterestRate(.0325);
	}
	public SavingAccount(boolean isActive)
	{
		this.setIsActive(isActive);
		setInterestRate(.0325);
	}
	public SavingAccount()
	{
		setInterestRate(.0325);
	}
	@Override
	public String[] getDataMap()
	{
		 /*Long accNumber;
		 List<IEntry> entries;
		 boolean isActive;
		 ICustomer customer;*/
		String acNumber=this.accNumber+"";
		String accname=customer.getName();
		String city=customer.getAddress().getCity();
		String amount=this.amount+"";
		String type="S";
		String own=this.customer.getType();
		return new String[]{acNumber,accname,city,amount,own,type};

	}
	
}
