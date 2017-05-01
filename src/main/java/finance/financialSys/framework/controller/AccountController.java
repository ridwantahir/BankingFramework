package finance.financialSys.framework.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.IAspect;
import finance.financialSys.framework.domain.Observable;
import finance.financialSys.framework.domain.Utility;

@Component
public class AccountController extends Observable implements IAccountController {

	@Autowired
	IFinDA repository;	
	IAspect aspect = Utility.getTransactionAspect();

	public AccountController()
	{
		super();
		 manager = Utility.getChangeManager();
	}
	public void withdraw(long actNbr, double amount) 
	{
		repository.deductMoney(actNbr, amount);
		this.notifyObservers(aspect);
	}
	
	public void deposit(long actNbr, double amount) {
		repository.addMoney(actNbr, amount);
		this.notifyObservers(aspect);
	}
	
	public void addInterest() {
		repository.addInterest();
		this.notifyObservers(aspect);
	}
	
	@Override
	public Iterable<Account> getAllAccounts() 
	{
		return repository.getAllAccounts();
	}

	@Override
	public void saveNewAccount(Account act) {
		repository.saveNewAccount(act);
		this.notifyObservers(aspect);
	}

}
