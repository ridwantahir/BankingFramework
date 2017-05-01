package finance.financialSys.framework.controller;

import java.util.List;

import finance.financialSys.framework.domain.Entry;

public interface IReportController {
	public void generateReport();
	public Iterable<Entry> getAllEntries();
	public void saveEntryt(Entry entry);
}
