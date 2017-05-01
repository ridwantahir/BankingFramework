package finance.financialSys.ccard;

import java.util.List;
import finance.financialSys.framework.controller.*;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
public class CCardUIMediator extends AUIMediator{

	@Override
	public String[] getColumns() {
		return new String[] {"CC Number", "Name", "Exp Date", "Type","Balance"};
	}

	@Override
	public Account showAcountDialog(AbstractJDialog_AddAccount dialogue) 
	{
		dialogue.show();		
		return dialogue.getAccount();
	}

}
