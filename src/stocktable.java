package stock.trading;
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
import connection.datatbase;
public class stocktable extends JFrame{
     JTable table;
 String[] columnNames = {"STOCKID","STOCKNAME","STOCKICON","STOCKVALUE","STOCKCOUNT"};
public stocktable()
{
        JFrame frame1 = new JFrame("STOCK TABLE");
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\stockpage.png");
        frame1.setIconImage(icon);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
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
        String sname = "";
        String sicon="";
  
        int svalue,scount;
        try {
                Connection con=datatbase.getConnection();
                String query="select *from stock";
                    PreparedStatement pstmt=con.prepareStatement(query);
                     ResultSet rs = pstmt.executeQuery();
               
            int i = 0;
            while (rs.next()) {
           
                id=rs.getInt("sid");
                sicon=rs.getString("sicon");
                sname = rs.getString("sname");
                svalue=rs.getInt("svalue"); 
                scount=rs.getInt("scount");
                 
                model.addRow(new Object[]{id,sname,sicon,svalue,scount});
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


}