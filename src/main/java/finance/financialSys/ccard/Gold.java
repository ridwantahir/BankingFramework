package finance.financialSys.ccard;

import java.util.List;

import javax.persistence.Entity;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Customer;

@Entity
public class Gold extends CCardAccount {

	public Gold(Long accNumber,  boolean isActive, Customer customer) {
		super(accNumber, isActive, customer);
		setInterestRate(.1);
	}
	public Gold(boolean isActive)
	{
		this.setIsActive(isActive);
		setInterestRate(.1);
	}
	public Gold() {
		setInterestRate(.1);
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
		String type="Gold";
		String expDate=this.getExpiryDate();
		return new String[]{acNumber, accname,expDate, type,amount};

	}
	
}
