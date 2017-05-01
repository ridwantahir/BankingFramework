package finance.financialSys.ccard;

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

public class JDialog_AddCCardAcc extends AbstractJDialog_AddAccount {
	private AFinFrm parentframe;

	public JDialog_AddCCardAcc(AFinFrm parent, String[] types, String[] fields) {
		super(parent, "Add Account", types, fields);
		parentframe = parent;

	}

	public void createNewAccount() {
		// "Acct. No.", "Name","Street", "City","State","Zip","E-mail"
		CCardAccount ccAct;
		switch (Accounttype) {
		case "Gold":
			ccAct = new Gold();
			break;
		case "Bronze":
			ccAct = new Bronze();
			break;
		case "Silver":
			ccAct = new Silver();
			break;
		default:
			ccAct = null;
		}
		if (ccAct != null) {
			// LocalDate birthDate, String name, String email, Address address,
			// boolean isActive
			Customer persosn = new Customer(textFields.get("Name").getText(), textFields.get("E-mail").getText(),
					new Address(textFields.get("Street").getText(), textFields.get("City").getText(),
							textFields.get("State").getText(), Integer.parseInt(textFields.get("Zip").getText())),
					true);
			ccAct.setCustomer(persosn);
			ccAct.setExpiryDate(textFields.get("Exp Date").getText());
			this.setAccount(ccAct);
		}
	}
}