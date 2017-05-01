package finance.financialSys.framework.domain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Observable;
import java.util.Vector;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;

import finance.financialSys.framework.controller.AUIMediator;
import finance.financialSys.framework.controller.IChangeManager;

import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class FinFrm extends AFinFrm 
{
    /****
     * init variables in the object
     ****/
    String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
    boolean newaccount;
    
    FinFrm myframe;
    private Object rowdata[];
    
    //IUIMediator mediator;
    
	public FinFrm(AUIMediator mediator, IChangeManager manager, List<IAspect> aspects)
	{
		super(mediator, manager, aspects);
		myframe = this;
		this.init("Financial App");
		
	}

	
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			//(new FinFrm(mediator)).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == FinFrm.this)
				Frm_windowClosing(event);
		}
	}

	void Frm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

//	class SymAction implements java.awt.event.ActionListener
//	{
//		public void actionPerformed(java.awt.event.ActionEvent event)
//		{
//			Object object = event.getSource();
//			if (object == JButton_Exit)
//				JButtonExit_actionPerformed(event);
//			else if (object == JButton_PerAC)
//				JButtonPerAC_actionPerformed(event);
//			else if (object == JButton_CompAC)
//				JButtonCompAC_actionPerformed(event);
//			else if (object == JButton_Deposit)
//				JButtonDeposit_actionPerformed(event);
//			else if (object == JButton_Withdraw)
//				JButtonWithdraw_actionPerformed(event);
//			else if (object == JButton_report)
//				JButtonReport_actionPerformed(event);
//			else if (object == JButton_Addinterest)
//				JButtonAddinterest_actionPerformed(event);
//			
//		}
//	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	/*void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		
		
		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "P";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

       
        
    }

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		
		
		JDialog_AddAccount pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		
		mediator.addAccount(pac.getAccount());

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr.toString());
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(amountDeposit);
		    double newamount=deposit;
		    mediator.deposit(Long.parseLong(accnr), newamount);
		}
		
		
	}

	void JButtonReport_actionPerformed(java.awt.event.ActionEvent event)
	{
		mediator.generateReport();
	
	}
	
	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
            long deposit = Long.parseLong(amountDeposit);
		    double newamount=-deposit;
		    mediator.withdraw(Long.parseLong(accnr), newamount);
		}
	}
	
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		mediator.addInterest();	    
	}
*/

    @Override
	public void update(IAspect aspect) {
		mediator.updateUI(aspect);
	}


	@Override
	public void subscribeTo(IAspect aspect) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void popuateTable(Object[][] rows, Object[] cols)
	{
		model = new DefaultTableModel(rows,cols);
		JTable1.setModel(model);
	}
	
}
