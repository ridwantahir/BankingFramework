package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;

public interface IFinCommand {
	public void execute(AUIMediator mediator);
}
