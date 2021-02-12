package electricityBillingSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame  implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	JPanel p1,p2,p3,p4;
	Choice c1;
Login()
{
	super("Login Page");
	setLayout(null);
	getContentPane().setBackground(Color.white);
	
	l1=new JLabel("Username");
	l1.setBounds(300,20,100,20);
	add(l1);
	
	l2=new JLabel("Password");
	l2.setBounds(300,60,100,20);
	add(l2);
	
	
	tf1=new JTextField(15);
	tf1.setBounds(400,20,150,20);
	add(tf1);
	
	pf2=new JPasswordField(15);
	pf2.setBounds(400,60,150,20);
	add(pf2);
	
	l4=new JLabel("Logging in as");
	l4.setBounds(300,100,150,20);
	add(l4);
	
	
	c1=new Choice();
	c1.add("Admin");
	c1.add("Customer");
	c1.setBounds(400,100,150,20);
	add(c1);
	
	
	
	
	ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("login.jpg"));
	Image i1=ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
	b1=new JButton("Login",new ImageIcon(i1));
	b1.setBounds(330,160,100,20);
	add(b1);

	ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
	Image i2=ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
	b2=new JButton("Cancel",new ImageIcon(i2));
	b2.setBounds(450,160,100,20);
	add(b2);
	

	ImageIcon iccc3=new ImageIcon(ClassLoader.getSystemResource("signup.jpg"));
	Image i31=iccc3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
	b3=new JButton("SignUp",new ImageIcon(i31));
	b3.setBounds(380,190,100,20);
	add(b3);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	
	ImageIcon ic3=new ImageIcon(ClassLoader.getSystemResource("second.jpeg"));
	Image i3=ic1.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT);
	ImageIcon icc3=new ImageIcon(i3);
	l3=new JLabel(icc3);
	l3.setBounds(0,0,250,250);
	add(l3);
	
	
	
	
	
	
	
	setSize(640,300);
	setLocation(500,250);
	setVisible(true);
	
	
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			
		try
		{
			com c=new com();
			String a=tf1.getText();
			String b=pf2.getText();
			String user=c1.getSelectedItem();
			String q="select * from login where username='"+a+"' and password='"+b+"' and  user='"+user+"'";
			ResultSet rs=c.s.executeQuery(q);
			if(rs.next())
			{
				String meter=rs.getString("meter_no");
				new Project(meter,user).setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Login");
				tf1.setText("");
				pf2.setText("");
			}
			
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			System.out.println(e1);
		}
	}
	
	else if(e.getSource()==b2)
	{
		this.setVisible(false);
	}
	else if(e.getSource()==b3)
		
	{
		this.setVisible(false);
		new Signup().setVisible(true);
	}
	}
		public static void main(String[] args)
		{
			new Login().setVisible(true);
		}
	}
	
	


