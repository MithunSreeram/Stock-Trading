package stock.trading;
import connection.datatbase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import oracle.sql.DATE;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

 class Sellform extends JFrame {
	JLabel lid,total_stock,lname,ltotal_stock,dates,times,sell_stock, text_id,error,bal_dis,title,background;
	JTextField tsell_stock,tdate,ttime,tbalance;
	JComboBox name;
	JButton sell; 
	Container con;
	int value=0,balamt=0;
	int stock_sell=0,v=0,bs=0,bt=0;
	int []count=new int[3]; 
	String stk_name="",p="";
	String balance=""; 
        String process,stockname;
        int counting,p2,q,counting3;
        ArrayList<String> stock;
        int i=0,n;
	public Sellform(int a,JFrame f) {
		setBounds(300, 90, 900, 600); 
     
        setResizable(true); 
       
        
		con=getContentPane(); 
		con.setLayout(null); 
		setTitle("SELL PRODUCT");
                Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\sell.jpg");
                setIconImage(icon);
		
		DateTimeFormatter date=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter time=DateTimeFormatter.ofPattern("hh:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		JLabel head=new JLabel("SELL PRODUCTS");
                 head.setForeground(Color.WHITE);
              head.setOpaque(false);
      head.setFont(new Font("Arial",Font.BOLD|Font.BOLD,30));
		head.setBounds(150, 20, 800, 120);
             
	     dates=new JLabel("DATE");
             dates.setForeground(Color.WHITE);
             dates.setOpaque(false);
             dates.setFont(new Font("Arial",Font.BOLD,20));
	     times=new JLabel("TIME");
             times.setForeground(Color.WHITE);
             times.setOpaque(false);
             times.setFont(new Font("Arial",Font.BOLD,20));
	     total_stock=new JLabel("TOTAL STOCKS"); 
             
             total_stock.setForeground(Color.WHITE);
             total_stock.setOpaque(false);
             total_stock.setBorder(null);
             total_stock.setFont(new Font("Arial",Font.BOLD,20));
             sell_stock=new JLabel("STOCKS TO SELL");
             sell_stock.setForeground(Color.WHITE);
             sell_stock.setOpaque(false);
             sell_stock.setFont(new Font("Arial",Font.BOLD,20));
       
		lname=new JLabel("STOCKS"); 
               lname.setForeground(Color.WHITE);
                 lname.setOpaque(false);
                 lname.setFont(new Font("Arial",Font.BOLD,20));
		error=new JLabel();
                error.setForeground(Color.WHITE);
                error.setOpaque(false);
                error.setFont(new Font("Arial",Font.BOLD,20));
	        bal_dis=new JLabel("BALANCE :"+balance(a));    
                bal_dis.setForeground(Color.WHITE);
                  bal_dis.setOpaque(false);
            bal_dis.setFont(new Font("Arial",Font.BOLD,20));
                                                                                        
	        text_id=new JLabel(Integer.toString(a)); 
                text_id.setForeground(Color.WHITE);
                text_id.setOpaque(false);
                text_id.setFont(new Font("Arial",Font.BOLD,15));
		tdate=new JTextField(date.format(now));
                 tdate.setForeground(Color.WHITE);
       tdate.setOpaque(false);
       tdate.setFont(new Font("Arial",Font.BOLD,15));
		ttime=new JTextField(time.format(now));
                 ttime.setForeground(Color.WHITE);
       ttime.setOpaque(false);
       ttime.setFont(new Font("Arial",Font.BOLD,15));
		ltotal_stock=new JLabel();
                 ltotal_stock.setForeground(Color.WHITE);
       ltotal_stock.setOpaque(false);
     ltotal_stock.setFont(new Font("Arial",Font.BOLD,15));
                
		tsell_stock=new JTextField(); 
                 tsell_stock.setForeground(Color.WHITE);
                  tsell_stock.setOpaque(false);
                    tsell_stock.setFont(new Font("Arial",Font.BOLD,15));
	        name=new JComboBox();
             
               name.setOpaque(false);

                stock=names();
                n=stock.size();
                while(i<n)
                {
                   name.addItem(stock.get(i));
                    i++;
                }
                
		 
	
		
		sell=new JButton("SELL"); 
               sell.setForeground(Color.WHITE);
                sell.setOpaque(false);
                 sell.setFont(new Font("Arial",Font.BOLD,15));
              sell.setContentAreaFilled(false);
		

      
        dates.setBounds(100,250,100,25);
        times.setBounds(100,300,100,25);
        sell_stock.setBounds(100,450,180,25);         
        total_stock.setBounds(100, 400,220, 25);
        lname.setBounds(100,350,120,25);
          sell.setBounds(420,600,80,25);
        error.setBounds(200,530,400,80); 
        bal_dis.setBounds(120,580,200,60);
        q=a;
    
        tdate.setBounds(400,249,100,25);
        ttime.setBounds(400,300,100,25);
         name.setBounds(400,350,100,25);
         tsell_stock.setBounds(400, 449, 100, 30);
       ltotal_stock.setBounds(400,399,100,25);  
      
    
        con.add(head);
  
        con.add(dates);
        con.add(times);
        con.add(total_stock);
        con.add(sell_stock);
        con.add(lname);
        con.add(sell);
        con.add(error);
        con.add(bal_dis); 
        
        
        con.add(text_id); 
        con.add(tdate);
        con.add(ttime);
        con.add(ltotal_stock);
        con.add(tsell_stock);
        con.add(name); 
       
        
        setSize(640,850);
         ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/buyye.jpg"));
        JLabel back=new JLabel("",img,JLabel.CENTER);
        back.setBounds(0,0,640,850);
        add(back);
        setVisible(true);
       
        
     
        sell .addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int q2=sname();
                int balncetamnt=stock_sell*q2;
                v= balncetamnt+balamt;
                counting3=stkvalue();
                bs=counting3+stock_sell;
            
                balanceupdate(a,stk_name,v,bs);
                Object o=e.getSource();
                if(o==sell){
                int id1=Integer.parseInt(text_id.getText());
                process="Sell";
                stockname=name.getSelectedItem().toString();
                String dates=tdate.getText();
                String time=ttime.getText();
          try
           {
               Connection con=datatbase.getConnection();
           Statement stmt=con.createStatement();
           String query="insert into orderhis values("+a+",'"+process+"','"+dates+"','"+time+"','"+stk_name+"',"+stock_sell+","+q2+","+v+")";
            stmt.executeUpdate(query);
             
            bt=counting-stock_sell;
            
            System.out.println(""+bt);
            System.out.println(""+counting);
            System.out.println(""+stock_sell);
            String email="";
        
        if(process.equals("buy"))
            process="Buying";
        else
            process="Selling";
        String message="Thanks For "+process+" "+Integer.toString(stock_sell)+" Stocks in "+stockname+"!\n"+"Have A Good Day And Invest More!";
        try
        {
        
            String S="select email from UserPro where id=?";
            PreparedStatement P=con.prepareStatement(S);
            P.setInt(1,q);
            ResultSet R = P.executeQuery();
            if(R.next())
            {
                email=R.getString("email");
            }
        }
        catch(Exception eq)
        {
            JOptionPane.showMessageDialog(null, "Unable to fetch data from UserPro"+e.toString());
        }
        new mail(email,message);
         insert(a,bt,stk_name);
          f.dispose();
            new StockTrading(a);
           }
           catch(Exception e1)
           {
               JOptionPane.showMessageDialog(null, "Unable to fetch data from UserPro"+e.toString());
           }
                                                  
                 }
                 }}
             );
        
        name.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		stk_name=(String)name.getSelectedItem();
        		counting =count(stk_name,a);
                   
                    
        	}
      }); 
        
        
        tsell_stock.addKeyListener(new KeyListener() {              
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                stock_sell=Integer.parseInt(tsell_stock.getText());
                
                if(counting>=stock_sell){
                    error.setVisible(false);
                    tsell_stock.setForeground(Color.green);
                }
                else{
                	tsell_stock.setForeground(Color.red);
                    error.setText("INSUFFICIENT STOCKS !");
                    error.setVisible(true);
                }    
            }    
        });
 
        }  
	String balance(int a){                                                        
        
        try{
           Connection con=datatbase.getConnection();
           Statement s=con.createStatement();
          
            String sql="select balance from wallet where id="+a+"";                  //wallet db using id(a)    
            ResultSet r=s.executeQuery(sql);
            while(r.next()){                     
                balance=r.getString("balance");                                           //age->balance    
            }
            balamt=Integer.parseInt(balance);
           con.setAutoCommit(true);}
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Unable to fetch data from wallet"+e.toString());
       }   
       return balance;
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
        }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Unable to fetch data from Stock"+e.toString());
       }   
               
            
       return allname;
    } 
   int stkvalue()
   {
        int p1=0;
       try{
       Connection con=datatbase.getConnection();
            Statement stmt=con.createStatement(); 
            String sname=((String)name.getSelectedItem());
             
               String sql="select * from stock where sname='"+sname+"'";
               ResultSet a=stmt.executeQuery(sql);
               int i=0;
                while(a.next())
            {
                
                   p1=a.getInt("scount");
                  
                   
                 i++;
            	
            }
       }
       catch(Exception ex){
          
        } 
       return p1;
   }
   int sname()
   {
       try{
        Connection con=datatbase.getConnection();
            Statement stmt=con.createStatement(); 
            String sname=((String)name.getSelectedItem());
             
               String sql="select * from stock where sname='"+sname+"'";
               ResultSet a=stmt.executeQuery(sql);
               int i=0;
                while(a.next())
            {
                
                  int p1=a.getInt("scount");
                  p2=a.getInt("svalue");
                  
                   
                 i++;
            	
            }
               
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Unable to fetch data from stock"+ex.toString());
        } 
        return p2;
   }
	int count(String com_name,int b) {
            int counting1=0;
           
		try
		{
                   
	     Connection con=datatbase.getConnection();
             Statement stmt2=con.createStatement(); 
            String sname=((String)name.getSelectedItem());
         
         
            String sql2="select * from trade where id="+b+""; 
       
              ResultSet a2=stmt2.executeQuery(sql2);
            while(a2.next())
            {
               
                 ltotal_stock.setText(Integer.toString(a2.getInt(sname)));
                 counting1=a2.getInt(sname);
                
            }
           
            
           
             con.setAutoCommit(true);
		}
                
		catch(Exception ex){
           
        } 
		return counting1;
		
		}
