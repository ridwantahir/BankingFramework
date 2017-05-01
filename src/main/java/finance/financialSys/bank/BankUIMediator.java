package finance.financialSys.bank;

import java.util.List;
import finance.financialSys.framework.controller.*;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
public class BankUIMediator extends AUIMediator{

	@Override
	public String[] getColumns() {
		return new String[] {"Account Nr", "Name", "City","Amount","P/C","CH/S"};
	}

	@Override
	public Account showAcountDialog(AbstractJDialog_AddAccount dialogue) 
	{
		dialogue.show();		
		return dialogue.getAccount();
	}

}
