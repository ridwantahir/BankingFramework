package finance.financialSys.framework.domain;

import java.time.LocalDate;

public interface IPerson extends ICustomer {

    public LocalDate getBirthDate();

	void setBirthDate(LocalDate birthDate);

}