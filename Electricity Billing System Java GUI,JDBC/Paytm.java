package electricityBillingSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Paytm extends JFrame implements ActionListener
{
	String meter; 
	JButton b1,b2;
	Choice c1;
	Paytm(String meter){
		this.meter = meter; 
		JEditorPane j = new JEditorPane(); 
		j.setEditable(false); 
		
		b2=new JButton("Pay");
		b2.setBounds(150,20,120,25);
		b2.setBackground(Color.BLACK); 
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		j.add(b2);
		
		c1=new Choice();
		c1.setBounds(300,20,120,25);
		c1.add("January");
		c1.add("Febrauary");
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
		j.add(c1);
		
		b1 = new JButton("Back");
		b1.setBackground(Color.BLACK); 
		b1.setForeground(Color.WHITE);
		b1.setBounds(500, 20, 120, 25); 
		
		b1.addActionListener(this); j.add(b1); 
		try { j.setPage("https://paytm.com/electricity-bill-payment");
		}
		catch (Exception e) 
		{
			j.setContentType("text/html");
			j.setText("<html>Could not load</html>"); 
			}
		JScrollPane scrollPane = new JScrollPane(j); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		getContentPane().add(scrollPane); 
		setPreferredSize(new Dimension(800,600)); setSize(800,800);
		setLocation(250,120); setVisible(true); }
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b2)
		{
			String q="update bill status = 'Paid' where meter_number = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'";
			try{
				com c = new com();
				c.s.executeUpdate(q);
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "Paid");

		}catch(Exception e){}
			
			
		}
		else if(ae.getSource()==b1)
		{
			this.setVisible(false);
		}
	}
	public static void main(String[] args){ 
		new Paytm("").setVisible(true); }}


