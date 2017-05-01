package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IAccountController;

public class UpdateUICommand implements IFinCommand{

	IAccountController controller = Utility.getAccountController();
	
	@Override
	public void execute(AUIMediator mediator) {
		mediator.repaintUI(controller.getAllAccounts());
	}

}
