package finance.financialSys.framework.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.AccountController;
import finance.financialSys.framework.controller.CustomerController;
import finance.financialSys.framework.controller.IAccountController;
import finance.financialSys.framework.controller.ICustomerController;
import finance.financialSys.framework.controller.ReportController;

public class AddActCommand implements IFinCommand {

	IAccountController actController = Utility.getAccountController();
	ICustomerController custController = Utility.getCustomerController();
	
	@Override
	public void execute(AUIMediator mediator) {
		String[] types=new String[]{};
		String[] fields=new String[]{"Acct. No.", "Name","Street", "City","State","Zip","E-mail","No. Employee"};
		AbstractJDialog_AddAccount dialog = new JDialog_AddDefAcc(mediator.frame,types,fields);
		Account act = mediator.showAcountDialog(dialog);
		actController.saveNewAccount(act);
		System.out.println(act);
	}

}
