package stock.trading;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.datatbase;
import java.awt.image.BufferedImage;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class StockTrading extends JFrame implements ActionListener
{
    JFrame f;
    JMenu menu, submenu;  
    JMenuItem profile,order,logout; 
    boolean adding = false;
    JButton buy,sell,addb,addw;
    JLabel balance;
    JTable table;
    JTextField tbalance;
    int no=0;
  public StockTrading(int id)
    {
          f=new JFrame("HomePage");
          Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\stockmar.jpg");
          f.setIconImage(icon);
        
          JMenuBar mb=new JMenuBar(); 
          buy=new JButton("BUY");
           sell = new JButton("SELL");
          addb=new JButton("SEND MONEY+");
           addw=new JButton("ADD MONEY->");
           balance=new JLabel("BALANCE");
           tbalance=new JTextField();
          mb.add(Box. createHorizontalGlue()); 
          menu=new JMenu("   "+name(id)+"  ");
          profile=new JMenuItem("MY PROFILE");  
          order=new JMenuItem("ORDER HISTORY");
          logout=new JMenuItem("LOG OUT");
          menu.add(profile); menu.add(order);menu.add(logout);
          mb.add(menu);
          buy.setBounds(850,70,80,25);
          buy.setOpaque(false);
          buy.setContentAreaFilled(false);
          buy.setForeground(Color.WHITE);
          sell.setBounds(850,120,80,25);
          sell.setOpaque(false);
          sell.setContentAreaFilled(false);
          sell.setForeground(Color.WHITE);
            
          balance.setBounds(120,570,80,25);
          balance.setForeground(Color.WHITE);
          tbalance.setBounds(200,570,80,25);
          tbalance.setBorder(null);
          tbalance.setOpaque(false);
          tbalance.setEditable(false);
          tbalance.setForeground(Color.WHITE);
          addb.setBounds(320,570,150,25);
          addb.setOpaque(false);
          addb.setContentAreaFilled(false);
          addb.addActionListener(this);
          addb.setForeground(Color.WHITE);
          addw.setBounds(510,570,150,25);
          addw.setOpaque(false);
          addw.setContentAreaFilled(false);
          addw.addActionListener(this);
          addw.setForeground(Color.WHITE);
          buy.addActionListener(this);
          sell.addActionListener(this);
          profile.addActionListener(this);
          order.addActionListener(this);
          logout.addActionListener(this);
           JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    
          try{
                   Connection con=datatbase.getConnection();
                   String query="select sid,sname,sicon,svalue,scount from stock";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
                   int i=1;
                   while(rst.next()){
                       String a=Integer.toString(i);
                       m.put(a,new ArrayList<String>());
                       m.get(a).add(Integer.toString(rst.getInt("sid")));
                       m.get(a).add(rst.getString("sname"));
                        m.get(a).add(rst.getString("sicon"));
                       m.get(a).add(Integer.toString(rst.getInt("svalue")));
                       m.get(a).add(Integer.toString(rst.getInt("scount")));
                       i++;    
                   }
                   ArrayList<String> ab=new ArrayList<String>();
                   int k=1;
                   while(k<=m.size())
                   { 
                        ab=m.get(Integer.toString(k));
                       String x=ab.get(0);
                       String x1=ab.get(1);
                       String x2=ab.get(2);
                       String x3=ab.get(3);
                       String x4=ab.get(4); 
                       BufferedImage img=null;
                       JLabel l2=new JLabel();
                       l2.setBackground(Color.YELLOW);
                       ImageIcon imageIcon = new ImageIcon(new ImageIcon(x2).getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));  
                       l2.setIcon(imageIcon);
                       l2.setBounds(100,100,100,100);
                                 
                     String[][] data = {
                                      { "STOCK ID", "STOCK NAME","STOCK VALUE","STOCK COUNT" },{"  ","  ","  "," "},
                                    {x,x1,x3,x4} };
  
                        String[] columnNames = { "N0", "name","Value","count"};
 
                          table = new JTable(data, columnNames);
                          table.setShowGrid(false);
                          table.setFont(new Font("Times new Roman", Font.BOLD, 17));

                          table.setBounds(250,100, 500,50);
                          table.setBackground(new Color(200,221,242));
      
                            JScrollPane sp = new JScrollPane(table);
                            l2.add(sp);
                          l2.add(table);
                           tabbedPane.addTab(x1,l2);             
                           k++;
                       } 
                     con.setAutoCommit(true);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, " Unable to Add new Stock to Homepage");
            }
          no=id;
          tabbedPane.setBounds(70,180,800,300);
          balance(id);
          f.add(buy);
          f.add(sell);
          f.add(balance);
          f.add(tbalance);
          f.add(addb);
          f.add(addw);
          f.add(tabbedPane);  
          f.setLayout(null);  
          f.setJMenuBar(mb);  
          f.setSize(1000,800);
          ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/home.jpg"));
          JLabel back=new JLabel("",img,JLabel.CENTER);
          back.setBounds(0,0,1000,800);
          f.add(back);
       
          f.setVisible(true); 

        
    }  
  String name(int id)
  {
      String name1="";
      try{
             Connection con=datatbase.getConnection();
              Statement s=con.createStatement();
           String sql="select name from UserPro where id="+id+"";                    
            ResultSet r=s.executeQuery(sql);
            while(r.next()){                     
                name1=r.getString("name");                                             
            }
            
            con.setAutoCommit(true);
         }
          catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Unable to Fetch name from Profile ");
            }
      return name1;
  }
     void balance(int id)
     {
         
         try{
             Connection con=datatbase.getConnection();
              Statement s=con.createStatement();
           String sql="select balance from wallet where id="+id+"";                 
            ResultSet r=s.executeQuery(sql);
            
            while(r.next()){                     
                tbalance.setText(r.getString("balance")); 
            }
            
            con.setAutoCommit(true);
         }
          catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Unable to fetch balance from wallet");
            }
     }
  public void actionPerformed(ActionEvent ae){
         Object obj_source=ae.getSource();
           if(obj_source==profile)
        {
           new ProfileForm(no);
        }
        if(obj_source==order)
        {
          new orderhistory(no);
        }
        if(obj_source==logout)
        {
            new LoginForm();
            f.dispose();
        }
        
        if(obj_source==buy){
            
            new BuyForm(no,f); 
            
        }
        if(obj_source==sell)
        {
             
            new Sellform(no,f);
            dispose();
        }
        if(obj_source==addb)
        {
            
            new BankForm(no,f);
        }
        if(obj_source==addw)
        {
            
            new Balanceform(no,f);
        }

        }
    
    
    public static void main(String args[])
    {
       new StockTrading(1011);
    }
}