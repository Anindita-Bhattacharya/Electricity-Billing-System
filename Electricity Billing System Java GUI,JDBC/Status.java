package electricityBillingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Status extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5, l6; 
	JLabel l11, l12, l13, l14, l15;
	JTextField t1;
	Choice c1,c2;
	JButton b1,b2; 
	String meter;
	Status(String meter)
	{
		this.meter = meter;
		setLayout(null);
		setBounds(300, 50, 900, 600);
		JLabel title = new JLabel("Electricity Bill"); 
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		title.setBounds(120, 5, 400, 30);
		add(title); l1 = new JLabel("Meter No"); 
		l1.setBounds(35, 80, 200, 20);
		add(l1); JLabel l11 = new JLabel(); 
		l11.setBounds(300, 80, 200, 20);
		add(l11); JLabel l2 = new JLabel("Name");
		l2.setBounds(35, 140, 200, 20);
		add(l2); JLabel l12 = new JLabel(); 
		l12.setBounds(300, 140, 200, 20);
		add(l12); l3 = new JLabel("Month"); 
		l3.setBounds(35, 200, 200, 20);
		add(l3); 
		c1 = new Choice();
		c1.setBounds(250, 200, 120, 20);
		c1.add("January"); 
		c1.add("February"); 
		c1.add("March"); 
		c1.add("April"); 
		c1.add("May"); 
		c1.add("June"); 
		c1.add("July"); 
		c1.add("August");
		c1.add("September");
		c1.add("October"); 
		c1.add("November"); 
		c1.add("December"); 
		add(c1); 
		l4 = new JLabel("Units"); 
		l4.setBounds(35, 260, 200, 20); 
		add(l4); JLabel l13 = new JLabel();
		l13.setBounds(300, 260, 200, 20);
		add(l13); l5 = new JLabel("Total Bill");
		l5.setBounds(35, 320, 200, 20);
		add(l5); 
		JLabel l14 = new JLabel();
		l14.setBounds(300, 320, 200, 20);
		add(l14); l6 = new JLabel("Status"); 
		l6.setBounds(35, 380, 200, 20);
		add(l6); JLabel l15 = new JLabel(); 
		l15.setBounds(300, 380, 200, 20); 
		l15.setForeground(Color.RED); 
		add(l15); 
		try
		{
			com c = new com();
			ResultSet rs = c.s.executeQuery("select * from customer where meter_number = '"+meter+"'"); 
			while(rs.next())
			{
				l11.setText(rs.getString("meter_number"));
				l12.setText(rs.getString("name")); }
			rs = c.s.executeQuery("select * from bill where meter_number = '"+meter+"' AND month = 'January' "); 
			while(rs.next()){ l13.setText(rs.getString("units"));
			l14.setText(rs.getString("amount"));
			l15.setText(rs.getString("status"));
			}
			}
		catch(Exception e){}
		c1.addItemListener(new ItemListener()
		{
			@Override public void itemStateChanged(ItemEvent ae)
			{
				try{
					com c = new com();
					ResultSet rs = c.s.executeQuery("select * from bill where meter_number = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
					while(rs.next())
					{
						l13.setText(rs.getString("units"));
						l14.setText(rs.getString("amount")); 
						l15.setText(rs.getString("status"));
						} }catch(Exception e){
							System.out.println(e);
						}
				}
			}
		); 
		
		 b2 = new JButton("Back");
		b2.setBounds(230, 460, 200, 35); 
		add(b2);
		
		b2.setBackground(Color.BLACK); 
		b2.setForeground(Color.WHITE);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("status.jpg")); 
		Image i2 = i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l21 = new JLabel(i3);
		l21.setBounds(350, 120, 600, 300); 
		
		add(l21);  
		b2.addActionListener(this);
		getContentPane().setBackground(Color.WHITE); }
	public void actionPerformed(ActionEvent ae)
	{  if(ae.getSource()== b2)
	{
		this.setVisible(false); 
		} 
	}
	public static void main(String[] args){ 
		new Status("").setVisible(true); }}



