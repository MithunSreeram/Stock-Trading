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

import java.util.Vector;
public class tradetable extends JFrame{
     Container co;
     JTable table;
     String columnnames[];
 
 public tradetable()
{
        JFrame frame1 = new JFrame("TRADE TABLE");
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\stockpage.png");
        frame1.setIconImage(icon);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
         try {
                Connection con=datatbase.getConnection();
                String query="Select * from trade";
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();
                String []columnnames=new String[columnCount];
                int j=0;
                for (int i=1; i<=columnCount; i++) {
 
                     columnnames[j] = metadata.getColumnName(i);
                     j++;
                  }
                  model.setColumnIdentifiers(columnnames);
                  con.setAutoCommit(true);
         }
          catch(Exception e)
          {
                  
          }

        
        
        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        int id;
        String amazon,zoho,reliance;
        try {
            Connection con=datatbase.getConnection();
           
            String query="Select*from trade";
            String query2="select count(*) from trade";
          PreparedStatement pstmt=con.prepareStatement(query);
            PreparedStatement pstmt2=con.prepareStatement(query2);
                     ResultSet rs = pstmt.executeQuery();  
                     ResultSet rs2=pstmt2.executeQuery(); 
                         rs2.next();
                         int count = rs2.getInt(1);
                      
                     ResultSetMetaData metadata = rs.getMetaData();
                  
                   int columnCount = metadata.getColumnCount();
                   String name[]=new String [columnCount];
                  
                   
                     
                          int i=0;
                                while(rs.next()&&i<count)
                               {
                               for(int j=0;j<columnCount;j++)
                               {
                                 name[j]=rs.getString(metadata.getColumnName(j+1));
                                  
                                 System.out.print(name[j]);
                                  
                               }
                             
                               model.addRow(name); 
                               
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
new tradetable();
}
}