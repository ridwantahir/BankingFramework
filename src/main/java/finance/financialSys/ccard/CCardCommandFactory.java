package finance.financialSys.ccard;

import finance.financialSys.framework.domain.ICmdFactory;
import finance.financialSys.framework.domain.IFinCommand;

public enum CCardCommandFactory implements ICmdFactory{

	factoryInstance;
	
	@Override
	public IFinCommand getCommand(String cmdType) 
	{
		switch(cmdType) {
		case "add ccard account":
			return new AddCCardAccountCmd();
		default:
			return null;
		}
		
}
	}
