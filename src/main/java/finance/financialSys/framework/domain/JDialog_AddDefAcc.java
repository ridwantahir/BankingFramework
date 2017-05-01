package finance.financialSys.framework.domain;

import java.time.LocalDate;
import java.util.Arrays;

public class JDialog_AddDefAcc extends AbstractJDialog_AddAccount
{
    private AFinFrm parentframe;
    
	public JDialog_AddDefAcc(AFinFrm parent,String[] atypes,String[]fields)
	{
		super(parent, "Add Account", atypes, fields);
		parentframe=parent;
		
	}
	
	public void createNewAccount() {
		//"Acct. No.", "Name","Street", "City","State","Zip","E-mail"
		Account act = new Account(true, null);
        Customer cust = new Person(LocalDate.now(), textFields.get("Name").getText(), textFields.get("E-mail").getText(),
        		new Address(textFields.get("Street").getText(), textFields.get("City").getText(), textFields.get("State").getText(),
        				Integer.parseInt(textFields.get("Zip").getText())), true);
        act.setCustomer(cust);
        this.setAccount(act);
	}
	
}