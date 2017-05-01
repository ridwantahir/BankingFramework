package finance.financialSys.ccard;

import java.util.List;

import javax.persistence.Entity;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Customer;

@Entity
public class Silver extends CCardAccount {

	public Silver(Long accNumber,  boolean isActive, Customer customer) {
		super(accNumber, isActive, customer);
		setInterestRate(.06);
	}
	public Silver(boolean isActive)
	{
		this.setIsActive(isActive);
		setInterestRate(.06);
	}
	public Silver()
	{
		setInterestRate(.06);
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
		String amount=this.amount+"";
		String type="Silver";
		String expDate=this.getExpiryDate();
		return new String[]{acNumber,accname,expDate, type,amount};

	}
	
}
