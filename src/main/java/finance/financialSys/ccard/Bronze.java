package finance.financialSys.ccard;

import java.util.List;

import javax.persistence.Entity;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Customer;

@Entity
public class Bronze extends CCardAccount {

	public Bronze(Long accNumber, boolean isActive, Customer customer) {
		super(accNumber,isActive, customer);
		setInterestRate(.08);
	}
	public Bronze(boolean isActive)
	{
		this.setIsActive(isActive);
		setInterestRate(.08);
	}
	public Bronze()
	{
		setInterestRate(.08);
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
		String type="Bronze";
		String expDate=this.getExpiryDate();
		return new String[]{acNumber,accname,expDate, type,amount};

	}
	
}
