package finance.financialSys.framework.domain;

import org.springframework.beans.factory.annotation.Autowired;

import finance.financialSys.framework.controller.IChangeManager;

public class Observable implements IObservable {
	
	protected IChangeManager manager = Utility.getChangeManager();
	
	@Override
	public void attach(Aspect aspect, IObserver o) {
		manager.subscribe(aspect, o);
	}

	@Override
	public void detach(Aspect aspect, IObserver o) {
		manager.unsubscribe(aspect, o);
	}

	@Override
	public void notifyObservers(IAspect aspect) {
		manager.notifyObservers(aspect);
	}
	
}
