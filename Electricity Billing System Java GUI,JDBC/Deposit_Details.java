package electricityBillingSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import net.proteanit.sql.DbUtils;

public class Deposit_Details extends JFrame implements ActionListener
{
	JTable t1;
	JButton b1,b2;
	JLabel l1,l2;
	Choice c1,c2;
	String x[]= {"Meter Number","Month","Units","Total","Status"};
	String y[][]=new String[40][8];
	int i=0,j=0;
	Deposit_Details()
	{
		super("Deposit Details");
		setSize(700,550);
		setLocation(450,100);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		l1=new JLabel("Sort by Metre Number");
		l1.setBounds(20,20,150,20);
		add(l1);
		
		c1=new Choice();
		
		l2=new JLabel("Sort by Month");
		l2.setBounds(400,20,100,20);
		add(l2);
		
		c2=new Choice();
		
		t1=new JTable(y,x);
		try
		{
			com c=new com();
			String s1="select * from bill";
			ResultSet rs=c.s.executeQuery(s1);
			while(rs.next())
			{
				y[i][j++]=rs.getString("meter_number");
				y[i][j++]=rs.getString("month");
				y[i][j++]=rs.getString("units");
				y[i][j++]=rs.getString("amount");
				i++;
				j=0;
			}
			t1.setModel(DbUtils.resultSetToTableModel(rs));
			
			String str2="select * from customer";
			rs=c.s.executeQuery(str2);
			while(rs.next())
			{
				c1.add(rs.getString("meter_number"));
			}

				
				
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		c1.setBounds(180,20,150,20);
		add(c1);
		
		c2.setBounds(520,20,100,20);
		
		c2.add("January");
		c2.add("Febrauary");
		c2.add("March");
		c2.add("April");
		c2.add("May");
		c2.add("June");
		c2.add("July");
		c2.add("August");
		c2.add("September");
		c2.add("October");
		c2.add("November");
		c2.add("December");
		add(c2);

		b1=new JButton("Submit");
		b1.setBounds(20,70,80,20);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("print");
		b2.setBounds(120,70,80,20);
		b2.addActionListener(this);
		add(b2);
		
		JScrollPane sp=new JScrollPane(t1);
		sp.setBounds(0,100,700,650);
		add(sp);
		}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			String str="select * from bill where meter_number='"+c1.getSelectedItem()+"' AND month='"+c2.getSelectedItem()+"'";
			try
			{
				com c=new com();
				ResultSet rs=c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e)
			{
				
			}
		}
			else if(ae.getSource()==b2)
			{
				try
				{
					t1.print();
			}
				catch(Exception e)
				{
					
				}
		}
		
	}
	public static void main(String[] args)
	{
		new Deposit_Details().setVisible(true);
	}
	}
	