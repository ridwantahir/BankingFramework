package finance.financialSys.framework.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Person extends Customer implements IPerson {
	
	public Person(LocalDate birthDate, String name, String email, Address address,
			boolean isActive) {
		super(name, email, address, isActive);
		
	}
	public Person()
	{
		
	}
    private LocalDate birthDate;

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

	@Override
	public void sendEmail(IEntry entry) {
		
	}

	@Override
	public String getType() {
		return "P";
	}

	@Override
	public void addAccount(IAccount account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IAccount> getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddress(IAddress address) {
		// TODO Auto-generated method stub
		
	}
	

}