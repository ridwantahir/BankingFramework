package finance.financialSys.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import finance.financialSys.framework.domain.Entry;
import finance.financialSys.framework.domain.IAspect;
import finance.financialSys.framework.domain.Observable;
import finance.financialSys.framework.domain.Utility;

@Component
public class ReportController extends Observable  implements IReportController {
	@Autowired
	IFinDA repository;
	IAspect aspect=Utility.getReportAspect();
	
	public ReportController(IFinDA repository) {
		this.repository=repository;
	}
	public ReportController()
	{
		super();
	}
	
	@Override
	public void generateReport() {
		
		this.notifyObservers(aspect);
	}
	@Override
	public Iterable<Entry> getAllEntries() {
		return repository.getAllEntries();
	}
	@Override
	public void saveEntryt(Entry entry) {
		repository.saveNewEntry(entry);
	}

}
