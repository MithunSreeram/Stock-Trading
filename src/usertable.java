/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.trading;
import connection.datatbase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class usertable extends JFrame{
     JTable table;
     String[] columnNames = {"ID","NAME","DOB","GENDER","AADHAR NO","PIN","STATE","PHONE","ACCOUNT NO","IFSC","EMAIL"};
 public usertable()
{
        JFrame frame1 = new JFrame("USERS TABLE");
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\stockpage.png");
        frame1.setIconImage(icon);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setBackground(Color.GRAY);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         int id;
        String name = "";
        String dob="";
        String gender,aadhar,pin,state,phone,acc,ifsc,email;
  
        int svalue,scount;
        try {
                Connection con=datatbase.getConnection();
                String query="select *from userpro";
                    PreparedStatement pstmt=con.prepareStatement(query);
                     ResultSet rs = pstmt.executeQuery();
               
            int i = 0;
            while (rs.next()) {
           
                id=rs.getInt("id");
                
            name = rs.getString("name");
            dob=rs.getString("dob");
                gender=rs.getString("gender"); 
                aadhar=rs.getString("aadhar");
                pin=rs.getString("pin");
                state=rs.getString("state");
                phone=rs.getString("phone");
                acc=rs.getString("account");
                ifsc=rs.getString("ifsc");
                email=rs.getString("email");
                 
                model.addRow(new Object[]{id,name,dob,gender,aadhar,pin,state,phone,acc,ifsc,email});
                i++;
            }
          con.setAutoCommit(true);
                }
        catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(1000, 1000);
            }

public static void main(String args[])
{
new usertable();
}
}