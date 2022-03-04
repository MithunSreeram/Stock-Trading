package stock.trading;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import connection.datatbase;
public class addstock extends JFrame implements ActionListener
{
    Container c;
    JLabel sname,svalue,scount,sicon;
    JTextField Sname,Svalue,Scount,Sicon;
    JButton add;
    int q=1000;
    addstock()
    {
        c=getContentPane();
        c.setLayout(null);
        setTitle("ADD STOCK");
       
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\addstocki.png");
        setIconImage(icon);
       
        sname=new JLabel("Stock Name");
        svalue=new JLabel("Stock Value");
        scount=new JLabel("Stock Count");
        sicon=new JLabel("Stock Icon");
         sname.setFont(new Font("Arial",Font.PLAIN,15));
        svalue.setFont(new Font("Arial",Font.PLAIN,15));
        scount.setFont(new Font("Arial",Font.PLAIN,15));
        sicon.setFont(new Font("Arial",Font.PLAIN,15));
        sname.setForeground(Color.WHITE);
        svalue.setForeground(Color.WHITE);
        scount.setForeground(Color.WHITE);
        sicon.setForeground(Color.WHITE);
        
        Sname=new JTextField();
        Svalue=new JTextField();
        Scount=new JTextField();
        Sicon=new JTextField();
        Sname.setFont(new Font("Arial",Font.PLAIN,15));
        Svalue.setFont(new Font("Arial",Font.PLAIN,15));
        Scount.setFont(new Font("Arial",Font.PLAIN,15));
        Sicon.setFont(new Font("Arial",Font.PLAIN,15));
        
        Sname.setForeground(Color.WHITE);
        Svalue.setForeground(Color.WHITE);
        Scount.setForeground(Color.WHITE);
        Sicon.setForeground(Color.WHITE);
        Sname.setCaretColor(Color.WHITE);
        Svalue.setCaretColor(Color.WHITE);
        Scount.setCaretColor(Color.WHITE);
        Sicon.setCaretColor(Color.WHITE);
        add=new JButton("ADD");
        add.addActionListener(this);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial",Font.PLAIN+Font.PLAIN,20));
        
        
        
        //sid.setBounds(100 ,50 ,120 ,25);
        sname.setBounds(100 ,100 ,120 ,25);
        svalue.setBounds(100 ,150 ,120 ,25);
        scount.setBounds(100 ,200 ,120 ,25);
        sicon.setBounds(100,250,120,25);
        //Sid.setBounds(230 ,50 ,120 ,25);
        Sname.setBounds(230 ,100 ,120 ,25);
        Svalue.setBounds(230 ,150 ,120 ,25);
        Scount.setBounds(230 ,200 ,120 ,25);
        Sicon.setBounds(230,250,120,25);
        add.setBounds(160 ,300 ,120 ,25);
        Sname.setOpaque(false);
        Svalue.setOpaque(false);
        Scount.setOpaque(false);
        Sicon.setOpaque(false);
        add.setOpaque(false);
        add.setContentAreaFilled(false);
        add.addActionListener(this);
        //add(sid);
        add(sname);
        add(svalue);
        add(scount);
        add(sicon);
        //add(Sid);
        add(Sname);
        add(Svalue);
        add(Scount);
        add(Sicon);
        add(add);
        
        try
        {
            Connection con = datatbase.getConnection();
            String S = "select sid from Stock";
            PreparedStatement P = con.prepareStatement(S);
            ResultSet R = P.executeQuery();
            while(R.next())
            {
                int prevId=R.getInt("sid");
                q=prevId;
            }
            
        }
        catch(Exception e)
        {
            if(q==1000)
            {
                JOptionPane.showMessageDialog(this,"Default Id Initialized!");
                try
                {
                    Connection con = datatbase.getConnection();
                    String s = "insert into Stock values(1000,'stock',1000,50,'hai')";
                    PreparedStatement p = con.prepareStatement(s);
                    p.executeUpdate();
                    con.setAutoCommit(true);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this,e);
                }
            }   
            else
                JOptionPane.showMessageDialog(this,"Id capture Failed!");
        }
        
        setSize(600,700);
         ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/home.jpg"));
          JLabel back=new JLabel("",img,JLabel.CENTER);
          back.setBounds(0,0,600,700);
          add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent v)
    {
        Object obj=v.getSource();
        if(obj==add)
        {
            try
            {
                //int SID=Integer.parseInt(Sid.getText());
                int SID=q+1;
                String SNAME=Sname.getText();
                int SVALUE=Integer.parseInt(Svalue.getText());
                int SCOUNT=Integer.parseInt(Scount.getText());
                String SICON=Sicon.getText();
                
                Connection con=datatbase.getConnection();
                String S="insert into Stock values(?,?,?,?,?)";
                PreparedStatement P=con.prepareStatement(S);
                P.setInt(1, SID);
                P.setString(2, SNAME);
                P.setInt(3, SVALUE);
                P.setInt(4, SCOUNT);
                P.setString(5,SICON);
                String s="alter table Trade add "+SNAME+" number(4) default(0)";
                Statement p=con.createStatement();
                //p.setString(1, SNAME);
                p.executeUpdate(s);
                P.executeUpdate();
                //p.executeUpdate();
                
                con.setAutoCommit(true);
                JOptionPane.showMessageDialog(this,"Stock Addition Success!");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Stock Addition Failed");
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }
    public static void main(String a[])
    {
        new addstock();
    }
}