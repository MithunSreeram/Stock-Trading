package stock.trading;
import connection.datatbase;
import java.util.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;
import sun.java2d.pipe.DrawImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.ObjectOutput;
import java.net.*;
import java.io.*;
import java.sql.*;


class BuyForm extends JFrame {
    JLabel txt_available,balance;JComboBox txt_stocks;
    String balance_str="",stk_name="";
    int[] count=new int[2];int value=0,stk_bought=0,balamt=0,total=0,stockx=0;
    ArrayList<String> stock;
        int i=0,n;
        int q,stockbuy;
        String process,stockname;
    public BuyForm(int uid,JFrame f){
        
super("BUY PRODUCT");
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\addstk2.jpg");
        setIconImage(icon);
        setLayout(null);
        setBounds(50, 10, 640, 850);
        setResizable(false);
        setTitle("BUY PRODUCT");
        q=uid;
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DateTimeFormatter date=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timee=DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        JLabel head=new JLabel("BUY PRODUCTS ");
        head.setForeground(Color.WHITE);
        head.setBounds(150, 20, 800, 120);
       
        add(head);
        JLabel id=new JLabel("USER ID :");
        JLabel txt_id=new JLabel(Integer.toString(uid));          //to dis id
        JLabel balance=new JLabel("BALANCE :"+bal(uid));         //to set balance in top
        
        JLabel error=new JLabel();
        JLabel dates=new JLabel("DATE ");
        JLabel time=new JLabel("TIME ");
        JLabel stock_name=new JLabel("STOCKS ");
        JLabel available_stocks=new JLabel("STOCKS AVAILABLE ");
        JLabel stock_tobuy=new JLabel("NO OF STOCKS ");
 
        
        
        //id.setForeground(Color.WHITE);
        //txt_id.setForeground(Color.WHITE);          //to dis id
        balance.setForeground(Color.WHITE);        //to set balance in top
        dates.setForeground(Color.WHITE);
        time.setForeground(Color.WHITE);
        stock_name.setForeground(Color.WHITE);
        available_stocks.setForeground(Color.WHITE);
        stock_tobuy.setForeground(Color.WHITE);
        error.setForeground(Color.WHITE);
        
        //txt_id.setBounds(400,200,100,25);
        //id.setBounds(100, 200, 150, 25);
        dates.setBounds(100, 250, 100, 25);
        time.setBounds(100, 300, 100, 25);
        stock_name.setBounds(100, 350, 120, 25);
        available_stocks.setBounds(100, 400, 220,25);
        stock_tobuy.setBounds(100, 450, 180,25);error.setBounds(200, 530, 400, 80);
      
        //add(id);add(txt_id);
        add(dates);
        add(time);
        add(stock_name);
        add(available_stocks);
        add(stock_tobuy);add(error);
        
        head.setFont(new Font("Arial",Font.BOLD,30)); balance.setFont(new Font("Arial",Font.BOLD,20));
        
        id.setFont(new Font("Arial",Font.BOLD,20));
        txt_id.setFont(new Font("Arial",Font.BOLD,20));
        dates.setFont(new Font("Arial",Font.BOLD,20));
        time.setFont(new Font("Arial",Font.BOLD,20));
        stock_name.setFont(new Font("Arial",Font.BOLD,20));
        available_stocks.setFont(new Font("Arial",Font.BOLD,20));
        stock_tobuy.setFont(new Font("Arial",Font.BOLD,20));
        error.setFont(new Font("Arial",Font.BOLD,20));
        
        JTextField txt_dates,txt_time,txt_stockBought;
         
        txt_dates=new JTextField();
        txt_dates.setFont(new Font("Arial",Font.BOLD,15));
        txt_dates.setForeground(Color.WHITE);
        txt_dates.setOpaque(false);
        txt_dates.setBounds(400,249,100,25);
        add(txt_dates);
        txt_dates.setText(date.format(now));
        
        txt_time=new JTextField();
        txt_time.setFont(new Font("Arial",Font.BOLD,15));
        txt_time.setForeground(Color.WHITE);
        txt_time.setOpaque(false);
        txt_time.setBounds(400,300,100,25);
        add(txt_time);
        txt_time.setText(timee.format(now));
        
        txt_stockBought=new JTextField();
        txt_stockBought.setFont(new Font("Arial",Font.BOLD,15));
        txt_stockBought.setOpaque(false);
        txt_stockBought.setForeground(Color.WHITE);
        txt_stockBought.setBounds(400,449,100,25);
        add(txt_stockBought);
        
        txt_available=new JLabel();
        txt_available.setForeground(Color.WHITE);
        txt_available.setOpaque(false);
        txt_available.setBounds(400,398,100,25);
        add(txt_available);
        txt_available.setFont(new Font("Arial",Font.BOLD,15));
               
        JButton buy=new JButton("BUY");
        buy.setOpaque(false);
        buy.setForeground(Color.WHITE);
        buy.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,15));
        buy.setContentAreaFilled(false);
        buy.setBounds(420,600,80,25);
        add(buy);
        balance.setBounds(120,580,200,60);add(balance);
        
        
        txt_stocks=new JComboBox();
        stock=names();
                n=stock.size();
                while(i<n)
                {
                    txt_stocks.addItem(stock.get(i));
                    i++;
                }
                
        txt_stocks.setBounds(400, 350, 100, 30);
        add(txt_stocks);
        setLayout(new BorderLayout());
      
        txt_stocks.addActionListener(new ActionListener(){          //to get no of stocks choosen
             public void actionPerformed(ActionEvent e) {
                 stk_name=(String)txt_stocks.getSelectedItem();
                 int count []=dis(stk_name,uid);                      //count[0]=stock count,count[1]=stock valuue
             }
         });
                
        txt_stockBought.addKeyListener(new KeyListener() {              //condition to buy
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                stk_bought=Integer.parseInt(txt_stockBought.getText());
                if(count[0]>=stk_bought){
                    error.setVisible(false);
                    txt_stockBought.setForeground(Color.green);
                }
                else{
                    txt_stockBought.setForeground(Color.red);
                    error.setText("INADEQUATE NO OF STOCKS !");
                    error.setVisible(true);
                }    
            }    
        });
         
        
        
        ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/buyye.jpg"));
        JLabel back=new JLabel("",img,JLabel.CENTER);
        back.setBounds(0,0,640,850);
        add(back);
        setVisible(true); 
        
        
        buy.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            int balncetamnt=stk_bought*count[1];                                        //cost for product
            if(balncetamnt>balamt){                                             //balance checking
            error.setText("INSUFFICIENT BALANCE !");
            error.setVisible(true);
            }
            else{
            balupd(uid,stk_name,balamt-balncetamnt,count[0]-stk_bought);                  //update balance and stock count
            Object o=e.getSource();
       //inserting data to trade table
            if(o==buy){
             stockbuy=Integer.parseInt(txt_stockBought.getText());
             stockname=txt_stocks.getSelectedItem().toString();
            String dates=txt_dates.getText();
            String time=txt_time.getText();
             process="buy";
           try
           {
               Connection con=datatbase.getConnection();
           Statement stmt=con.createStatement();
           String query="insert into orderhis values("+uid+",'"+process+"','"+dates+"','"+time+"','"+stockname+"',"+stockbuy+","+count[1]+","+balncetamnt+")";
            stmt.executeUpdate(query);
             String email="";
        
        if(process.equals("buy"))
            process="Buying";
        else
            process="Selling";
        String message="Thanks For "+process+" "+Integer.toString(stockbuy)+" Stocks in "+stockname+"!\n"+"Have A Good Day And Invest More!";
        try
        {
           // Connection con=datatbase.getConnection();
            String S="select email from UserPro where id=?";
            PreparedStatement P=con.prepareStatement(S);
            P.setInt(1,q);
            ResultSet R = P.executeQuery();
            if(R.next())
            {
                email=R.getString("email");
            }
            System.out.print(""+email);
            
        }
        catch(Exception eq)
        {
            System.out.println(eq);
        }
        new mail(email,message);
            insert(uid,stockbuy,stockname);
            f.dispose();
            new StockTrading(uid);
           }
           catch(Exception e1)
           {
               
           }
           
             }
             }}
         });
        
    }
    
    
    
      String bal(int a){                                                        //to set balance in top
         
         try{
            Connection con=datatbase.getConnection();
          
            Statement s=con.createStatement();
           String sql="select balance from wallet where id="+a+"";                  //wallet db using id(a)    
            ResultSet r=s.executeQuery(sql);
            while(r.next()){                     
                balance_str=r.getString("balance");                                           //age->balance    
            }
            balamt=Integer.parseInt(balance_str);
            con.setAutoCommit(true);}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to connect with Bank"+e.toString());
        }   
        return balance_str;
     }
    
    void insert(int uid,int stockbuy,String stock_name){                        
    
        try{ 
           Connection con=datatbase.getConnection();
            Statement s=con.createStatement();
            String sql="select * from trade where id="+uid+"";      
            s.executeUpdate(sql);
            ResultSet r=s.executeQuery(sql);
            while(r.next()){
                
                stockx=Integer.parseInt(r.getString((String)txt_stocks.getSelectedItem()));   
               
            }
            total=stockbuy+stockx;
            String sql1="update trade set "+stock_name+"= "+total+"  where id="+uid+" ";
            Statement s1=con.createStatement();
            s1.executeUpdate(sql1);
            con.setAutoCommit(true);
            JOptionPane.showMessageDialog(this, "THANKS FOR BUYING:) ");
            new Stock();
            new Stock(stockname,stockbuy,process);
            dispose();
            
        }
            catch(Exception e){
            JOptionPane.showMessageDialog(this, "Unable to Connect with Trade"+e.toString());
        }  
     }
    ArrayList<String> names(){                                                        
        ArrayList<String> allname=new ArrayList<>();
        try{
            
           Connection con=datatbase.getConnection();
           
           String query="select sname from Stock ";
           PreparedStatement pstmt=con.prepareStatement(query);
           ResultSet rs = pstmt.executeQuery();
           int k=0;
        while (rs.next()) {
           
               allname.add(rs.getString("sname"));
               
        }
        con.setAutoCommit(true);
        }
        
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Exception=***7==>"+e.toString());
       }   
               
            
       return allname;
    } 
    int[] dis(String stk_name,int a){                                                   //to display avail stock
        try{
           Connection con=datatbase.getConnection();
            Statement s=con.createStatement();
            
            String sql="select * from stock where sname='"+stk_name+"'";                //stock db
            ResultSet r=s.executeQuery(sql);
            while(r.next()){
                txt_available.setText(r.getString("scount"));
                count[0]=Integer.parseInt(r.getString("scount"));                         //avail
                count[1]=Integer.parseInt(r.getString("svalue"));                         //value                                  
            }
            con.setAutoCommit(true);}
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Unable to Select Contents from Stock"+e.toString());
        }   
        return count;
    }
    
    void balupd(int id,String stk_name,int baln,int stcount){                       //to update balance and stock cnt in wallet and stock db
        
        try{
            Connection con=datatbase.getConnection();
            Statement s=con.createStatement();
            balamt=baln;
            String sql="update wallet set balance="+baln+" where id="+q+"";//hema->wallet db& fname->id
            String sql1="update stock set scount="+stcount+" where sname='"+stk_name+"'";  
           
            ResultSet r1=s.executeQuery(sql1);
            ResultSet r=s.executeQuery(sql);
            con.setAutoCommit(true);}
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Unable to Update in Wallet and Stock"+e.toString());
        } 
    }
     public static void main(String sts[]){
       
    }
}