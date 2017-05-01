package finance.financialSys.framework.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import finance.financialSys.framework.domain.Account;
import finance.financialSys.framework.domain.Address;
import finance.financialSys.framework.domain.Customer;
import finance.financialSys.framework.domain.Entry;
import finance.financialSys.framework.domain.IAccount;
import finance.financialSys.framework.domain.IEntry;
import finance.financialSys.framework.domain.Person;
import finance.financialSys.framework.repository.AccountRepository;
import finance.financialSys.framework.repository.CustomersRepository;
import finance.financialSys.framework.repository.EntryRepository;

@Component
@Transactional
public class FinDA implements IFinDA {

	@Autowired
	CustomersRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	EntryRepository entryRepository;
	@Override
	@Transactional
	public void saveNewAccount(Account act) 
	{
		accountRepository.save(act);
		
	}
	@Transactional
	@Override
	public void saveNewCustomer(Customer cust) 
	{
		customerRepository.save(cust);
	}
	@Transactional
	@Override
	public void saveNewEntry(Entry entry) {
		entryRepository.save(entry);	
	}
	@Transactional
	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	@Transactional
	@Override
	public Iterable<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	@Transactional
	@Override
	public Iterable<Entry> getAllEntries() {
		return entryRepository.findAll();
	}
	@Transactional
	@Override
	public void addMoney(long accNb, double amount) 
	{
		Account acct=accountRepository.findOne(accNb);
		acct.deposit(amount);
		Entry entry=acct.makeEntry(amount);
		entryRepository.save(entry);
	}
	@Transactional
	@Override
	public void deductMoney(long accNb, double amount) 
	{
		Account acct=accountRepository.findOne(accNb);
		acct.withdraw(amount);
		Entry entry=acct.makeEntry(-1*amount);
		entryRepository.save(entry);
	}
	@Transactional
	@Override
	public void addInterest() 
	{
		Iterable<Account> allaccount=getAllAccounts();
		
		for(Account act:allaccount)
		{
			act.addInterest();
		}
		
	}
}
