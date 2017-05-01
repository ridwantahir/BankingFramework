package finance.financialSys.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finance.financialSys.framework.domain.Customer;

@Repository
public interface CustomerRepository <T extends Customer> extends JpaRepository<T,Long>{

}
