package stock.trading;
//BANK TO WALLET FORM
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;
import connection.datatbase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Balanceform extends JFrame implements ActionListener{
  
   static JLabel Accno,Ifsc,Amount;
   static JTextField taccno,tifsc,tamount;
   JButton add;
   Container co;
   int calbalance;
   int id;
   String data[]=new String[2];
   String    int_Accno;
   String string_ifsc;
   int    int_Amount;
    String details[]=new String[2];
    Connection con=datatbase.getConnection();
    JFrame f1;
   Balanceform (int no,JFrame f)
      {
                
        co=getContentPane();
        co.setLayout(null);
        setTitle("TO WALLET");
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\addwalleti.png");
        setIconImage(icon);
        Accno=new JLabel("ACCOUNT NO");
        Ifsc=new JLabel("IFSC CODE");
        Amount=new JLabel("AMOUNT");
        taccno=new JTextField();
        tifsc=new JTextField();
        tamount=new JTextField();
        add=new JButton("Add");
        add.addActionListener(this);
        Accno.setBounds(50,80,120,25);
        Ifsc.setBounds(50,130,120,25);
        Amount.setBounds(50,180,120,25);
        taccno.setBounds(170,80,150,25);
        tifsc.setBounds(170,130,150,25);
        tamount.setBounds(170,180,150,25);
        add.setBounds(100,250,120,25);
        id=no;
        f1=f; 
        
        
        Amount.setFont(new Font("Arial",Font.BOLD,15));
        Accno.setFont(new Font("Arial",Font.BOLD,15));
        Ifsc.setFont(new Font("Arial",Font.BOLD,15)); 
        
        taccno.setFont(new Font("Arial",Font.BOLD,15));
        tifsc.setFont(new Font("Arial",Font.BOLD,15));
        tamount.setFont(new Font("Arial",Font.BOLD,15)); 
        
        Amount.setForeground(Color.WHITE);
        Accno.setForeground(Color.WHITE);
        Ifsc.setForeground(Color.WHITE);  
        add.setForeground(Color.WHITE);  
        
        taccno.setOpaque(false);
        tifsc.setOpaque(false);
        tamount.setOpaque(false);
        tamount.setForeground(Color.WHITE);
        taccno.setForeground(Color.WHITE);
        tifsc.setForeground(Color.WHITE);  
        add.setOpaque(false); 
        add.setContentAreaFilled(false);
        
        
        
        
        details=fetch(no);
        co.add(Accno);
        co.add(add);
        co.add(Ifsc);
        co.add(Amount);
        co.add(tifsc);
        co.add(taccno);
        co.add(tamount);
        
                 
        setSize(800,500);
        ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/wallet.jpg"));
        JLabel back=new JLabel("",img,JLabel.CENTER);
        back.setBounds(0, 0,800,500);
        add(back);
        setVisible(true);

        
    }  
        public void actionPerformed(ActionEvent ae){
         
        Object obj_source=ae.getSource();

        if(obj_source==add){
            
            try{
              
               
                    int_Accno=details[0];
                 string_ifsc= details[1];
                    int_Amount=Integer.parseInt(tamount.getText());
                 int balance=fbalance(int_Accno);
                 balance=balance-int_Amount;
                   
                  
                   
                   String query="update bank set balance=? where AccountNo=?";
                   PreparedStatement stmt=con.prepareStatement(query);
                   stmt.setInt(1,balance);
                   stmt.setString(2,int_Accno);
                   stmt.executeUpdate();
                   con.setAutoCommit(true);
                   JOptionPane.showMessageDialog(this, "Money Added!");
                   updatewallet(id);
                    f1.dispose();
                    dispose();
            new StockTrading(id); 


            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Unable to connect to Bank");
            }
            
            
            }
            
                
        }
        String[] fetch(int a)
        {
           
            try{
             
            Statement s=con.createStatement();
            
            String sql="select * from UserPro where id='"+a+"'";            
            ResultSet r=s.executeQuery(sql);
            while(r.next()){
                data[0]=r.getString("account");                         
                data[1]=r.getString("ifsc");
                taccno.setText(data[0]);
                 taccno.setEditable(false);
                 tifsc.setText(data[1]);
                 tifsc.setEditable(false);                                  
            } 
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to Fetch data from Profile");
            }
            return data;
         }
        int fbalance(String acc)
        {
         int ret=0;
            try{
              
            Statement s=con.createStatement();
            
            String sql="select Balance from Bank where AccountNo='"+acc+"'";            
            ResultSet r=s.executeQuery(sql);
            while(r.next()){
                ret=r.getInt("Balance");                    
                                                                      
            } 
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to fetch Balance from ");
            }
            return ret;
        }
        void updatewallet(int id)
        {
            try
            {
               int s=wallet(id);
              
               
                String q="update wallet set balance=? where ID=?";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setInt(1,s);
                pstmt.setInt(2,id);
                pstmt.executeUpdate();
               con.setAutoCommit(true);
            
                   JOptionPane.showMessageDialog(this, "Balance Updated");
            }
             catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Failed To Update Balance");
            }
        }
        int wallet(int id)
        {
             try
            {
               
             int    int_Amount=Integer.parseInt(tamount.getText());
           
               
                String q="select * from wallet where ID=?";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setInt(1,id);
                 ResultSet rst=pstmt.executeQuery();
               while(rst.next())
               {
                   calbalance=rst.getInt("balance");
                  
               }
               calbalance=calbalance+int_Amount;
           
            
                   
            }
             catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to Fetch from Wallet");
            }
             return calbalance;
        }
            
    public static void main(String args[])
    {
       
    }
}
