package finance.financialSys.ccard;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IAccountController;
import finance.financialSys.framework.controller.ICustomerController;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.IFinCommand;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
import finance.financialSys.framework.domain.Utility;

public class AddCCardAccountCmd implements IFinCommand {

	IAccountController actController = Utility.getAccountController();
	ICustomerController custController = Utility.getCustomerController();
	
	@Override
	public void execute(AUIMediator mediator) {
		String[] types=new String[]{"Gold","Silver", "Bronze"};
		String[] fields=new String[]{"Name","Street", "City","State","Zip","E-mail","CC number", "Exp Date"};
		AbstractJDialog_AddAccount dialog = new JDialog_AddCCardAcc(mediator.frame,types,fields);
		Account act = mediator.showAcountDialog(dialog);
		actController.saveNewAccount(act);
		System.out.println(act);
	}

}
