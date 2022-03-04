package stock.trading;
import connection.datatbase;
import java.sql.*;
import javax.swing.JOptionPane;

public class Stock 
{
    Stock()
    {
       try
       {
           Connection con=datatbase.getConnection();
            String S="select sid from Stock";
            PreparedStatement P=con.prepareStatement(S);
            ResultSet R=P.executeQuery();
            while(R.next())
            {
                int n=R.getInt("sid");
                int a=0;
                try
                {
                    String s1="select * from Stock where sid=?";
                    PreparedStatement p1=con.prepareStatement(s1);
                    p1.setInt(1,n);
                    ResultSet r1=p1.executeQuery();
                    if(r1.next())
                    {
                        a=r1.getInt("svalue");
                    }
                   
                    int min=1,max=50,min1=1,max1=10,b=(int)(Math.random()*(max-min+1)+min),c=(int)(Math.random()*(max1-min1+1)+min1);
                    if(c>5)
                    {
                        if(a+b>a*2)
                            a-=b;
                        else if(a-b<=a/2)
                            a+=b;
                        else
                            a+=b;
                    }
                    else
                    {
                        if(a-b<=a/2)
                            a+=b;
                        else if(a+b>a*2)
                            a-=b;
                        else
                            a-=b;
                    }
                    if(a<0)
                        a+=b;
                    String s="update Stock set svalue=? where sid=?";
                    PreparedStatement p=con.prepareStatement(s);
                    p.setInt(1,a);
                    p.setInt(2,n);
                    p.executeUpdate();
                    con.setAutoCommit(true);
                }
                catch(Exception e)
                {
                     JOptionPane.showMessageDialog(null,"Stock Values Updation Failed");
                }
            }
       }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Stock Values Updation Failed");
        }
    }
    Stock(int n)
    {
        while(true){
        int a=0;
        try
        {
            Connection con=datatbase.getConnection();
            String S="select * from Stock where sid=?";
            PreparedStatement P=con.prepareStatement(S);
            P.setInt(1,n);
            ResultSet R=P.executeQuery();
            if(R.next())
            {
                a=R.getInt("svalue");
            }
            int min=1,max=100,min1=1,max1=10,b=(int)(Math.random()*(max-min+1)+min),c=(int)(Math.random()*(max1-min1+1)+min1);
            if(c>5)
            {
                if(a+b>a*2)
                    a-=b;
                else if(a-b<=a/2)
                    a+=b;
                else
                    a+=b;
            }
            else
            {
                if(a-b<=a/2)
                    a+=b;
                else if(a+b>a*2)
                    a-=b;
                else
                    a-=b; 
            }
            String s="update Stock set svalue=? where sid=?";
            PreparedStatement p=con.prepareStatement(s);
            
            p.setInt(1,a);
            p.setInt(2,n);
            p.executeUpdate();
            con.setAutoCommit(true);
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Stock Values Updation Failed");
        }
    }
    }
    Stock(String n,int m,String x)
    {
        int a=0;
        try
        {
            Connection con=datatbase.getConnection();
            String S="select * from Stock where sname=?";
            PreparedStatement P=con.prepareStatement(S);
            P.setString(1,n);
            ResultSet R=P.executeQuery();
            if(R.next())
            {
                a=R.getInt("svalue");
            }
            int min=0,max=2,b=(int)(Math.random()*(max-min+1)+min);
            if(x.equals("buy"))
            {
                a+=m*b;
            }
            else
            {
                a-=m*b;
            }
            String s="update Stock set svalue=? where sname=?";
            PreparedStatement p=con.prepareStatement(s);
            p.setInt(1,a);
            p.setString(2,n);
            p.executeUpdate();
            con.setAutoCommit(true);
        }
        catch(Exception e)
        {
           
        }
    }
    public static void main(String ar[])
    {
      
    }
}
