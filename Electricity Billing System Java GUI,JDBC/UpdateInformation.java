package electricityBillingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateInformation extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JLabel l11,l22;
	JButton b1,b2;
	String meter;
	UpdateInformation(String meter)
	{
		this.meter=meter;
		setBounds(500,220,850,450);
		setLayout(null);
		getContentPane().setBackground(new Color(173,216,230));
		
		JLabel title=new JLabel("UPDATE CUSTOMER INFORMATION");
		title.setBounds(110,0,400,30);
		title.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(title);
		
		JLabel l1=new JLabel("Meter Number");
		l1.setBounds(30,70,100,30);
		add(l1);
		
		l11=new JLabel();
		l11.setBounds(230,70,100,30);
		add(l11);
		
		JLabel l2=new JLabel("Name");
		l2.setBounds(30,110,100,30);
		add(l2);
		
		l22=new JLabel();
		l22.setBounds(230,110,100,30);
		add(l22);
		
		JLabel l3=new JLabel("Address");
		l3.setBounds(30,150,150,30);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(230,150,150,25);
		add(t1);
		
		
		JLabel l4=new JLabel("State");
		l4.setBounds(30,190,150,30);
		add(l4);
		
		t2=new JTextField();
		t2.setBounds(230,190,150,25);
		add(t2);
		
		JLabel l5=new JLabel("City");
		l5.setBounds(30,230,150,30);
		add(l5);
		
		t3=new JTextField();
		t3.setBounds(230,230,150,25);
		add(t3);
		
		JLabel l7=new JLabel("Email");
		l7.setBounds(30,270,150,30);
		add(l7);
		
		t4=new JTextField();
		t4.setBounds(230,270,150,25);
		add(t4);
		
		JLabel l8=new JLabel("Phone");
		l8.setBounds(30,310,150,30);
		add(l8);
		
		t5=new JTextField();
		t5.setBounds(230,310,150,25);
		add(t5);
		
		
		b1=new JButton("Update");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(70,360,120,25);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(230,360,120,25);
		b2.addActionListener(this);
		add(b2);
		
		
		try
		{
			com c=new com();
			ResultSet rs=c.s.executeQuery("select * from customer where meter_number='"+meter+"'");
			while(rs.next())
			{
				l11.setText(rs.getString(2));
				l22.setText(rs.getString(1));
				t1.setText(rs.getString(3));
				t2.setText(rs.getString(4));
				t3.setText(rs.getString(5));
				t4.setText(rs.getString(6));
				t5.setText(rs.getString(7));

				
			}
		}
		catch(Exception e)
		{
			
		}
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("update.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT); 
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l9 = new JLabel(i3);
		l9.setBounds(420, 50, 400, 300); 
		add(l9);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource()==b1)
		{
			String s1=l11.getText();
			String s2=l22.getText();
			String s3=t1.getText();
			String s4=t2.getText();
			String s5=t3.getText();
			String s6=t4.getText();
			String s7=t5.getText();
			
			try
			{
				com c=new com();
				c.s.executeUpdate("update customer set address='"+s3+"',state='"+s4+"',city='"+s5+"',email='"+s6+"',phone='"+s7+"' where meter_number='"+meter+"'");
				JOptionPane.showMessageDialog(null, "Details Updated Successfully");
				this.setVisible(false);
			}
			catch(Exception e)
			{
				
			}
		}
		else if(ae.getSource()==b2)
		{
			this.setVisible(false);
		}
		
		
	}
	public static void main(String[] args)
	{
		new UpdateInformation("").setVisible(true);
	}

}
