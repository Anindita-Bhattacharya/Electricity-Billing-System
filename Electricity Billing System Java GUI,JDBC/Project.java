package electricityBillingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Project extends JFrame implements ActionListener
{
	String meter;
	Project(String meter,String person)
	{
		super("Electricity Billing System");
		this.meter=meter;
		setSize(1920,1030);
		/*Adding Background Image*/
		ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("ebs.jpg"));
		Image i3=ic.getImage().getScaledInstance(1400, 750, Image.SCALE_DEFAULT);
		ImageIcon icc3=new ImageIcon(i3);
		JLabel l1=new JLabel(icc3);
		add(l1);
		
		JLabel l10= new JLabel("ELECTRICITY BILLING SYSTEM");
	    l10.setBounds(500,20,1000,70);//(left,top,width,height)
	    l10.setForeground(Color.black);
	    l10.setFont(new Font("Tahoma",Font.BOLD,30));
	    l1.add(l10);//as we want to add the label on another label
	    
	   
	 
	    
		
		/*First Column*/
		JMenuBar mb=new JMenuBar();
		JMenu master=new JMenu("Master");
		JMenuItem m1=new JMenuItem("New Customer");
		JMenuItem m4=new JMenuItem("New Employee");
		JMenuItem m2=new JMenuItem("Customer Details");
		JMenuItem m5=new JMenuItem("Employee Details");
		JMenuItem m3=new JMenuItem("Deposit Details");
		master.setForeground(Color.BLUE);
		
		/*-------Customer Details-------*/
		m1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("newcustomer.jpg"));
		Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m1.setIcon(new ImageIcon(image1));
		m1.setMnemonic('D'); //shortcut 
		m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		m1.setBackground(Color.white);
		
		/*----------New Employee----------*/
		m4.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("newcustomer.jpg"));
		Image image122=icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m4.setIcon(new ImageIcon(image122));
		m4.setMnemonic('K'); //shortcut 
		m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
		m4.setBackground(Color.white);
		
		
		
		
		/*-------Master Details-------*/
		m2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("master.jpg"));
		Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m2.setIcon(new ImageIcon(image2));
		m2.setMnemonic('M'); //shortcut 
		m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		m2.setBackground(Color.white);
		
		/*-----------Employee Details----------*/
		m5.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon199=new ImageIcon(ClassLoader.getSystemResource("master.jpg"));
		Image image100=icon199.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m5.setIcon(new ImageIcon(image100));
		m5.setMnemonic('J'); //shortcut 
		m5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
		m5.setBackground(Color.white);
		
		/*-------Deposit Details-------*/
		m3.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("deposit.jpg"));
		Image image3=icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m3.setIcon(new ImageIcon(image3));
		m3.setMnemonic('N'); //shortcut 
		m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		m3.setBackground(Color.white);
		
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
	
		
		
		//-----------------------------------------------------
		JMenu info=new JMenu("Information");
		JMenuItem Info1=new JMenuItem("Update Information");
		JMenuItem Info2=new JMenuItem("View Information");
		info.setForeground(Color.RED);
		
		
		/*-------Pay Bill-------*/
		Info1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon41=new ImageIcon(ClassLoader.getSystemResource("pb.jpg"));
		Image image42=icon41.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		
		
		Info1.setIcon(new ImageIcon(image42));
		Info1.setMnemonic('E'); //shortcut 
		Info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		Info1.setBackground(Color.white);

		
		/*-------Bill Details-------*/
		Info2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon29=new ImageIcon(ClassLoader.getSystemResource("bill.jpg"));
		Image image28=icon29.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		Info2.setIcon(new ImageIcon(image28));
		Info2.setMnemonic('F'); //shortcut 
		Info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		Info2.setBackground(Color.white);
		
		
		
		Info1.addActionListener(this);
		Info2.addActionListener(this);
	
		//--------------------------------------------------------
		/*Second Column*/
		JMenu user=new JMenu("User");
		JMenuItem u1=new JMenuItem("Pay Bill");
		JMenuItem u2=new JMenuItem("Calculate Bill");
		JMenuItem u3=new JMenuItem("Last Bill");
		user.setForeground(Color.RED);
		
		
		/*-------Pay Bill-------*/
		u1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("pb.jpg"));
		Image image12=icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		
		
		u1.setIcon(new ImageIcon(image1));
		u1.setMnemonic('E'); //shortcut 
		u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		u1.setBackground(Color.white);

		
		/*-------Bill Details-------*/
		u2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon22=new ImageIcon(ClassLoader.getSystemResource("bill.jpg"));
		Image image23=icon22.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u2.setIcon(new ImageIcon(image23));
		u2.setMnemonic('F'); //shortcut 
		u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		u2.setBackground(Color.white);
		
		/*-------Last Bill-------*/
		u3.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon33=new ImageIcon(ClassLoader.getSystemResource("lbill.jpg"));
		Image image35=icon33.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u3.setIcon(new ImageIcon(image35));
		u3.setMnemonic('G'); //shortcut 
		u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		u3.setBackground(Color.white);
		
		u1.addActionListener(this);
		u2.addActionListener(this);
		u3.addActionListener(this);
	
		
		//--------------------------------------------------------------
		/*Third Column*/
		JMenu report=new JMenu("Report");
		JMenuItem r1=new JMenuItem("Status");
		report.setForeground(Color.GREEN);
		
		/*------REPORT-------*/
		r1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("report.jpg"));
		Image image77=icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		r1.setIcon(new ImageIcon(image77));
		r1.setMnemonic('O'); //shortcut 
		r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		r1.setBackground(Color.white);
		r1.addActionListener(this);
		
		//----------------------------------------------------------
		
		/*Fourth Column*/
		
		JMenu utility=new JMenu("Utility");
		JMenuItem ut1=new JMenuItem("Notepad");
		JMenuItem ut2=new JMenuItem("Calculator");
		JMenuItem ut3=new JMenuItem("Web Browser");
		utility.setForeground(Color.CYAN);
		
		//Notepad
		
		ut1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon55=new ImageIcon(ClassLoader.getSystemResource("master.jpg"));
		Image image65=icon55.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ut1.setIcon(new ImageIcon(image65));
		ut1.setMnemonic('H'); //shortcut 
		ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		ut1.setBackground(Color.white);
		
		//Calculator
		
				ut2.setFont(new Font("monospaced",Font.PLAIN,12));
				ImageIcon icon85=new ImageIcon(ClassLoader.getSystemResource("calci.jpg"));
				Image image95=icon85.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				ut2.setIcon(new ImageIcon(image95));
				ut2.setMnemonic('I'); //shortcut 
				ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
				ut2.setBackground(Color.white);
				
		//Web Browser
				

				ut3.setFont(new Font("monospaced",Font.PLAIN,12));
				ImageIcon icon115=new ImageIcon(ClassLoader.getSystemResource("web browser.jpg"));
				Image image105=icon115.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				ut3.setIcon(new ImageIcon(image105));
				ut3.setMnemonic('K'); //shortcut 
				ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
				ut3.setBackground(Color.white);
				
				ut1.addActionListener(this);
				ut2.addActionListener(this);
				ut3.addActionListener(this);
				
				//--------------------------
				/*Fifth Column*/
				
				JMenu exit=new JMenu("Exit");
				JMenuItem ex=new JMenuItem("Exit");
				exit.setForeground(Color.BLUE);
				
				/*----------------EXIT---------------------*/
				
				ex.setFont(new Font("monospaced",Font.PLAIN,12));
				ImageIcon icon119=new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
				Image image185=icon119.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				ex.setIcon(new ImageIcon(image185));
				ex.setMnemonic('E'); //shortcut 
				ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
				ex.setBackground(Color.white);
				
				ex.addActionListener(this);
				
				//----------------------------------------------------
				master.add(m1);
				master.add(m2);
				master.add(m3);
				master.add(m4);
				master.add(m5);
				master.add(u2);
				
				
				info.add(Info1);
				info.add(Info2);
				
				user.add(u1);
				user.add(u3);
				
				report.add(r1);
				
				utility.add(ut1);
				utility.add(ut2);
				utility.add(ut3);
				
				exit.add(ex);
				
				if(person.equals("Admin"))
				{
					mb.add(master);
				}
				else
				{
					mb.add(info);
					mb.add(user);
					mb.add(report);
				}
				
				mb.add(utility);
				mb.add(exit);
				
				setJMenuBar(mb);
				
				setFont(new Font("Senserif",Font.BOLD,16));
				setLayout(new FlowLayout());
				setVisible(false);
				

				
}
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String msg=ae.getActionCommand();
		if(msg.equals("New Customer"))
				{
					new New_Customer().setVisible(true);
				}
		else if(msg.equals("Customer Details"))
		{
			new Customer_Details().setVisible(true);

			
		}
		else if(msg.equals("Deposit Details"))
		{
			new Deposit_Details().setVisible(true);

		}
		else if(msg.equals("Pay Bill"))
		{
			new PayBill(meter).setVisible(true);
		}
		else if(msg.equals("Calculate Bill"))
		{
			new Calculate_Bill().setVisible(true);
		}
		else if(msg.equals("Last Bill"))
		{
			new BillDetails(meter).setVisible(true);
			
		}
		else if(msg.equals("Notepad"))
		{
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception e)
			{
				
			}
		}
		else if(msg.equals("Web Browser"))
		{
			try
			{
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			}
			catch(Exception e1)
			{
				
			}
		}
		else if(msg.equals("Calculator"))
		{
			try
			{
			Runtime.getRuntime().exec("calc.exe");
			}
			catch(Exception e1)
			{
				
			}
			
		}
		else if(msg.equals("Exit"))
		{
			this.setVisible(false);
		}
		else if(msg.equals("New Employee"))
		{
			new New_Employee().setVisible(true);
		}
		else if(msg.equals("Employee Details"))
		{
			new Employee_Details().setVisible(true);
		}
		else if(msg.equals("View Information"))
		{
			new View_Information(meter).setVisible(true);
		}
		else if(msg.equals("Update Information"))
		{
			new UpdateInformation(meter).setVisible(true);
		}
		else if(msg.equals("Status"))
		{
			new Status(meter).setVisible(true);
		}
		
	}
	public static void main(String[] args)
	{
		new Project("","").setVisible(true);
	}
	

}
