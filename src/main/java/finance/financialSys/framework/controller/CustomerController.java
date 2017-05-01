package finance.financialSys.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import finance.financialSys.framework.domain.Customer;

@Component
public class CustomerController implements ICustomerController{

	@Autowired
	IFinDA repository;
	
	public CustomerController()
	{
		
	}
	public CustomerController(IFinDA repository) {
		this.repository = repository;
	}
	
	@Override
	public void addCustomer(Customer cust) {
		repository.saveNewCustomer(cust);
	}
	
}
