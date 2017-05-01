

import javax.persistence.Entity;
import javax.swing.JButton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import finance.financialSys.ccard.CCardCommandFactory;
import finance.financialSys.ccard.CCardFrm;
import finance.financialSys.ccard.CCardUIMediator;
import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.domain.AFinCo;
import finance.financialSys.framework.domain.AFinFrm;
import finance.financialSys.framework.domain.CommandFactory;
import finance.financialSys.framework.domain.IAspect;
import finance.financialSys.framework.domain.Utility;

public class CCard extends AFinCo{

	public CCard( AUIMediator mediator, AFinFrm frame) {
		super( mediator, frame);
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		AUIMediator mediator = new CCardUIMediator();
		CCardFrm frame = new CCardFrm(mediator, Utility.getChangeManager(), Utility.getAspects());
		frame.addUseCase(new JButton("New Credit Card account"), CCardCommandFactory.factoryInstance.getCommand("add ccard account"));
		
		AFinCo app = new CCard(mediator, frame);
		frame.update(Utility.getTransactionAspect());
		app.startApp();
		
	}

}
