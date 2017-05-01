package finance.financialSys.framework.domain;

import finance.financialSys.framework.controller.IUIMediator;

public abstract class AFinCo implements IFinCo {

	//protected IAspect aspect;
	protected IUIMediator mediator;
	protected AFinFrm frame;
	
	@Override
	public void startApp() {
		frame.setVisible(true);
	}
	
	public AFinCo(IUIMediator mediator, AFinFrm frame) {
		//this.aspect = aspect;
		this.mediator = mediator;
		this.frame = frame;
		mediator.setFrame(frame);
		startApp();
	}
}
