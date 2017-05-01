package finance.financialSys.framework.controller;

import finance.financialSys.framework.domain.AFinFrm;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.IAccount;
import finance.financialSys.framework.domain.IAspect;

public interface IUIMediator {
	public void addAccount(Account act);
	public void deposit(long accNbr, double amount);
	public void withdraw(long accNbr, double amount);
	public void addInterest();
	public void generateReport();
	
	public void updateUI(IAspect aspect);
	public void setFrame(AFinFrm frame);
	public String[] getColumns();

}
