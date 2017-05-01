package finance.financialSys.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import finance.financialSys.framework.domain.Entry;



public interface EntryRepository extends JpaRepository<Entry,Long>{

}
