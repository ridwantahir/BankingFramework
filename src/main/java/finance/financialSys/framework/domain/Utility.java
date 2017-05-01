package finance.financialSys.framework.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import finance.financialSys.framework.controller.AccountController;
import finance.financialSys.framework.controller.ChangeManager;
import finance.financialSys.framework.controller.CustomerController;
import finance.financialSys.framework.controller.FinDA;
import finance.financialSys.framework.controller.IAccountController;
import finance.financialSys.framework.controller.IChangeManager;
import finance.financialSys.framework.controller.ICustomerController;
import finance.financialSys.framework.controller.IFinDA;
import finance.financialSys.framework.controller.IReportController;
import finance.financialSys.framework.controller.ReportController;

public class Utility {
	
	static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
	
	//private static ChangeManager manager = ChangeManager.ChangeManager;
	public static IChangeManager getChangeManager() {
		return ChangeManager.ChangeManager;
	}
	
//	private static IAspect aspect1 = new TransactionAspect();
//	private static IAspect aspect2 = new ReportAspect();
	
	public static IAspect getTransactionAspect()
	{
		return Aspect.transactionAspect;
	}
	public static IAspect getReportAspect()
	{
		return Aspect.reportAspect;
	}
	public static List<IAspect> getAspects() {
		return Arrays.asList(Aspect.transactionAspect, Aspect.reportAspect);
	}
	
	private static IFinDA repo = new FinDA();
	public static IFinDA getRepository() {
		return repo;
	}

	private static IAccountController actController = ctx.getBean(AccountController.class);
	public static IAccountController getAccountController() {
		return actController;
	}
	
	private static ICustomerController custController = ctx.getBean(CustomerController.class);
	public static ICustomerController getCustomerController() {
		return custController;
	}

	private static IReportController reportController = ctx.getBean(ReportController.class);
	public static IReportController getReportController() {
		return reportController;
	}


}
