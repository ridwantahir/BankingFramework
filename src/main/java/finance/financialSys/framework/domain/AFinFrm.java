package finance.financialSys.framework.domain;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IChangeManager;

public abstract class AFinFrm extends javax.swing.JFrame implements IFinFrm, IObserver {

	protected IChangeManager manager;
	
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	protected AUIMediator mediator;
	protected boolean newaccount;
	protected Object rowdata[];
	protected Box hBox, vBox;
	
	Map<JButton, IFinCommand> buttonMapper = new HashMap<>();
    
	public AFinFrm(AUIMediator mediator, IChangeManager manager, List<IAspect> aspects) {
		this.manager = manager;
		this.mediator = mediator;
		aspects.forEach(aspect -> this.manager.subscribe(aspect, this));
		
	}
	
	public JTable getJTable()
	{
		return this.JTable1;
	}
	public void init(String title) {
		setTitle(title);
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(750,500);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,750,500);
		hBox = Box.createHorizontalBox();
		vBox = Box.createVerticalBox();
		
		getContentPane().add(BorderLayout.NORTH, hBox);
		getContentPane().add(BorderLayout.EAST, vBox);
		
		String[] columns = mediator.getColumns();
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        for(String c : columns) {
        	model.addColumn(c);
        }
        rowdata = new Object[8];
        newaccount=false;
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
        
        mapComponents();
        setLitseners();
	}
	
	private void mapComponents() {
		JButton JButton_Deposit = new javax.swing.JButton("Deposit");
		JButton JButton_Withdraw = new javax.swing.JButton("Withdraw");
		javax.swing.JButton JButton_Addinterest= new javax.swing.JButton("Add Interest");
		javax.swing.JButton JButton_Exit = new javax.swing.JButton("Exit");
		javax.swing.JButton JButton_report = new javax.swing.JButton("Generate Report");
		
		hBox.add(JButton_report);
		hBox.add(JButton_Addinterest);

		vBox.add(JButton_Withdraw);
		vBox.add(JButton_Deposit);
		vBox.add(JButton_Exit);

		buttonMapper.put(JButton_Deposit, CommandFactory.cmdFactoryInstance.getCommand("deposit"));
		buttonMapper.put(JButton_Withdraw, CommandFactory.cmdFactoryInstance.getCommand("withdraw"));
		buttonMapper.put(JButton_Addinterest, CommandFactory.cmdFactoryInstance.getCommand("add interest"));
		buttonMapper.put(JButton_report, CommandFactory.cmdFactoryInstance.getCommand("generate report"));
		buttonMapper.put(JButton_Exit, CommandFactory.cmdFactoryInstance.getCommand("exit"));
				
	}

	public void addUseCase(JButton button, IFinCommand cmd) {
		buttonMapper.put(button, cmd);
		button.addActionListener(e -> {
			cmd.execute(mediator);
		});
		addComponent(button);
	}
	
	private void addComponent(JButton button) {
		hBox.add(button);
	}

	public abstract void subscribeTo(IAspect aspect);

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			System.exit(0);
		}
	}
	
	public void setLitseners() {
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		
		buttonMapper.keySet().forEach(b -> {
			b.addActionListener(e -> {
				buttonMapper.get(b).execute(mediator);
			});
		});
	}

}
