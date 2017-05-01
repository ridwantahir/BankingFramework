package finance.financialSys.bank;
import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

import finance.financialSys.framework.domain.AFinFrm;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Address;
import finance.financialSys.framework.domain.Customer;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
import finance.financialSys.framework.domain.Organization;
import finance.financialSys.framework.domain.Person;



public class JDialog_AddCompAcc extends AbstractJDialog_AddAccount
{
    private AFinFrm parentframe;
   
	public JDialog_AddCompAcc(AFinFrm parent,String[] types,String[] fields)
	{
		super(parent, "Add Account", types,fields);
		parentframe=parent;
		
	}
	
	public void createNewAccount() {
		//"Acct. No.", "Name","Street", "City","State","Zip","E-mail"
		Account act ;
		if(Accounttype.equalsIgnoreCase("Checking"))
		{
			 act = new CheckingAccount(true);
		}
		else
		{
			act= new SavingAccount(true);
		}
		//LocalDate birthDate, String name, String email, Address address,
		//boolean isActive
		Customer persosn=new  Organization(Integer.parseInt(textFields.get("No. Employee").getText()), textFields.get("Name").getText(), textFields.get("E-mail").getText(),
				new Address (textFields.get("Street").getText(), textFields.get("City").getText(), textFields.get("State").getText(),
				Integer.parseInt(textFields.get("Zip").getText())), true);
        act.setCustomer(persosn);
        this.setAccount(act);
	}
}