package finance.financialSys.bank;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IAccountController;
import finance.financialSys.framework.controller.ICustomerController;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.IFinCommand;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
import finance.financialSys.framework.domain.JDialog_AddDefAcc;
import finance.financialSys.framework.domain.Utility;

public class AddPersonalAccountCmd implements IFinCommand {

	IAccountController actController = Utility.getAccountController();
	ICustomerController custController = Utility.getCustomerController();
	
	@Override
	public void execute(AUIMediator mediator) {
		String[] types=new String[]{"Checking","Saving"};
		String[] fields=new String[]{"Acct. No.", "Name","Street", "City","State","Zip","E-mail","Date Birth"};
		AbstractJDialog_AddAccount dialog = new JDialog_AddPAcc(mediator.frame,types,fields);
		Account act = mediator.showAcountDialog(dialog);
		actController.saveNewAccount(act);
		System.out.println(act);
	}

}
