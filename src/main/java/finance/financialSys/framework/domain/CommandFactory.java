package finance.financialSys.framework.domain;

import org.springframework.beans.factory.annotation.Autowired;

import finance.financialSys.framework.controller.IAccountController;
import finance.financialSys.framework.controller.ICustomerController;
import finance.financialSys.framework.controller.IReportController;

public enum CommandFactory implements ICmdFactory {

	cmdFactoryInstance;
	
	@Autowired
	public IAccountController actController;// = Utility.getAccountController();
	@Autowired
	public ICustomerController custController;// = Utility.getCustomerController();
	@Autowired
	public IReportController reportController;// = Utility.getReportController();
	
	@Override
	public IFinCommand getCommand(String cmdType) {
		switch(cmdType) {
		case "add account":
			return new AddActCommand();
		case "withdraw":
			return new WithdrawCommand();
		case "deposit":
			return new DepositCommand();
		case "add interest":
			return new AddInterestCommand();
		case "generate report":
			return new GenerateReportCommand();
		case "update ui":
			return new UpdateUICommand();
		case "display report":
			return new DisplayReportCommand();
		case "exit":
			return new ExitCommand();
			
		}
		return null;
	}
	
	public void setAccountController(IAccountController controller) {
		this.actController = controller;
	}
	
	public void setCustomerController(ICustomerController controller) {
		this.custController = controller;
	}

	public void setReportController(IReportController controller) {
		this.reportController = controller;
	}

}
