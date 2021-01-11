package hosp.info;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class LoginJFrame extends JFrame implements ActionListener{
	JLabel l2,l3;
	JTextField t1;
	JPasswordField pf1;
	JButton b1;
	public static Connection con;
	public static PreparedStatement ps;
	public LoginJFrame()
	{
		ImageIcon icon=new ImageIcon(getClass().getResource("/images/img3.png"));
		Image img=icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		JLabel l1=new JLabel(new ImageIcon(img));
		l1.setBounds(10,100,200,200);
		add(l1);
		
		l2=new JLabel("Username");
		l2.setBounds(250,100,100,30);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("BOLD",20,20));
		l3=new JLabel("Password");
		l3.setBounds(250,200,100,30);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("BOLD",20,20));
		t1=new JTextField();
		t1.setBounds(350,100,100,30);
		pf1=new JPasswordField();
		pf1.setBounds(350,200,100,30);
		b1=new JButton("Login");
		b1.setBounds(290,270,90,30);
		b1.addActionListener(this);
		add(l2);
		add(l3);
		add(t1);
		add(pf1);
		add(b1);
		setUndecorated(true);
		
		getContentPane().setBackground(Color.BLACK);
		setSize(600,350);
		setLocation(400,150);
		setLayout(null);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
	    String value=b1.getActionCommand();
	    if(value.equals("Login"))
	    {
	    	con=DBUtil.getDBConnection();
	    	String user =t1.getText();
	    	String pass=pf1.getText();
	    	try
	    	{
	    	ps=con.prepareStatement("SELECT * FROM ADMIN WHERE Username=? AND Password=?");
	    	ps.setString(1,user );
	    	ps.setString(2, pass);
	    	ResultSet rs=ps.executeQuery();
	    	if(rs.next())
	    	{
	    		dispose();
	    		BackgroundJFrame.p1.setVisible(true);
	    		
	    	}
	    	else
	    	{
	    		JFrame f1=new JFrame();
	    		JOptionPane.showMessageDialog(f1,"Invalid credentials");
	    		t1.setText("");
	    		pf1.setText("");
	    	}
	    	}
	    	catch(SQLException e1)
	    	{
	    		System.out.println("Exception "+e1.getMessage());
	    	}
	    	
	    }
		
	}

}
