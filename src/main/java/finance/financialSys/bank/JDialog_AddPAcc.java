package finance.financialSys.bank;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

import finance.financialSys.framework.domain.AFinFrm;
import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Address;
import finance.financialSys.framework.domain.Customer;
import finance.financialSys.framework.domain.AbstractJDialog_AddAccount;
import finance.financialSys.framework.domain.Person;

public class JDialog_AddPAcc extends AbstractJDialog_AddAccount
{
    private AFinFrm parentframe;
    
	public JDialog_AddPAcc(AFinFrm parent,String[] types,String[] fields)
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
			 System.out.println("creating checking account");
		}
		else
		{
			act= new SavingAccount(true);
			System.out.println("creating saving account");
		}
		//LocalDate birthDate, String name, String email, Address address,
		//boolean isActive
		Customer persosn=new  Person(LocalDate.now(), textFields.get("Name").getText(), textFields.get("E-mail").getText(),
				new Address (textFields.get("Street").getText(), textFields.get("City").getText(), textFields.get("State").getText(),
				Integer.parseInt(textFields.get("Zip").getText())), true);
        act.setCustomer(persosn);
        this.setAccount(act);
	}
}
	