package electricityBillingSystem;
import javax.swing.*;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Calculate_Bill extends JFrame implements ActionListener
{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1;
	Choice c1,c2;
	JButton b1,b2,b3;
	JPanel p;
	Calculate_Bill()
	{
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		
		l1=new JLabel("CALCULATE ELECTRICITY BILL");
		l1.setBounds(100,10,400,30);
		
		l2=new JLabel("Meter Number");
		l2.setBounds(100,70,100,30);
		
		l8=new JLabel("Name");
		l8.setBounds(100,120,400,30);

		
		
		
		l3=new JLabel("Month");
		l3.setBounds(100,270,400,30);
		

		
		l7=new JLabel("Units Consumed");   
		l7.setBounds(100,220,400,30);
		
		l9=new JLabel("Address");   
		l9.setBounds(100,170,400,30);
		
		
		
		t1=new JTextField();
		
		c1=new Choice();
		
		
		
		
		c1.setBounds(250,70,150,20);
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
		
		l10=new JLabel();
		l10.setBounds(250,120,180,20);
		
		l11=new JLabel();
		l11.setBounds(250,170,180,20);
		
		try
		{
			com c=new com();
			ResultSet rs=c.s.executeQuery("select * from customer where meter_number='"+c1.getSelectedItem()+"'");
			while(rs.next())
			{
				l10.setText(rs.getString("name"));
				l11.setText(rs.getString("address"));
			}
			
		}
		catch(Exception e)
		{
		}
			c1.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent ae) {
					try {
						com c=new com();
						ResultSet rs=c.s.executeQuery("select * from customer where meter_number='"+c1.getSelectedItem()+"'");
						while(rs.next())
						{
							l10.setText(rs.getString("name"));
							l11.setText(rs.getString("address"));
						}
					}
					catch(Exception e)
					{
						
					}
				}
			});
			
		
	
		
		t1=new JTextField();
		t1.setBounds(250,220,180,20);
		
		c2=new Choice();
		c2.setBounds(250,270,180,30);
		
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
		
		
		b1=new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(100,350,100,25);
	
		
		b3=new JButton("Status");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBounds(230,350,100,25);

		
		b2=new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(360,350,100,25);

		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("calculate_bill.jpg"));
		Image i2=i1.getImage().getScaledInstance(180, 270, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		l4=new JLabel(i3);
		
		l1.setFont(new Font("Senserif",Font.PLAIN,20));
		
		//move the label to center
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		p.add(l1);
		p.add(l2);
		p.add(l7);
		p.add(l3);
		p.add(c1);
		p.add(c2);
		p.add(l3);
		p.add(t1);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(l8);
		p.add(l9);
		p.add(l10);
		p.add(l11);
		
		setLayout(new BorderLayout(30,30));
		
		add(p,"Center");
		add(l4,"West");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		setSize(750,500);
		setLocation(350,150);
		
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		
		if(ae.getSource()==b1)
		{
			
			String meter_no=c1.getSelectedItem();
			String units=t1.getText();
			String month=c2.getSelectedItem();
			
			int units_consumed=Integer.parseInt(units);
			int total_bill=0;
			try
			{
				com c=new com();
				ResultSet rs=c.s.executeQuery("select * from taxes");
				while(rs.next())
				{
					total_bill=units_consumed*Integer.parseInt(rs.getString("cost_per_unit"));
					total_bill+=Integer.parseInt(rs.getString("meter_rent"));
					total_bill+=Integer.parseInt(rs.getString("service_charge"));
					total_bill+=Integer.parseInt(rs.getString("service_tax"));
					total_bill+=Integer.parseInt(rs.getString("fixed_tax"));


					


				}
			}
			catch(Exception e)
			{
				System.out.println(total_bill);
			}
		
			String q="insert into bill values('"+meter_no+"','"+month+"','"+units+"','"+total_bill+"','Not Paid')";
			
		try
		{
			
			com c1=new com();
			c1.s.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Bill Updated");
			
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
		else if(ae.getSource()==b2)
		{
			this.setVisible(false);
		}
		else if(ae.getSource()==b3)
		{
			this.setVisible(false);
			new Bill().setVisible(true);
		}
}
	public static void main(String[] args)
	{
		new Calculate_Bill().setVisible(true);
	}
}
