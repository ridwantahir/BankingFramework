package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IReportController;

public class GenerateReportCommand implements IFinCommand {

	IReportController controller = Utility.getReportController();
	
	@Override
	public void execute(AUIMediator mediator) {
		controller.generateReport();
	}

}
