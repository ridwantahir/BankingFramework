package finance.financialSys.framework.controller;

import java.util.List;
import java.util.Vector;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.IAccount;

public interface IAccountController {

	public void saveNewAccount(Account act);
	
	public void withdraw(long actNbr, double amount);
	
	public void deposit(long actNbr, double amount);
	
	public void addInterest();
	
	public Iterable<Account> getAllAccounts();
}