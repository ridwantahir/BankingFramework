package finance.financialSys.framework.repository;

import org.springframework.stereotype.Repository;

import finance.financialSys.framework.domain.Customer;

@Repository
public interface CustomersRepository extends CustomerRepository<Customer>
{
	
}
