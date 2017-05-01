package finance.financialSys.framework.domain;

import java.time.LocalDate;

public interface IEntry {
	String getDate();

	double getAmount();

	void setAmount(double amount);

	void setAccount(IAccount account);

	IAccount getAccount();
}
