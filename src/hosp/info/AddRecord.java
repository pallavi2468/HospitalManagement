package hosp.info;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRecord extends JFrame implements ActionListener
{
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
   JTextField t1,t2,t3,t4,t5,t6;
   JTextArea a1;
   JComboBox<String> c1;
   JButton save;
   
   
	
	public static Connection con;
	public static PreparedStatement ps;
	 public AddRecord() 
	 {
		
		 l9=new JLabel("Patient ID");
		 l9.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l9.setForeground(Color.WHITE);
		 l9.setBounds(40,20,140,30);
		 add(l9);
		 t6=new JTextField();
		 t6.setBounds(200,20,150,30);
		 add(t6);
		con=DBUtil.getDBConnection();
		try {
			ps=con.prepareStatement("select SEQ_ID.nextval from DUAL");
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		
		t6.setText("HOSP"+rs.getString(1));
			
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception"+e.getMessage());
		}
		
		 l2=new JLabel("Name");
		 l2.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l2.setForeground(Color.WHITE);
		 l2.setBounds(40,60,50,30);
		 add(l2);
		 t1=new JTextField();
		 t1.setBounds(200,60,150,30);
		 add(t1);
		 l3=new JLabel("Contact No");
		 l3.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l3.setForeground(Color.WHITE);
		 l3.setBounds(40,100,140,30);
		 add(l3);
		 t2=new JTextField();
		 t2.setBounds(200,100,150,30);
		 add(t2);
		 l4=new JLabel("Age");
		 l4.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l4.setForeground(Color.WHITE);
		 l4.setBounds(40,140,140,30);
		 add(l4);
		 t3=new JTextField();
		 t3.setBounds(200,140,150,30);
		 add(t3);
		 l5=new JLabel("Gender");
		 l5.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l5.setForeground(Color.WHITE);
		 l5.setBounds(40,180,140,30);
		 add(l5);
		 String gen[]= {"Male","Female","Other"};
		 c1=new JComboBox<>(gen);
		 c1.setBounds(200,180,150,30);
		 add(c1);
		 c1.addActionListener(this);
		 l6=new JLabel("Blodd Group");
		 l6.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l6.setForeground(Color.WHITE);
		 l6.setBounds(40,220,140,30);
		 add(l6);
		 
		 t4=new JTextField();
		 t4.setBounds(200,220,150,30);
		 add(t4);
		 l7=new JLabel("Address");
		 l7.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l7.setForeground(Color.WHITE);
		 l7.setBounds(40,260,140,30);
		 add(l7);
		 
		 t5=new JTextField();
		 t5.setBounds(200,260,150,30);
		 add(t5);
		 l8=new JLabel("Any Major Disease Suffered");
		 l8.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		 l8.setForeground(Color.WHITE);
		 l8.setBounds(40,300,340,30);
		 add(l8);
		 
		 a1=new JTextArea();
		 a1.setBounds(40,340,300,30);
		 add(a1);
		 ImageIcon ic=new ImageIcon(getClass().getResource("/images/icons8-save-48.png"));
		 Image im=ic.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		 
		 
		 save =new JButton(new ImageIcon(im));
		 save.setText("Save");
		 save.setBackground(Color.WHITE);
		 save.setBounds(150,400,120,30);
		 save.setForeground(Color.BLACK);
          add(save);
          save.addActionListener(this);
		 
		 
		 
		 
		ImageIcon icon=new ImageIcon(getClass().getResource("/images/img23.jpg"));
		Image img1 =icon.getImage().getScaledInstance(670, 670, Image.SCALE_DEFAULT);
		l1=new JLabel(new ImageIcon(img1));
		l1.setBounds(0,0,400,450);
		add(l1);
		
		 setSize(400,450);
		 setLocation(400,140);
		 setUndecorated(true);
		 setLayout(null);
		 setVisible(true);
	 }
	
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		int t=0;
		String value=e.getActionCommand();
		if(value.equals("Save"))
		{
			String id=t6.getText();
			  String name=t1.getText();
			  String phone=t2.getText();
			  int age=Integer.parseInt(t3.getText());
			  String gender=(String) c1.getSelectedItem();
			  String blood=t4.getText();
			  String add=t5.getText();
			  String dis=a1.getText();
			  con=DBUtil.getDBConnection();
			  try {
				ps=con.prepareStatement("INSERT INTO PATIENT_INFO VALUES(?,?,?,?,?,?,?,?)");
				ps.setString(1,id);
				ps.setString(2,name);
				ps.setString(3, phone);
				ps.setInt(4, age);
				ps.setString(5,gender);
				ps.setString(6, blood);
				ps.setString(7, add);
				ps.setString(8, dis);
				t=ps.executeUpdate();
				if(t==1)
				{
					JFrame f1=new JFrame();
					JOptionPane.showMessageDialog(f1, "Added Sucessfully");
					dispose();
				}
				
				
				
			} catch (SQLException e1) {
			
				System.out.println("Exception"+e1.getMessage());
			}
			  
		}
		
	}
 
	
}
