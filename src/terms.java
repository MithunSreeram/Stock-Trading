package stock.trading;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class terms extends JFrame {
    Container c;
    JTextArea condition;
    terms()
    {
          c=getContentPane();
       c.setLayout(null);
       setTitle("Terms & Conditions");
        condition = new JTextArea(
    " ** These Terms and Conditions together with the Risk Disclosure Notice,"+
    "your Application Form, the Order Execution Policy,"+
     " the Conflict of Interest Policy and any supplemental terms and conditions or policies issued by us,"+
     "are known as the 'Agreement'"+
    ". Before you invest you should read these documents"+
      "and ensure that you understand them.\n" +
    "**These Terms and Conditions form part of the agreement between you,"+
     "the client ('You', 'Your(s) or 'yourself'), and TigerWit Limited ('TigerWit', 'we', 'us',"+
      "'ourselves' or 'our(s)'). These govern the services offered by us our relationship"
       +" with you and all transactions that you enter into with us (or any Authorised Third Party using your name,"+
      "account number and/or password).\n" +
    "**You may only Trade or place Orders via our online (or mobile) platform"+
      "or through our dealer's recorded telephone lines. \n"+    
     "**If any other communication media is received it will only be accepted at our discretion.\n" + 
    "**If you make a sell trade then the sale proceeds minus any fees or taxes will become available on your account."+
      "You may use these released funds to make new trades but,"
       +"until the sale transaction has actually settled,"+
        " you will not be able to withdraw such funds from your account\n"+
          "* When you place a trade via your account with us you will be charged a Fee that is based either on a percentage"+
            "of the full value of your trade or a fixed Fee for the trade, whichever is the higher. "
              +  "At our discretion we may agree a different Fee structure in writing either as a standard rate or for a one-off trade."+
            "*Our standard commission rates are published on the Product"+" Information Sheets available on our website.\n"  
    
            
                
            
                
                
                
                
            );
condition.setFont(new Font("Times New Roman", Font.PLAIN,15));
condition.setLineWrap(true);
condition.setWrapStyleWord(true);
condition.setBounds(4,4,480,450);
c.add(condition);
setSize(500,500);
setVisible(true);
    }   
    public static void main(String args[])
    {
        new terms();
    }
    
}