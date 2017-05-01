

import javax.swing.JButton;
import javax.swing.text.Utilities;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.UIMediator;
import finance.financialSys.framework.domain.AFinCo;
import finance.financialSys.framework.domain.AFinFrm;
import finance.financialSys.framework.domain.CommandFactory;
import finance.financialSys.framework.domain.FinFrm;
import finance.financialSys.framework.domain.Utility;

public class FinCo extends AFinCo {

	AUIMediator mediator;
	AFinFrm frame;
	
	public FinCo(AUIMediator mediator, AFinFrm frame) {
		super(mediator, frame);
	}
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		AUIMediator mediator = new UIMediator();
		FinFrm frame = new FinFrm(mediator, Utility.getChangeManager(), Utility.getAspects());
		
		frame.addUseCase(new JButton("Add Account"), CommandFactory.cmdFactoryInstance.getCommand("add account"));
		FinCo app = new FinCo(mediator, frame);
		frame.update(Utility.getTransactionAspect());
		app.startApp();
		
	}
}
