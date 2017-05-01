package finance.financialSys.framework.domain;

import java.util.List;
import java.util.Map;

public interface IAccount {
	Long getAccNumber();
	void deposit(double amount);

	void withdraw(double amount);


	void generateReport();

	void setAccNumber(long accNumber);

	void setIsActive(boolean isActive);

	boolean getIsActive();

	void setCustomer(Customer customer);

	void addInterest();

	ICustomer getCustomer();
	
	String getType();

	double getInterestRate();
	String[] getDataMap();
	public Entry makeEntry(double amount);
}
