package finance.financialSys.framework.domain;

public interface IObservable {
	public void attach(Aspect aspect, IObserver o);
	public void detach(Aspect aspect, IObserver o);
	public void notifyObservers(IAspect aspect);
}
