package electricityBillingSystem;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
public class Signup extends JFrame implements ActionListener
{
	JPanel p1;
	JTextField t1,t2,t3,t4;
	JButton b1,b2;
	Choice c1;
	
	
	Signup()
	{
		setBounds(350,200,750,400);
		
		p1=new JPanel();
		p1.setBounds(30,30,650,300);//setBounds do not work in JPanel
		p1.setBackground(Color.white);
		p1.setForeground(new Color(34,139,34));
		p1.setLayout(null);
		p1.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(173,216,230)));
		add(p1);
		
		JLabel l1=new JLabel("Username");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Tahoma",Font.BOLD,14));
		l1.setBounds(100,50,100,20);
		p1.add(l1);
		
		t1=new JTextField();
		t1.setBounds(260,50,150,20);
		p1.add(t1);
		
		JLabel l2=new JLabel("Name");
		l2.setForeground(Color.DARK_GRAY);
		l2.setFont(new Font("Tahoma",Font.BOLD,14));
		l2.setBounds(100,90,100,20);
		p1.add(l2);
		
		t2=new JTextField();
		t2.setBounds(260,90,150,20);
		p1.add(t2);
		
		JLabel l3=new JLabel("Password");
		l3.setForeground(Color.DARK_GRAY);
		l3.setFont(new Font("Tahoma",Font.BOLD,14));
		l3.setBounds(100,130,100,20);
		p1.add(l3);
		
		t3=new JTextField();
		t3.setBounds(260,130,150,20);
		p1.add(t3);
		
		JLabel l4=new JLabel("Create Account As");
		l4.setForeground(Color.DARK_GRAY);
		l4.setFont(new Font("Tahoma",Font.BOLD,14));
		l4.setBounds(100,170,150,20);
		p1.add(l4);
		
		JLabel l5=new JLabel("Meter Number");
		l5.setForeground(Color.DARK_GRAY);
		l5.setFont(new Font("Tahoma",Font.BOLD,14));
		l5.setBounds(100,210,100,20);
		l5.setVisible(false);
		p1.add(l5);
		
		t4=new JTextField();
		t4.setBounds(260,210,150,20);
		t4.setVisible(false);
		p1.add(t4);
		
		c1=new Choice();
		c1.add("Admin");
		c1.add("Customer");
		c1.setBounds(260,170,150,20);
		p1.add(c1);
		
		c1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ae)
			{
				String user=c1.getSelectedItem();
				if(user.equals("Customer"))
				{
					l5.setVisible(true);
					t4.setVisible(true);
				}else
				
				{
					l5.setVisible(false);
					t4.setVisible(false);
				}
			}
		});
		
		
		
		
		b1=new JButton("Create");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(140,290,120,30);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(300,290,120,30);
		b2.addActionListener(this);
		p1.add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("signup.jpg"));
		Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l6=new JLabel(i3);
		l6.setBounds(450,30,250,250);
		p1.add(l6);
	}
	public static void main(String[] args)
	{
		new Signup().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			String username=t1.getText();
			String name=t2.getText();
			String password=t3.getText();
			String user=c1.getSelectedItem();
			String meter=t4.getText();
			try
			{
				com c=new com();
				String str=null;
				if(user.equals("Admin"))
				{
					str="insert into login values('"+meter+"','"+username+"','"+name+"','"+password+"','"+user+"')";
					
							
				}
				else {
					str="update login set username='"+username+"',name='"+name+"',password='"+password+"',user='"+user+"' where meter_no='"+t4.getText()+"'";
				}
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				this.setVisible(false);
				new  Login().setVisible(true);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			this.setVisible(false);
		}
		
		
	}
	
}
