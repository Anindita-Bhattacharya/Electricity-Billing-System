package electricityBillingSystem;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class New_Customer extends JFrame implements ActionListener
{
	
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11;
		JTextField t1,t2,t3,t4,t5,t6,t7;
		JButton b1,b2;
		
		New_Customer()
		{
			setLocation(350,50);
			setSize(700,500);
			
			JPanel p=new JPanel();
			p.setLayout(null);
			p.setBackground(Color.white);
			p.setBackground(new Color(173,216,230));
			
			JLabel title=new JLabel("New Customer");
			title.setBounds(180,10,200,20);
			title.setFont(new Font("Tahoma",Font.PLAIN,24));
			p.add(title);
			
			l1=new JLabel("Customer Name");
			l1.setBounds(100,80,100,20);
			
			l11=new JLabel();
			l11.setBounds(240,120,200,20);
			p.add(l1);
			p.add(l11);
			
			l2=new JLabel("Meter Number");
			l2.setBounds(100,120,100,20);

			t2=new JTextField();
			t2.setBounds(240,80,200,20);

			p.add(l2);
			p.add(t2);
			
			l3=new JLabel("Address");
			l3.setBounds(100,160,100,20);

			t3=new JTextField();
			t3.setBounds(240,160,200,20);
			
			p.add(l3);
			p.add(t3);
			
			l5=new JLabel("City");
			l5.setBounds(100,200,100,20);
			t5=new JTextField();
			t5.setBounds(240,200,200,20);
			p.add(l5);
			p.add(t5);
			
			l4=new JLabel("State");
			l4.setBounds(100,240,100,20);
			t4=new JTextField();
			t4.setBounds(240,240,200,20);
			p.add(l4);
			p.add(t4);
			
			
			
			l6=new JLabel("Email");
			l6.setBounds(100,280,100,20);
			t6=new JTextField();
			t6.setBounds(240,280,200,20);
			p.add(l6);
			p.add(t6);
			
			l7=new JLabel("Phone Number");
			l7.setBounds(100,320,100,20);
			
			t7=new JTextField();
			t7.setBounds(240,320,200,20);

			p.add(l7);
			p.add(t7);
			
			b1=new JButton("Next");
			b2=new JButton("Cancel");
			
			b1.setBackground(Color.black);
			b1.setBounds(120,390,100,25);
			b1.setForeground(Color.white);
			
			b2.setBackground(Color.black);
			b2.setBounds(250,390,100,25);

			b2.setForeground(Color.white);
			
			p.add(b1);
			p.add(b2);
			setLayout(new BorderLayout());
			
			add(p,"Center");
			
			ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("newcustomer.jpg"));
			Image i3=ic1.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT);
			ImageIcon ic2=new ImageIcon(i3);
			l8=new JLabel(ic2);
			
			add(l8,"West");
			//for changing the background color to white
			getContentPane().setBackground(Color.white);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			
			Random ran=new Random();
			long first=(ran.nextLong()  % 1000000);
			l11.setText(""+Math.abs(first)); //to generate positive values
			
			
			
			
			
			
		}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
		String name=t2.getText();
		String meter=l11.getText();
		String address=t3.getText();
		String state=t4.getText();
		String city=t5.getText();
		String email=t6.getText();
		String phone=t7.getText();
		
		
		String q1="insert into customer values('"+name+"','"+meter+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
		String q2="insert into login values('"+meter+"','','','','')";
		try
		{
			com c1=new com();
			c1.s.executeUpdate(q1);
			c1.s.executeUpdate(q2);
			JOptionPane.showMessageDialog(null, "Customer details added successfully");
			this.setVisible(false);
			new MeterInfo(meter).setVisible(true);
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
		
	}
	
	
	public static void main(String[] args)
	{
		new New_Customer().setVisible(true);
	}

}
