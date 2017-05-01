package finance.financialSys.framework.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance
public class Entry implements IEntry {
	
	public Entry()
	{
		
	}
	public Entry(double amount) {
		this.date = "2010";
		this.amount = amount;
	}
	@Id @GeneratedValue
	int id;
    private String date;
    private double amount;
    @ManyToOne(targetEntity=Account.class)
    private IAccount account;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getDate() {
        return date;
    }

    @Override
	public double getAmount() {
        return amount;
    }
    
    @Override
    public void setAmount(double amount) {
    	this.amount = amount;
    }
    
    @Override
    public void setAccount(IAccount account) {
    	this.account = account;
    }

	@Override
	public IAccount getAccount() {
		return account;
	}

	@Override
	public String toString() {
		return "\nTo/From Acctnum: "+this.account.getAccNumber()+" -  amount=" + amount  +"  on: "+this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}