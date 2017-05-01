package finance.financialSys.framework.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance
public class Customer implements ICustomer {
	
	public Customer(String name, String email, Address address, boolean isActive) {
		this.name = name;
		this.email = email;
		this.address = address;
		//this.accounts = accounts != null ? accounts : new ArrayList<Account>();
		this.isActive = isActive;
	}
	public Customer()
	{
		
	}
	@Id @GeneratedValue
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private int custNumber;
    private String name;
    private String email;
    @OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
    private Address address;
    /*@OneToMany(targetEntity=Account.class, mappedBy="customer",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Account> accounts;*/
    private boolean isActive;
    
    @Override
    public void setCustNumber(int custNumber) {
    	this.custNumber = custNumber;
    }
    
    @Override
    public int getCustNumber() {
    	return custNumber;
    }
/*
    @Override
	public void addAccount(Account account) {
    	accounts.add(account);
    }*/

    @Override
	public void setIsActive(boolean isActive) {
    	this.isActive = isActive;
    }
    
    @Override
    public boolean getIsActive() {
    	return isActive;
    }
    
   /* @Override
	public List<Account> getAccountList() {
        return accounts;
    }*/

    @Override
	public String getName() {
        return name;
    }

    @Override
	public void setName(String name) {
        this.name = name;
    }

    @Override
	public String getEmail() {
        return email;
    }

    @Override
	public void setEmail(String email) {
        this.email = email;
    }

    @Override
	public IAddress getAddress() {
        return address;
    }

    @Override
	public void setAddress(Address address) {
        this.address = address;
    }
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custNumber=" + custNumber + ", name=" + name + ", email=" + email
				+ ", address=" + address + " isActive=" + isActive + "]";
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
	@Override
	public void sendEmail(IEntry entry) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "default";
	}
    
}