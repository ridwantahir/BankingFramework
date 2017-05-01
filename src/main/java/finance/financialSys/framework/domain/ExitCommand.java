package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;

public class ExitCommand implements IFinCommand {
	@Override
	public void execute(AUIMediator mediator) {
		//actController.attach(mediator.frame);
		System.exit(0);
	}

}
