package finance.financialSys.framework.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Organization extends Customer implements IOrganization {

	public Organization(int numberOfEmployees, String name, String email, Address address,
			 boolean isActive) {
		super(name, email, address, isActive);
		this.numberOfEmployees = numberOfEmployees;
	}
	public Organization()
	{
		
	}
	private int numberOfEmployees;

	@Override
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	@Override
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public void sendEmail(IEntry entry) {
		System.out.println("Email sent to " + this.getEmail());
	}

	@Override
	public String getType() {
		return "C";
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