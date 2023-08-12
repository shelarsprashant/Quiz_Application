package quiz.application;

import java.sql.*;
import java.util.*;

public class Conn 
{
	public static Connection c;

    Statement s;
    public Conn()
    {
        try
        {
           c = DriverManager.getConnection("jdbc:mysql:///localhost","root","PR@SH@NT123");
           s = c.createStatement();
        }
        catch (Exception e )
        {
            System.out.println(e);
        }
    }
    
    
}