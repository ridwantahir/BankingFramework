package finance.financialSys.framework.controller;

import finance.financialSys.framework.domain.IAspect;
import finance.financialSys.framework.domain.IObserver;

public interface IChangeManager {

	public void subscribe(IAspect aspect, IObserver o);
	
	public void unsubscribe(IAspect aspect, IObserver o);
	
	public void notifyObservers(IAspect aspect);
}
