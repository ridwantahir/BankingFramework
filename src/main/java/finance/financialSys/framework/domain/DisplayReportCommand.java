package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IReportController;

public class DisplayReportCommand implements IFinCommand {

	IReportController controller = Utility.getReportController();
	
	@Override
	public void execute(AUIMediator mediator) {
		mediator.displayReport(controller.getAllEntries());
	}
}
