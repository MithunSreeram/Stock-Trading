/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.trading;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;
import connection.datatbase;
import java.sql.PreparedStatement;

public class wallet extends JFrame{
    
    wallet()
    {
        try{
                   Connection con=datatbase.getConnection();
                   Statement stmt=con.createStatement();
                   String query="insert into wallet values('2','1000')";
                   stmt.executeUpdate(query);
                   con.setAutoCommit(true);
                  


            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "000000000000"+ex.toString());
            }
    }
    public static void main(String args[])
    {
        new wallet();
    }
    
}
