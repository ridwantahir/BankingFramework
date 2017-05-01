package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IAccountController;

public class AddInterestCommand implements IFinCommand {

	IAccountController actController = Utility.getAccountController();
	
	@Override
	public void execute(AUIMediator mediator) {
		actController.addInterest();
	}

}
