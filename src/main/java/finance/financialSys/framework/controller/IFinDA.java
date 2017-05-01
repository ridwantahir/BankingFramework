package finance.financialSys.framework.controller;

import java.util.List;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Customer;
import finance.financialSys.framework.domain.Entry;
import finance.financialSys.framework.domain.IAccount;

public interface IFinDA {
	public void saveNewAccount(Account act);
	public void saveNewCustomer(Customer cust);
	public void saveNewEntry(Entry entry);
	public Iterable<Customer> getAllCustomers();
	public Iterable<Account> getAllAccounts();
	public Iterable<Entry> getAllEntries();	
	public void addMoney(long accNb,double amount);
	public void deductMoney(long accNb,double amount);
	public void addInterest();
}
