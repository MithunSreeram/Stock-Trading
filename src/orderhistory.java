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
public class orderhistory extends JFrame{
     JTable table;
 String[] columnNames = {"id", "Process", "date", "time","StockName","Stockcount","Stockvalue","Total"};
orderhistory(int a)
{
        JFrame frame1 = new JFrame("ORDER HISTORY");
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\stockpage.png");
        frame1.setIconImage(icon);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        int id=0;
        String process="";
        String sname = "";
        String time="";
        String day="";
        int svalue,scount,total;
        try {
                Connection con=datatbase.getConnection();
                String query="select *from orderhis where id="+a+" ";
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
               
                int i = 0;
                while (rs.next()) {
           
                  id=rs.getInt("id");
                  process=rs.getString("process");
                  sname = rs.getString("sname");
                  svalue=rs.getInt("svalue"); 
                  scount=rs.getInt("scount");
                  total=rs.getInt("total");
                  day=rs.getString("day");
                  time=rs.getString("time");
                  model.addRow(new Object[]{id,process,day,time,sname,scount,svalue,total});
                  i++;
                                  }
          
             }
        catch (Exception ex) 
        {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(1000, 1000);
            }

public static void main(String args[])
{
   new orderhistory(1009);
}
}