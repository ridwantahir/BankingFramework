package finance.financialSys.framework.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Inheritance
public class Account implements IAccount {

	public Account(){
		
	}
	public Account(long acNbr)
	{
		this.accNumber=acNbr;
	}
	public Account(long accnum,boolean isActive,Customer cus)
	{
		this.accNumber=accnum;
		this.isActive=isActive;
		this.customer=cus;
		setInterestRate(.005);
	}
	public Account(boolean isActive, Customer customer) {
		this.isActive = isActive;
		this.customer = customer;
		setInterestRate(.005);
	}
	
	int id;
	@Id @GeneratedValue
	protected Long accNumber;
	protected boolean isActive;
	@ManyToOne(targetEntity=Customer.class, cascade=CascadeType.ALL)
	protected Customer customer;
	protected double interestRate;
	protected double amount;

	public double getAmount() {
		return amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public Long getAccNumber() {
		return accNumber;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean getIsActive() {
		return isActive;
	}

	@Override
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	@Override
	public void addInterest() {
		double interest = getAmount()* getInterestRate();
		amount+=interest;
	}

	@Override
	public double getInterestRate() {
		return this.interestRate;
	}

	@Override
	public void deposit(double amount) {
		this.amount+=amount;
	}

	@Override
	public void withdraw(double amount) {
		this.amount-=amount;
	}


	@Override
	public void generateReport() {
		// TODO implement here
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public String[] getDataMap()
	{
		 /*Long accNumber;
		 List<IEntry> entries;
		 boolean isActive;
		 ICustomer customer;*/
		String acNumber=this.accNumber+"";
		String accname=customer.getName();
		String city=customer.getAddress().getCity();
		String amount=this.amount+"";
		return new String[]{acNumber,accname,city,amount};

	}
	@Override
	public Entry makeEntry(double amount) 
	{
		Entry entry=new Entry(amount);
		entry.setAccount(this);
		entry.setDate(LocalDate.now().toString());
		return entry;
	}
	@Override
	public String toString()
	{
		return this.accNumber+"   "+this.amount;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}