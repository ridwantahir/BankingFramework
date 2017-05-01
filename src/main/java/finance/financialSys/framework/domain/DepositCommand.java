package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IAccountController;

public class DepositCommand implements IFinCommand {

	IAccountController actController = Utility.getAccountController();
	
	@Override
	public void execute(AUIMediator mediator) {
		IEntry entry = mediator.showTransactionDialog("Deposit");
		actController.deposit(entry.getAccount().getAccNumber(), entry.getAmount());
	}

}
