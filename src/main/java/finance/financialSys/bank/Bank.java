package finance.financialSys.bank;

import javax.swing.JButton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.domain.AFinCo;
import finance.financialSys.framework.domain.AFinFrm;
import finance.financialSys.framework.domain.CommandFactory;
import finance.financialSys.framework.domain.IAspect;
import finance.financialSys.framework.domain.Utility;

public class Bank extends AFinCo{

	public Bank( AUIMediator mediator, AFinFrm frame) {
		super( mediator, frame);
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("srccontext.xml");
		AUIMediator mediator = new BankUIMediator();
		BankFrm frame = new BankFrm(mediator, Utility.getChangeManager(), Utility.getAspects());
		frame.addUseCase(new JButton("New personal account"), BankCommandFactory.factoryInstance.getCommand("add personal account"));
		frame.addUseCase(new JButton("New Company account"), BankCommandFactory.factoryInstance.getCommand("add company account"));
		
		AFinCo app = new Bank(mediator, frame);
		frame.update(Utility.getTransactionAspect());
		app.startApp();
		
	}

}
