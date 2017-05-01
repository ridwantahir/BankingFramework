package finance.financialSys.framework.domain;

public interface ICmdFactory {
	public IFinCommand getCommand(String cmdType);

}
