package finance.financialSys.framework.controller;

import java.util.List;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Entry;
import finance.financialSys.framework.domain.IAccount;
import finance.financialSys.framework.domain.IEntry;
import finance.financialSys.framework.domain.JDialogGenBill;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
import finance.financialSys.framework.domain.JDialog_AddDefAcc;

public class UIMediator extends AUIMediator {

	@Override
	public String[] getColumns() {
		return new String[] {"Account Nr", "Name", "City","Amount"};
	}

	@Override
	public Account showAcountDialog(AbstractJDialog_AddAccount dialogue) {
		//JDialog_AddCompAcc dialog = new JDialog_AddCompAcc(frame);
		dialogue.show();
		
		return dialogue.getAccount();
	}

}
