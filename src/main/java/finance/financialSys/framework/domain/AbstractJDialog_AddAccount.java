package finance.financialSys.framework.domain;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public abstract class AbstractJDialog_AddAccount extends javax.swing.JDialog
{
	protected AFinFrm parentframe;
    protected Account account;
    protected Map<String, JTextField> textFields = new HashMap<>();
    protected String Accounttype=null;
	public AbstractJDialog_AddAccount(AFinFrm parent, String title, String[] accountTypes, String[] fields)
	{
		super(parent);
		parentframe=parent;
		
		
		//{{INIT_CONTROLS
		setTitle(title);
		setModal(true);
		getContentPane().setLayout(null);
		setSize(298,339);
		setVisible(false);
		
		int y = 12;
		int i=0;
		 ButtonGroup group = new ButtonGroup();
		for(String type : accountTypes) {
			JRadioButton JRadioButton = new JRadioButton(type);
			JRadioButton.setActionCommand(type);
			JRadioButton.addItemListener(e->{Accounttype=JRadioButton.getText();
			System.out.print(Accounttype);});
			group.add(JRadioButton);
			getContentPane().add(JRadioButton);
			JRadioButton.setBounds(36,y,84,24);
			if(i==0)
			{
				JRadioButton.setSelected(true);
			}
			i++;
			y += 24;
			
		}

		for(String field : fields) {
			javax.swing.JLabel JLabel = new javax.swing.JLabel();
			JLabel.setText(field);
			getContentPane().add(JLabel);
			JLabel.setForeground(java.awt.Color.black);
			JLabel.setBounds(12,y,48,24);
			JTextField JTextField = new JTextField();
			getContentPane().add(JTextField);
			JTextField.setBounds(120,y,156,20);
			textFields.put(field, JTextField);
			y += 24;
		}

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,y,84,24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156,y,84,24);

		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);
	}

	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Calcel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		createNewAccount();
	   parentframe.newaccount=true;
	   dispose();
			 
	}
	
	public abstract void createNewAccount();
	
	public Account getAccount() {
		return this.account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}