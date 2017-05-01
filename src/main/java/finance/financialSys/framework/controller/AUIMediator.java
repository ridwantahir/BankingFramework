package finance.financialSys.framework.controller;

import java.util.List;

import finance.financialSys.framework.domain.AFinFrm;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.CommandFactory;
import finance.financialSys.framework.domain.Entry;
import finance.financialSys.framework.domain.IAccount;
import finance.financialSys.framework.domain.IAspect;
import finance.financialSys.framework.domain.IEntry;
import finance.financialSys.framework.domain.IFinCommand;
import finance.financialSys.framework.domain.JDialogGenBill;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
import finance.financialSys.framework.domain.JDialog_Transaction;
import finance.financialSys.framework.domain.Utility;

public abstract class AUIMediator implements IUIMediator {

	CommandFactory factory = CommandFactory.cmdFactoryInstance;
	IFinCommand cmd;
	public long actNbr;
	public double amount;
	public IAccount act;
	public AFinFrm frame;

	public long getActNbr() {
		return actNbr;
	}

	public double getAmount() {
		return amount;
	}

	public IAccount getAct() {
		return act;
	}

	@Override
	public void addAccount(Account act) {
		cmd = factory.getCommand("add account");
		this.act = act;
		cmd.execute(this);
	}

	public abstract Account showAcountDialog(AbstractJDialog_AddAccount dialoge);
	
	@Override
	public void deposit(long accNbr, double amount) {
		cmd = factory.getCommand("deposit");
		this.actNbr = accNbr;
		this.amount = amount;
		cmd.execute(this);
	}

	@Override
	public void withdraw(long accNbr, double amount) {
		cmd = factory.getCommand("withdraw");
		this.actNbr = accNbr;
		this.amount = amount;
		cmd.execute(this);
	}

	@Override
	public void addInterest() {
		cmd = factory.getCommand("add interest");
		cmd.execute(this);
	}

	@Override
	public void generateReport() {
		cmd = factory.getCommand("generate report");
		cmd.execute(this);
	}

	@Override
	public void updateUI(IAspect aspect) {
		if (aspect.equals(Utility.getAspects().get(0))) {
			cmd = factory.getCommand("update ui");
			cmd.execute(this);
		}
		else if(aspect.equals(Utility.getAspects().get(1))) {
			cmd = factory.getCommand("display report");
			cmd.execute(this);
		}
	}

	@Override
	public void setFrame(AFinFrm frame) {
		this.frame = frame;
	}

	@Override
	public abstract String[] getColumns();
	
	public void repaintUI(Iterable<Account> accts) {
		String[][] rows=new String[((List<Account>)accts).size()][];
		int i=0;
		for(IAccount acc:accts)
		{
			String[] row=acc.getDataMap();
			rows[i++]=row;
		}
		frame.popuateTable(rows, this.getColumns());
	}
	public void displayReport(Iterable<Entry> entries) {
		JDialogGenBill billFrm = new JDialogGenBill(frame, entries.toString());
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	}

	public IEntry showTransactionDialog(String title) {
		int selection = frame.getJTable().getSelectedRow();
		String accnbr =  (String)frame.getJTable().getModel().getValueAt(selection, 0);
	    
		JDialog_Transaction dialog = new JDialog_Transaction(frame, accnbr, title);
		dialog.show();
		
		IEntry entry = new Entry(Double.parseDouble(dialog.getAmountDeposit()));
		entry.setAccount(new Account(Long.parseLong(accnbr)));
		return entry;
	}

}
