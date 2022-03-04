package stock.trading;
//FROM WALLET TO BANK
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
import static stock.trading.Balanceform.taccno;
public class BankForm extends JFrame implements ActionListener{
   static JLabel Amount,Balance,money;
   static JTextField tamount;
   JButton send;
   String tbalance="";
   Container co;
   int no,calbalance;
   Connection con=datatbase.getConnection();
   JFrame f1;
     
     BankForm (int id,JFrame f)
            {
                  co=getContentPane();
                  co.setLayout(null);
                  setTitle("TO BANK");
                  Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\addbanki.png");
                  setIconImage(icon);
                  Amount = new JLabel("Amount");
                  Balance = new JLabel("Balance");
                  tamount=new JTextField();
                  send=new JButton("Send Money"); 
                 
                  
                
                 money=new JLabel(""+balance(id));
                 money.setBounds(200,120,120,25);
                 co.add(money);
                 Amount.setBounds(80,70,120,25);
                 Balance.setBounds(80,120,120,25); 
                 tamount.setBounds(200,70,120,25);
                 no=id;
                 f1=f;
                 send.setBounds(120,180,150,25); 
                 Amount.setFont(new Font("Arial",Font.BOLD,15));
                 Balance.setFont(new Font("Arial",Font.BOLD,15));
                 money.setFont(new Font("Arial",Font.BOLD,15)); 
                 tamount.setFont(new Font("Arial",Font.BOLD,15));
                 send.setFont(new Font("Arial",Font.BOLD,15)); 
                 
                 Amount.setForeground(Color.BLACK);
                 Balance.setForeground(Color.BLACK);
                 money.setForeground(Color.BLACK);
                 tamount.setForeground(Color.BLACK);
                 send.setForeground(Color.BLACK); 
                 
                
                 tamount.setOpaque(false);
                 send.setOpaque(false); 
                 send.setContentAreaFilled(false);
                co.add(Amount);co.add(tamount);co.add(Balance);co.add(send);
                send.addActionListener(this);
                setSize(800,500);
                
                ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/bank.jpg"));
                JLabel back=new JLabel("",img,JLabel.CENTER);
                back.setBounds(0, 0,800,500);
                add(back);
                setVisible(true);
                
            }
     String balance(int id)
     {
         try{
              
                
               
                String q="select * from wallet where ID=?";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setInt(1,id);
                 ResultSet rst=pstmt.executeQuery();
               while(rst.next())
               {
                   tbalance=Integer.toString(rst.getInt("balance"));
                  
               }
           
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Unable to fetch data from wallet"+ex.toString());
            }
            
     return tbalance;
     }
     int bank(int id)
     {
         String data[]=new String[2];
          try{
            
            Statement s=con.createStatement();
            
            String sql="select * from UserPro where id='"+id+"'";                
            ResultSet r=s.executeQuery(sql);
            while(r.next()){
                data[0]=r.getString("account");                      
                data[1]=r.getString("ifsc");
                
            } 
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to fetch balance from Profile");
            }
          int balance=bankbalance(data);
          return balance;
     }
     
     String account(int id)
     {
         String data[]=new String[2];
          try{
             
            Statement s=con.createStatement();
            
            String sql="select * from UserPro where id='"+id+"'";               
            ResultSet r=s.executeQuery(sql);
            while(r.next()){
                data[0]=r.getString("account");                      
                data[1]=r.getString("ifsc");
                
            } 
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to fetch data from Profile"+ex.toString());
            }
         
          return data[0];
     }
     int bankbalance(String[] data)
     {
         int value=0;
          try{
           
            
           String sql="select balance from bank where AccountNo=? and IFSCCODE=?";               
           PreparedStatement pt=con.prepareStatement(sql);

                       pt.setString(1,data[0]);
                       pt.setString(2,data[1]);
                    ResultSet r=pt.executeQuery();
            while(r.next()){
                value=r.getInt("balance");
                
            } 
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to fetch Account No & IFSC"+ex.toString());
            }
          return value;
     }
     void updatewallet(int id)
        {
            try
            {
                System.out.print(""+id);
               int s=wallet(id);
               System.out.print("up"+id);
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
                JOptionPane.showMessageDialog(this, "Unable to Update Balance");
            }
        }
        int wallet(int id)
        {
             try
            {
               
             int    int_Amount=Integer.parseInt(tamount.getText());
           
                System.out.print("wall"+id);
                String q="select * from wallet where ID=?";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setInt(1,id);
                 ResultSet rst=pstmt.executeQuery();
               while(rst.next())
               {
                   calbalance=rst.getInt("balance");
                  
               }
               calbalance=calbalance-int_Amount;
           
            
                   
            }
             catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to Fetch Data From Wallet"+ex.toString());
            }
             return calbalance;
        }
     public void actionPerformed(ActionEvent ae){
         
Object obj_source=ae.getSource();

        if(obj_source==send){
            try{
               
                int    int_amo=Integer.parseInt(tamount.getText());
                
                int label = Integer.parseInt(money.getText());
                int balance=bank(no);
                String accountno=account(no);
                
                if(int_amo<label)
                {
                   balance=balance+int_amo;
                   
                   
                   
                   
                   String query="update bank set balance=? where AccountNo=?";
                   PreparedStatement stmt=con.prepareStatement(query);
                   stmt.setInt(1,balance);
                   stmt.setString(2,accountno);
                   stmt.executeUpdate();
                   
                   con.setAutoCommit(true);
                   JOptionPane.showMessageDialog(this, "Added to Bank");
                   updatewallet(no);
                  
                  
                   
                    f1.dispose();
                    dispose();
                    new StockTrading(no);
                    
                }
                else
                   JOptionPane.showMessageDialog(this, "Amount Exceeded");

            }
            
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Unable to Connect with Bank");
            }
            }
            
        
     }
            public static void main(String args[])
            {
               
            }
    
}
