package hosp.info;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class BackgroundJFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1;
	JButton b1,update,info,diag,hist,out,right;
	public static JPanel p1;
	
	public BackgroundJFrame()
	{
		ImageIcon icon=new ImageIcon(getClass().getResource("/images/img1.png"));
		Image img=icon.getImage().getScaledInstance(1400, 650, Image.SCALE_DEFAULT);
	
		l1=new JLabel(new ImageIcon(img));
		l1.setBounds(0,0,1400,650);
		add(l1);
		ImageIcon ic1=new ImageIcon(getClass().getResource("/images/img11.jpg"));
		Image img1=ic1.getImage().getScaledInstance(80, 40, Image.SCALE_DEFAULT);
		right=new JButton(new ImageIcon(img1));
		right.setBounds(10,20,90,50);
		right.setBackground(Color.GRAY);
		
		
		ImageIcon ic2=new ImageIcon(getClass().getResource("/images/img12.jpg"));
		Image img2=ic2.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT);       
		b1=new JButton(new ImageIcon(img2));
		b1.setText("Add New Patient");
    	b1.setBackground(Color.GRAY);
		b1.setBounds(10,90,260,50);
		b1.setForeground(Color.black);
		b1.addActionListener(this);
		
		
		ImageIcon ic3=new ImageIcon(getClass().getResource("/images/img15.png"));
		Image img3=ic3.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT);       
		diag=new JButton(new ImageIcon(img3));
		diag.setText("Add Diagnosis Information");
	  diag.setBackground(Color.GRAY);
		diag.setBounds(10,160,260,50);
		diag.setForeground(Color.black);
		diag.addActionListener(this);
		
		ImageIcon ic4=new ImageIcon(getClass().getResource("/images/img8.png"));
		Image img4=ic4.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT);       
		hist=new JButton(new ImageIcon(img4));
		hist.setText("Full History Of Patient");
	  hist.setBackground(Color.GRAY);
		hist.setBounds(10,230,260,50);
		hist.setForeground(Color.black);
		hist.addActionListener(this);
		
		ImageIcon ic5=new ImageIcon(getClass().getResource("/images/img16.jpg"));
		Image img5=ic5.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT);       
		update=new JButton(new ImageIcon(img5));
		update.setText("Update Patient Record");
	  update.setBackground(Color.GRAY);
		update.setBounds(10,300,260,50);
		update.setForeground(Color.black);
		
		
		ImageIcon ic6=new ImageIcon(getClass().getResource("/images/img17.png"));
		Image img6=ic6.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT);       
		update=new JButton(new ImageIcon(img6));
		update.setText("Hospital Information");
	  update.setBackground(Color.GRAY);
		update.setBounds(10,370,260,50);
		update.setForeground(Color.black);
		update.addActionListener(this);
		
		ImageIcon ic7=new ImageIcon(getClass().getResource("/images/imag19.png"));
		Image img7=ic7.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT);       
		out=new JButton(new ImageIcon(img7));
		out.setText("Logout");
	  out.setBackground(Color.GRAY);
		out.setBounds(10,440,260,50);
		out.setForeground(Color.black);
		out.addActionListener(this);
		p1=new JPanel();
		p1.add(right);p1.add(b1);p1.add(diag);p1.add(hist);
		p1.add(update);p1.add(out);
		p1.setBounds(10,140,280,700);
		add(p1);
		p1.setVisible(false);
		
		
		setSize(1900,1300);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	public static void main(String [] args)
	{
		new BackgroundJFrame();
	 new LoginJFrame();
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String value=e.getActionCommand();
		if(value.equals("Add New Patient"))
		{
			new AddRecord();
		}
		if(value.equals("Add Diagnosis Information"))
		{
			new Diagnosis();
		}
		if(value.equals("Full History Of Patient"))
		{
			new FullHistory();
		}
		if(value.equals("Hospital Information"))
		{
			new Information();
		}
		if(value.equals("Logout"))
		{
			
			new LoginJFrame();
		}
		
		
	}
}
