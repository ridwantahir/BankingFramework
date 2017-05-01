package finance.financialSys.ccard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import finance.financialSys.framework.controller.*;
import finance.financialSys.framework.domain.*;

import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class CCardFrm extends AFinFrm
{
    /****
     * init variables in the object
     ****/
    String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
    boolean newaccount;
    CCardFrm myframe;
    private Object rowdata[];
    
	public CCardFrm(AUIMediator mediator, IChangeManager manager, List<IAspect> aspects)
	{
		super(mediator, manager, aspects);
		myframe = this;
		this.init("Bank Application");		
		
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
			//(new BankFrm()).setVisible(true);
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

	/*public void addComponents() {

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

	}
	
	public void setLitseners() {

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}
	
	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == BankFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
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
*/

	@Override
	public void update(IAspect aspect) {
		mediator.updateUI(aspect);
	}


	@Override
	public void subscribeTo(IAspect aspect) {
		
		
	}
	@Override
	public void popuateTable(Object[][] rows, Object[] cols)
	{
		model = new DefaultTableModel(rows,cols);
		JTable1.setModel(model);
	}
   
}
