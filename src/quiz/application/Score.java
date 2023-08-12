
package quiz.application;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Score extends JFrame implements ActionListener
{
	public static Scanner scan = new Scanner(System.in);
	public static Connection c;
	Statement s;

    Score(String name, int score)
    {
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0,200,300,250);
        add(image);
        
        JLabel heading = new JLabel("Thank You "+ name+" For Completing Quiz");
        heading.setFont(new Font("Viner Hat ITC", Font.BOLD, 32));
        heading.setForeground(Color.MAGENTA);
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is  "+ score);
        lblscore.setBounds(350,200,700,30);
        lblscore.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(lblscore);
        
        JButton submit = new JButton("Play again");
        submit.setBounds(380,270,120,30);
//        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application","root","Spectrum@123");
        	PreparedStatement p=con.prepareStatement("insert into Quiz_Result values(?,?)");
        	p.setString(1, name);
        	p.setInt(2, score);
        	
        	int rs=p.executeUpdate();
        	System.out.println("Connection Successful ");
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }


        setVisible(true);
   
        
    }
    public void actionPerformed(ActionEvent e)
    {	
    	
        setVisible(false);
        try {
       	 Statement s = c.prepareStatement("insert into Quiz_Result values(name, score)");
       	 
       	 System.out.println("Inserted Successfully");
       	 } 
        catch (Exception ae) 
        {
       	 System.out.println(ae);
       	 }
        new Login();
    }
    


public static void main(String []args) throws Exception
{
new Score("User", 0);

}
}
