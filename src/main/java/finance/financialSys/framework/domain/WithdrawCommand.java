package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IAccountController;

public class WithdrawCommand implements IFinCommand {

	IAccountController controller = Utility.getAccountController();
	
	@Override
	public void execute(AUIMediator mediator) {
		IEntry entry = mediator.showTransactionDialog("Withdraw");
		controller.withdraw(entry.getAccount().getAccNumber(), entry.getAmount());
	}

}
