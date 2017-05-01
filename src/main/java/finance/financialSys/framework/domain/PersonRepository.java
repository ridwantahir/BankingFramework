package finance.financialSys.framework.domain;

import org.springframework.stereotype.Repository;

import finance.financialSys.framework.repository.CustomerRepository;

@Repository
public interface PersonRepository extends CustomerRepository<Person>
{

}
