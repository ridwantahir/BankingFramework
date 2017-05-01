package finance.financialSys.bank;

import finance.financialSys.framework.domain.ICmdFactory;
import finance.financialSys.framework.domain.IFinCommand;

public enum BankCommandFactory implements ICmdFactory{

	factoryInstance;
	
	@Override
	public IFinCommand getCommand(String cmdType) 
	{
		switch(cmdType) {
		case "add personal account":
			return new AddPersonalAccountCmd();
		case "add company account":
			return new AddCompanyAccountCmd();
		default:
			return null;
		}
		
}
	}
