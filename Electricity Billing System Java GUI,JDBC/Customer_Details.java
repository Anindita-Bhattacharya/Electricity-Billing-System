package electricityBillingSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Customer_Details extends JFrame implements ActionListener
{
	JTable t1;
	JButton b1,b2;
	Customer_Details()
	{
		super("Customer Details");
		t1=new JTable();
		t1.setBounds(0,40,1000,500);
		add(t1);
		
		JLabel l1=new JLabel("Name");
		l1.setBounds(50,10,70,20);
		add(l1);
		
		JLabel l2=new JLabel("Meter Number");
		l2.setBounds(180,10,100,20);
		add(l2);
		
		
		
		JLabel l4=new JLabel("Address");
		l4.setBounds(330,10,70,20);
		add(l4);
		
		JLabel l5=new JLabel("State");
		l5.setBounds(470,10,70,20);
		add(l5);
		
		JLabel l6=new JLabel("City");
		l6.setBounds(600,10,70,20);
		add(l6);
		
		JLabel l7=new JLabel("Email");
		l7.setBounds(750,10,70,20);
		add(l7);
		
		JLabel l8=new JLabel("Phone Number");
		l8.setBounds(880,10,100,20);
		add(l8);
		
		
		
		b1=new JButton("Load Data");
		b1.setBounds(350, 560, 120, 30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(530, 560, 120, 30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.orange);
		
		setLayout(null);
		setBounds(220,60,1000,650);
		setVisible(true);
		
	}
	public static void main(String[] args) {
	new Customer_Details().setVisible(true);;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			try {
				com c=new com();
				String str="select * from customer";
				ResultSet r=c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(r));//in order to get the tables from the database
			}
			catch(Exception e)
			{
				
			}
			
		}else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}

}



