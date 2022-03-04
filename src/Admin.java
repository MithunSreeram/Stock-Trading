package stock.trading;
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
import javax.swing.table.DefaultTableModel;
 class Admin extends JFrame {
     JButton btnstk;JFrame a,b,f;
     
    Admin(){
        super("ADMIN");
        JFrame f=new JFrame();
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\admin.png");
        setIconImage(icon);
        this.setBounds(0, 0, 1530, 950);setLocationRelativeTo(null);
        setResizable(true);
        
        JMenuBar menu=new JMenuBar();
        menu.add(Box.createHorizontalGlue());
        JMenu menu1=new JMenu("    ADMIN    ");
        JMenuItem sub=new JMenuItem("LOGOUT");
        menu1.add(sub);
        menu.add(menu1);
        setJMenuBar(menu);
        
        sub.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            new LoginForm();                               
            dispose();
            
        }});
        
        
        JLabel top=new JLabel("STOCK TRADING");
        top.setBounds(600, 20, 400, 100);
        top.setFont(new Font("Arial Black",Font.BOLD,40));
        add(top);
        JLabel quo=new JLabel("In investing what is comfortable");
        quo.setBounds(80,500,700,70);
        quo.setFont(new Font("Arial Black",Font.ITALIC,25));
        add(quo);
        
        JLabel quo1=new JLabel("is rarely profitable :)");
        quo1.setBounds(120,550,700,70);
        quo1.setFont(new Font("Arial Black",Font.ITALIC,25));
        add(quo1);
        
        JButton addbtn=new JButton("");
        
        addbtn.setIcon(new ImageIcon("src\\image\\addstk2.jpg"));
        addbtn.setBounds(700, 200, 170, 140);
        add(addbtn);
        
        JLabel stockadd=new JLabel("ADD STOCKS");
        stockadd.setBounds(700, 150, 200, 50);
        stockadd.setFont(new Font("Arial Black",Font.ITALIC,20));
        add(stockadd);
        
         addbtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
             new addstock(); 
        }});
        
        
        JButton tradebtn=new JButton("");
        tradebtn.setIcon(new ImageIcon("src\\image\\tra2.jpg"));
        tradebtn.setBounds(1050, 200, 170, 150);
        add(tradebtn);
        
        JLabel titem=new JLabel("TRADE ITEMS");
        titem.setBounds(1050, 150, 200, 50);
        titem.setFont(new Font("Arial Black",Font.ITALIC,20));
        add(titem);
        
        tradebtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        new tradetable();
        }});
        
        JButton stockbtn=new JButton("");
        stockbtn.setIcon(new ImageIcon("src\\image\\stin.jpg"));
        stockbtn.setBounds(700, 550, 170, 150);
        add(stockbtn);
        
        JLabel stocks=new JLabel("STOCKS");
        stocks.setBounds(700, 500, 200, 50);
        stocks.setFont(new Font("Arial Black",Font.ITALIC,20));
        add(stocks);
        
        stockbtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
           new stocktable();
        }});
        
         JButton userbtn=new JButton("");
        userbtn.setIcon(new ImageIcon("src\\image\\user2.jpg"));
        userbtn.setBounds(1050, 550, 170, 150);
        add(userbtn);
        
        JLabel user=new JLabel("USERS");
        user.setBounds(1050, 500, 200, 50);
        user.setFont(new Font("Arial Black",Font.ITALIC,20));
        add(user);
        
        userbtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            new usertable();
            
        }});
        
        add(new JPanel(){
        public void paintComponent(Graphics g){
           super.paintComponent(g);
           Image i=new ImageIcon("src\\image\\123.jpg").getImage();
           Image img=new ImageIcon("src\\image\\admin.png").getImage();
           g.drawImage(i,0, 0, 1530, 950,rootPane);
           g.drawImage(img,150, 100, 320, 400,rootPane);
           g.draw3DRect(40, 60, 500, 700,true);
           g.fill3DRect(40,60,10, 700, true);
           g.setColor(Color.BLACK);
           g.fill3DRect(40,60,500, 10, true);
           g.setColor(Color.BLACK);
           g.fill3DRect(40,760,500, 10, true);
           g.setColor(Color.BLACK);
           g.fill3DRect(540,60,10, 710, true);
           g.setColor(Color.BLACK);
           
        }
    },BorderLayout.CENTER); 
         
        setVisible(true);
  
}
 

    public static void main(String s[]){
    new Admin();
    }
}