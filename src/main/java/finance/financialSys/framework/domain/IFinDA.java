package finance.financialSys.framework.domain;

import java.util.List;

public interface IFinDA {

	public void getNewAccount(IAccount act);
	public void getNewCustomer(ICustomer cust);
	public List<IAccount> getAllAccounts();
	public void updateAccount(IAccount act);
	public void createNewTransaction(IEntry entry);
	
	public IAccount getAccount(long accNb);
	
	public List<IEntry> getAllEntries();
	
}
