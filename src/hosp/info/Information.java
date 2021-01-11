package hosp.info;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Information extends JFrame
{
	JLabel l1,l2;
	JTextArea t1;
   public Information()
   {
	   
	   ImageIcon ic1=new ImageIcon(getClass().getResource("/images/info.jpg"));
	   Image img1=ic1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
	   l2=new JLabel(new ImageIcon(img1));
	   l2.setBounds(20,20,300,300);
	   add(l2);
			   
			   ImageIcon icon=new ImageIcon(getClass().getResource("/images/img23.jpg"));
	   Image img=icon.getImage().getScaledInstance(670, 670, Image.SCALE_DEFAULT);
	   l1=new JLabel(new ImageIcon(img));
	   l1.setBounds(0,0,400,400);
	   add(l1);
	   setSize(400,400);
	   setLocation(400,140);
	   getContentPane().setLayout(null);
	   setVisible(true);
	   
   }
}
