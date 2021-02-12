package electricityBillingSystem;
import javax.swing.*;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame 
{
	JTable t1;
	
	String x[]= {"Meter Number","Month","Units","Total","Status"};
	String y[][]=new String[40][8];
	int i=0,j=0;
	BillDetails(String meter)
	{
		super("Bill Details");
		setSize(700,550);
		setLocation(450,100);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		
		
		t1=new JTable(y,x);
		try
		{
			com c=new com();
			String s1="select * from bill where meter_number= "+meter;
			ResultSet rs=c.s.executeQuery(s1);
			
			t1.setModel(DbUtils.resultSetToTableModel(rs));
		}
			
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
		
		JScrollPane sp=new JScrollPane(t1);
		sp.setBounds(0,0,700,650);
		add(sp);
		}
	
	public static void main(String[] args)
	{
		new BillDetails("").setVisible(true);
	}
	}
	