void balanceupdate(int id,String stk_name,int baln,int stcount){                       
        
        try{
            Connection con=datatbase.getConnection();
            Statement s=con.createStatement();
            balamt=baln;      
             String sql="update wallet set balance="+baln+" where id="+q+"";//hema->wallet db& fname->id
            String sql1="update stock set scount="+stcount+" where sname='"+stk_name+"'";  //balance           
            ResultSet r1=s.executeQuery(sql1);
            ResultSet r=s.executeQuery(sql);
            con.setAutoCommit(true);}
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Unable to update wallet"+e.toString());
        } 
    }
void insert(int uid,int stockbuy1,String com_name){                        
    
    try{ 
       
        Connection c=datatbase.getConnection();
        Statement s=c.createStatement();
        String sql="update trade set "+com_name+"= "+stockbuy1+" where id="+uid+" ";      
        s.executeUpdate(sql);
        
        c.setAutoCommit(true);
        JOptionPane.showMessageDialog(this, "THANKS FOR SELLING:) ");
        new Stock();
        new Stock(com_name,stock_sell,process);
        dispose();
    }
        catch(Exception e){
        JOptionPane.showMessageDialog(this, "Unable to update trade"+e.toString());
    }  
 }
	
	
	 public static void main(String args[]){
	     
	    }
}