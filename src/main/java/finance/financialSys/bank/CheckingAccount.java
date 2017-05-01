package finance.financialSys.bank;

import java.util.List;

import javax.persistence.Entity;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Customer;

@Entity
public class CheckingAccount extends Account {

	public CheckingAccount(Long accNumber, boolean isActive, Customer customer) {
		super(accNumber,isActive, customer);
		setInterestRate(.01);
	}
	public CheckingAccount(boolean isActive)
	{
		this.setIsActive(isActive);
		setInterestRate(.01);
	}
	public CheckingAccount()
	{
		setInterestRate(.01);
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
		String type="CH";
		String own=this.customer.getType();
		return new String[]{acNumber,accname,city,amount,own,type};

	}
	
}
