package electricityBillingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Splash
{
	public static void main(String[] args)
	{
		fframe f1=new fframe();
		f1.setVisible(true);
		int i;
		int x=1;
		for(i=2;i<=600;i+=4,x+=1)
		{
			f1.setLocation(650-((i+x)/2),400-(i/2));
			f1.setSize(i+x,i);
			try
			{
				Thread.sleep(10);
			
				
				
			}
			catch(Exception e)
			{
				
			}
			
		}
	}

}
class fframe extends JFrame implements Runnable
//mutithreading takes place in two ways by 
//extending thread and by implementing runnable
//runnable is an interface so we need to overrise run method
{

	Thread t1;
	fframe()
	{
		setTitle("Electricity Billing System");
		setLayout(new FlowLayout());
		ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		Image i1=c1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
		ImageIcon c2=new ImageIcon(i1);
		
		JLabel l1=new JLabel(c2);
		add(l1);
		t1=new Thread(this);
		t1.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
				Thread.sleep(7000);
				//window will automatically close after 7 seconds
				//here we have to pass arguments in terms of milliseconds
				this.setVisible(false);
				Login l=new Login();
				l.setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}
