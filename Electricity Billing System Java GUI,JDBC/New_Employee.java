package electricityBillingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class New_Employee extends JFrame implements ActionListener
{

	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	
	New_Employee()
	{
		setLocation(350,50);
		setSize(700,650);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(9,2,10,10));
		
		p.setBackground(Color.white);
		
		l1=new JLabel("Name");
		t1=new JTextField();
		p.add(l1);
		p.add(t1);
		
		
		
		l3=new JLabel("Address");
		t3=new JTextField();
		p.add(l3);
		p.add(t3);
		
		l4=new JLabel("State");
		t4=new JTextField();
		p.add(l4);
		p.add(t4);
		
		l5=new JLabel("City");
		t5=new JTextField();
		p.add(l5);
		p.add(t5);
		
		l6=new JLabel("Email");
		t6=new JTextField();
		p.add(l6);
		p.add(t6);
		
		l7=new JLabel("Phone Number");
		t7=new JTextField();
		p.add(l7);
		p.add(t7);
		
		b1=new JButton("Submit");
		b3=new JButton("Update");
		b2=new JButton("Cancel");
		
		
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b3.setBackground(Color.black);
		
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);
		
		p.add(b1);
		p.add(b3);
		p.add(b2);
		
		setLayout(new BorderLayout());
		
		add(p,"Center");
		
		ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("newcustomer.jpg"));
		Image i3=ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon ic2=new ImageIcon(i3);
		l8=new JLabel(ic2);
		
		add(l8,"West");
		//for changing the background color to white
		getContentPane().setBackground(Color.white);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		
		
		
	}

@Override
public void actionPerformed(ActionEvent ae) {
	// TODO Auto-generated method stub
	if(ae.getSource()==b1)
	{
	String a=t1.getText();
	String c=t3.getText();
	String d=t4.getText();
	String e=t5.getText();
	String f=t6.getText();
	String g=t7.getText();
	
	
	String q1="insert into emp values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
	
	try
	{
		com c1=new com();
		c1.s.executeUpdate(q1);
		JOptionPane.showMessageDialog(null, "Employee added");
	}
	catch(Exception e1)
	{
		
		System.out.println(e1);
	}
	}
	else if(ae.getSource()==b2)
	{
		this.setVisible(false);
	}
	else if(ae.getSource()==b3)
	{
		
		String a=t1.getText();
		String c=t3.getText();
		String d=t4.getText();
		String e=t5.getText();
		String f=t6.getText();
		String g=t7.getText();
		
		
		
		try
		{
			com c1=new com();
			c1.s.executeUpdate("update emp set address='"+a+"',state='"+c+"',city='"+d+"',email='"+e+"',phone='"+f+ "' where name='"+a+"'");
			JOptionPane.showMessageDialog(null, "Employee Information Updated");
		}
		catch(Exception e1)
		{
			
			System.out.println(e1);
		}
	}
	
}


public static void main(String[] args)
{
	new New_Employee().setVisible(true);
}

}


