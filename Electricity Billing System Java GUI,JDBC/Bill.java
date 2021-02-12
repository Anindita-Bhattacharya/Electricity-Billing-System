package electricityBillingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Bill extends JFrame implements ActionListener
{
	
	JButton b1,b2,b3;
	Choice c1,c2;
	JTextField t1,t2,t3,t4,t5;
	Bill()
	{
	JLabel l1=new JLabel("Status");
	l1.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
	l1.setForeground(Color.blue);
	l1.setBounds(30,10,400,30);
	add(l1);
	
	
	JLabel l6=new JLabel("Meter Number");
	l6.setBounds(30,110,120,20);
	add(l6);
	c1=new Choice();
	try
	{
		com c=new com();
		ResultSet rs=c.s.executeQuery("select * from customer");
		while(rs.next())
		{
			c1.add(rs.getString("meter_number"));
		}
		
		
	}
	catch(Exception e)
	{
		
	}
	c1.setBounds(170,110,120,20);
	add(c1);

	
	JLabel l3=new JLabel("Month");
	l3.setBounds(30,150,120,20);
	add(l3);
	
	c2=new Choice();
	c2.setBounds(170,150,120,20);
	add(c2);
	
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
	
	JLabel l4=new JLabel("Units");
	l4.setBounds(30,190,120,20);
	add(l4);
	
	t2=new JTextField();
	t2.setBounds(170,190,120,20);
	add(t2);
	
	
	JLabel l5=new JLabel("Amount");
	l5.setBounds(30,230,120,20);
	add(l5);
	
	t3=new JTextField();
	t3.setBounds(170,230,120,20);
	add(t3);
	
	b1=new JButton("Check");
	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	b1.setBounds(25,300,120,30);
	b1.addActionListener(this);
	add(b1);
	
	
	
	b3=new JButton("Back");
	b3.setBackground(Color.black);
	b3.setForeground(Color.white);
	b3.setBounds(150,300,120,30);
	b3.addActionListener(this);
	add(b3);
	
	getContentPane().setBackground(Color.white);
	
	
	setLayout(null);
	setBounds(450,120,400,430);
	setVisible(true);
}

@Override
public void actionPerformed(ActionEvent ae) {
	// TODO Auto-generated method stub
	if(ae.getSource()==b1)
	{
		String units=null;
		String str=c1.getSelectedItem();
		String str2=c2.getSelectedItem();
		com c=new com();
		try {
			ResultSet rp=c.s.executeQuery("select * from bill where meter_number='"+str+ "' and month='"+str2+"'");
			while(rp.next())
			{
				t2.setText(rp.getString("units"));
				t3.setText(rp.getString("amount"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

	
	else if(ae.getSource()==b3)
	{
		this.setVisible(false);
	}
	
}
public static void main(String[] args)
{
	new Bill().setVisible(true);
}
}
