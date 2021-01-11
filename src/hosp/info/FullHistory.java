package hosp.info;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
public class FullHistory extends JFrame 
{
	JLabel l1,l2;
	 JTable table;
	public static Connection con;
	public static PreparedStatement ps;
   
	public FullHistory() 
	{
		getContentPane().setForeground(Color.BLACK);
		
		
		
		
		 
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(0, 79, 600, 234);
		 getContentPane().add(scrollPane);
		 
		 table = new JTable();
		 scrollPane.setViewportView(table);
		 con=DBUtil.getDBConnection();
			try {
				ps=con.prepareStatement("SELECT * FROM FULL_HISTORY");
				ResultSet rs=ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
		 
		  l2=new JLabel("FULL HISTORY");
		  l2.setForeground(Color.red);
		  l2.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		 l2.setBounds(250,40,150,50);
		 add(l2);
		 
		 
		 ImageIcon icon=new ImageIcon(getClass().getResource("/images/img23.jpg"));
			Image img1 =icon.getImage().getScaledInstance(670, 670, Image.SCALE_DEFAULT);
			l1=new JLabel(new ImageIcon(img1));
			l1.setBounds(0,0,600,450);
			getContentPane().add(l1);
		 
		 
		 setSize(600,450);
		 setLocation(400,140);
		 setUndecorated(true);
		 getContentPane().setLayout(null);
		 setVisible(true);
	}
	
}
