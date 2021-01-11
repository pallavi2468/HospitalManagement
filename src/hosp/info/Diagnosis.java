package hosp.info;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

import net.proteanit.sql.DbUtils;
public class Diagnosis extends JFrame implements ActionListener 
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2,t3,t4;
JButton b1,save;
public static Connection con;
public static PreparedStatement ps;
JTable table;
JScrollPane scrollPane;
JCheckBox ward;
JPanel panel;
JComboBox <String>box;

	
	public Diagnosis()
	{
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		l2=new JLabel("Patient ID");
		l2.setBounds(100, 20, 130, 30);
		 l2.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		 l2.setForeground(Color.WHITE);
		 getContentPane().add(l2);
		 t1=new JTextField();
		 t1.setBounds(200, 20, 90, 30);
		 getContentPane().add(t1);
		 
		 ImageIcon ic=new ImageIcon(getClass().getResource("/images/img26.png"));
		 Image im=ic.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		 b1 =new JButton(new ImageIcon(im));
		 b1.setBounds(320, 20, 110, 30);
		 b1.setText("Search");
		 b1.setBackground(Color.WHITE);
		 b1.setForeground(Color.BLACK);
          getContentPane().add(b1);
          l3=new JLabel("");
          l3.setBounds(220,62,250,30);
          l3.setForeground(Color.red);
          l3.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
          getContentPane().add(l3);
          
          scrollPane = new JScrollPane();
          scrollPane.setBounds(10, 93, 680, 85);
          getContentPane().add(scrollPane);
          
           table= new JTable();
          scrollPane.setViewportView(table);
          b1.addActionListener(this);
          
          l4=new JLabel("Symptom's");
          l4.setBounds(20,220,100,30);
          l4.setForeground(Color.white);
          l4.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
          getContentPane().add(l4);
          t2=new JTextField();
 		 t2.setBounds(140, 220, 150, 30);
 		 getContentPane().add(t2);
 		 
 		 
 		l5=new JLabel("Diagnosis");
        l5.setBounds(20,260,100,30);
        l5.setForeground(Color.white);
        l5.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        getContentPane().add(l5);
        t3=new JTextField();
		 t3.setBounds(140, 260, 150, 30);
		 getContentPane().add(t3);
		 
		 
		 l6=new JLabel("Medicines");
	        l6.setBounds(20,300,100,30);
	        l6.setForeground(Color.white);
	        l6.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
	        getContentPane().add(l6);
	        t4=new JTextField();
			 t4.setBounds(140, 300, 150, 30);
			 getContentPane().add(t4);
			 
			 l7=new JLabel("Ward Required");
	          l7.setBounds(350,220,150,30);
	          l7.setForeground(Color.white);
	          l7.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
	          getContentPane().add(l7);
	          
	       ward=new JCheckBox("Yes");        
	       ward.setForeground(Color.black);
	           ward.setBounds(520,220,50,30);
			 getContentPane().add(ward);
		 ward.addActionListener(this);
		 
		 l8=new JLabel("Type of ward");
	        l8.setBounds(350,260,150,30);
	        l8.setForeground(Color.white);
	        l8.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
	      add(l8);
	      l8.setVisible(false);
	        String arr[]= {"General","Duo","Single"};
	        box=new JComboBox<>(arr);
			 box.setBounds(520, 260, 150, 30);
			add(box);
			box.setVisible(false);
			
			
			 ImageIcon ic1=new ImageIcon(getClass().getResource("/images/icons8-save-48.png"));
			 Image im1=ic1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			 
			 
			 save =new JButton(new ImageIcon(im1));
			 save.setText("Save");
			 save.setBackground(Color.WHITE);
			 save.setBounds(300,400,120,30);
			 save.setForeground(Color.BLACK);
	          add(save);
	          save.addActionListener(this);
			
		 
		 
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/images/img23.jpg"));
		Image img1 =icon.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
		l1=new JLabel(new ImageIcon(img1));
		l1.setBounds(0, 0, 700, 450);
		getContentPane().add(l1);
		
		
		
		
		
		
		
		 setSize(700,450);
		 setLocation(400,140);
		 setUndecorated(true);
		 setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		String value=e.getActionCommand();
		String id=t1.getText();
	  
		if(value.equals("Search"))
		{
			
			
			con=DBUtil.getDBConnection();
			try {
				ps=con.prepareStatement("SELECT * FROM PATIENT_INFO WHERE PATIENT_ID=? ");
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();	
				
				if(rs!=null)
				{
					l3.setText("");	
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				ps=con.prepareStatement("SELECT * FROM PATIENT_INFO WHERE PATIENT_ID=? ");
				ps.setString(1, id);
				ResultSet rs2=ps.executeQuery();	
				if(rs2.next()==false)
					l3.setText("Patient id does not exist");
				
				
					
			} catch (SQLException e1) {
				
				System.out.println("Exception"+e1.getMessage());
			}
			
			
		}
		if(ward.isSelected())
		{
			l8.setVisible(true);
			box.setVisible(true);
		}
		if(ward.isSelected()==false)
		{
			l8.setVisible(false);
			box.setVisible(false);
		}
		if(value.equals("Save"))
		{
			
			String sym=t2.getText();
			String diag=t3.getText();
			String med=t4.getText();
			String req="",type="";
			
			if(ward.isSelected())
			{
				 req="Yes";
				 type=(String)box.getSelectedItem();
			}
			else
			{
				req="No";
				type="";
			}
				con=DBUtil.getDBConnection();	
			try
			{
				int t=0;
				ps=con.prepareStatement("insert into DIAGNOSIS_INFO VALUES(?,?,?,?,?,?)");
				ps.setString(1, id);
				ps.setString(2, sym);
				ps.setString(3, diag);
				ps.setString(4, med);
				ps.setString(5, req);
				ps.setString(6, type);
				t=ps.executeUpdate();
				if(t==1)
				{
					JFrame f1=new JFrame();
				     JOptionPane.showMessageDialog(f1, "Saved Sucessfully");
                     dispose();
				}
				
				
			} 
			catch (SQLException e1)
			{
				
				System.out.println("Exception "+e1.getMessage());
			}
		}
		
		
	}
}
