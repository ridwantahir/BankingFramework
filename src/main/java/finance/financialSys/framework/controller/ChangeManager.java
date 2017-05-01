package finance.financialSys.framework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import finance.financialSys.framework.domain.IAspect;
import finance.financialSys.framework.domain.IObserver;

public enum ChangeManager implements IChangeManager {

	ChangeManager;
	
	public Map<IAspect, List<IObserver>> map = new HashMap<>();
	
	@Override
	public void subscribe(IAspect aspect, IObserver o) {
		List<IObserver> observers = new ArrayList<>();
		if(map.containsKey(aspect))
		{
			observers = map.get(aspect);
		}
		observers.add(o);
		map.put(aspect, observers);
	}
	
	@Override
	public void unsubscribe(IAspect aspect, IObserver o) {
		List<IObserver> observers = new ArrayList<>();
		if(map.containsKey(aspect))
		{
			observers = map.get(aspect);
		}
		observers.remove(o);
		if(observers.isEmpty())
			map.remove(aspect);
	}
	
	@Override
	public void notifyObservers(IAspect aspect) {
		List<IObserver> observers = map.get(aspect);
		if(observers != null) {
			for(IObserver o : observers) {
				o.update(aspect);
			}
		}
	}
	
}
