/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.trading;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*; 
import connection.datatbase;
public class ProfileForm extends JFrame implements ActionListener
{
    Container c;
    JLabel name,dob,gender,aadhar,pin,state,phone,account,ifsc,email,password;
    JTextField Name,Dob,Gender,Aadhar,Pin,State,Phone,Account,Ifsc,Email,Password;
    JButton update;
    int Id;
    public ProfileForm(int n)
    {
       c=getContentPane();
        c.setLayout(null);
        
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\viewi.png");
        setIconImage(icon);
        setTitle("VIEW DETAILS");
       name=new JLabel("Name");
        dob=new JLabel("Date Of Birth");
        gender=new JLabel("Gender");
        aadhar=new JLabel("Aadhar");
        pin=new JLabel("Pincode");
        state=new JLabel("State");
        phone=new JLabel("Phone");
        account=new JLabel("Account No.");
        ifsc=new JLabel("IFSC Code");
        email=new JLabel("Email");
        password=new JLabel("Password");
        
        Name=new JTextField();
        Dob=new JTextField();
        Gender=new JTextField();
        Aadhar=new JTextField();
        Pin=new JTextField();
        State=new JTextField();
        Phone=new JTextField();
        Account=new JTextField();
        Ifsc=new JTextField();
        Email=new JTextField();
        Password=new JTextField();
        

        update=new JButton("UPDATE FORM");
        update.addActionListener(this);
        
        name.setBounds(70, 100, 140, 25);
        dob.setBounds(70, 150, 140, 25);
        gender.setBounds(70, 200, 140, 25);
        aadhar.setBounds(70, 250, 140, 25);
        pin.setBounds(70, 300, 140, 25);
        state.setBounds(70, 350, 140, 25);
        phone.setBounds(70, 400, 140, 25);
        account.setBounds(70, 450, 140, 25);
        ifsc.setBounds(70, 500, 140, 25);
        email.setBounds(70, 550, 140, 25);
        password.setBounds(70, 600, 140, 25);
        
        update.setBounds(130, 700, 220, 50);
   
        Name.setBounds(210, 100, 170, 25);
        Dob.setBounds(210, 150, 170, 25);
        Gender.setBounds(210, 200, 170, 25);
        Aadhar.setBounds(210, 250, 170, 25);
        Pin.setBounds(210, 300, 170, 25);
        State.setBounds(210, 350, 170, 25);
        Phone.setBounds(210, 400, 170, 25);
        Account.setBounds(210, 450, 170, 25);
        Ifsc.setBounds(210, 500, 170, 25);
        Email.setBounds(210, 550, 170, 25);
        Password.setBounds(210, 600, 170, 25);
        
        name.setFont(new Font("Arial",Font.PLAIN,20));
        dob.setFont(new Font("Arial",Font.PLAIN,20));
        gender.setFont(new Font("Arial",Font.PLAIN,20));
        aadhar.setFont(new Font("Arial",Font.PLAIN,20));
        pin.setFont(new Font("Arial",Font.PLAIN,20));
        state.setFont(new Font("Arial",Font.PLAIN,20));
        phone.setFont(new Font("Arial",Font.PLAIN,20));
        account.setFont(new Font("Arial",Font.PLAIN,20));
        ifsc.setFont(new Font("Arial",Font.PLAIN,20));
        email.setFont(new Font("Arial",Font.PLAIN,20));
        password.setFont(new Font("Arial",Font.PLAIN,20));
        
        name.setForeground(Color.WHITE);
        dob.setForeground(Color.WHITE);
        gender.setForeground(Color.WHITE);
        aadhar.setForeground(Color.WHITE);
        pin.setForeground(Color.WHITE);
        state.setForeground(Color.WHITE);
        phone.setForeground(Color.WHITE);
        account.setForeground(Color.WHITE);
        ifsc.setForeground(Color.WHITE);
        email.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        
        Name.setOpaque(false);
        Dob.setOpaque(false);
        Gender.setOpaque(false);
        Aadhar.setOpaque(false);
        Pin.setOpaque(false);
        State.setOpaque(false);
        Phone.setOpaque(false);
        Account.setOpaque(false);
        Ifsc.setOpaque(false);
        Email.setOpaque(false);
        Password.setOpaque(false);
        
        Name.setFont(new Font("Arial",Font.PLAIN,15));
        Dob.setFont(new Font("Arial",Font.PLAIN,15));
        Gender.setFont(new Font("Arial",Font.PLAIN,15));
        Aadhar.setFont(new Font("Arial",Font.PLAIN,15));
        Pin.setFont(new Font("Arial",Font.PLAIN,15));
        State.setFont(new Font("Arial",Font.PLAIN,15));
        Phone.setFont(new Font("Arial",Font.PLAIN,15));
        Account.setFont(new Font("Arial",Font.PLAIN,15));
        Ifsc.setFont(new Font("Arial",Font.PLAIN,15));
        Email.setFont(new Font("Arial",Font.PLAIN,15));
        Password.setFont(new Font("Arial",Font.PLAIN,15));
        
        update.setForeground(Color.WHITE);
        update.setFont(new Font("TimesRoman",Font.PLAIN|Font.BOLD,20));
        update.setOpaque(false);
        update.setContentAreaFilled(false);
        
        Name.setForeground(Color.WHITE);
        Dob.setForeground(Color.WHITE);
        Gender.setForeground(Color.WHITE);
        Aadhar.setForeground(Color.WHITE);
        Pin.setForeground(Color.WHITE);
        State.setForeground(Color.WHITE);
        Phone.setForeground(Color.WHITE);
        Account.setForeground(Color.WHITE);
        Ifsc.setForeground(Color.WHITE);
        Email.setForeground(Color.WHITE);
        Password.setForeground(Color.WHITE);
        
        c.add(name);
        c.add(dob);
        c.add(gender);
        c.add(aadhar);
        c.add(pin);
        c.add(state);
        c.add(phone);
        c.add(account);
        c.add(ifsc);
        c.add(email);
        c.add(password);
        
        c.add(update);
        
        c.add(Name);
        c.add(Dob);
        c.add(Gender);
        c.add(Aadhar);
        c.add(Pin);
        c.add(State);
        c.add(Phone);
        c.add(Account);
        c.add(Ifsc);
        c.add(Email);
        c.add(Password);
        
        Id=n;
        
        try
        {
            Connection con=datatbase.getConnection();
            String S="select name,dob,gender,aadhar,pin,state,phone,account,ifsc,email,password from UserPro where id=?";
            PreparedStatement P=con.prepareStatement(S);
            
            P.setInt(1,n);
            ResultSet R=P.executeQuery();
            
            if(R.next())
            {
                Name.setText(R.getString("name"));
                Name.setEditable(false);
                Dob.setText(R.getString("dob"));
                Dob.setEditable(false);
                Gender.setText(R.getString("gender"));
                Gender.setEditable(false);
                Aadhar.setText(R.getString("aadhar"));
                Aadhar.setEditable(false);
                Pin.setText(R.getString("pin"));
                Pin.setEditable(false);
                State.setText(R.getString("state"));
                State.setEditable(false);
                Phone.setText(R.getString("phone"));
                Phone.setEditable(false);
                Account.setText(R.getString("account"));
                Account.setEditable(false);
                Ifsc.setText(R.getString("ifsc"));
                Ifsc.setEditable(false);
                Email.setText(R.getString("email"));
                Email.setEditable(false);
                Password.setText(R.getString("password"));
                Password.setEditable(false);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"View Failed!");
        }
        setSize(500,900);
        ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/view.jpg"));
        JLabel back=new JLabel("",img,JLabel.CENTER);
        back.setBounds(0,0,500,900);
        add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent v)
    {
       Object obj=v.getSource();
        if(obj==update)
        {
            new UpdateForm(Id);
            dispose();
        } 
    }
    public static void main(String ar[])
    {
        new ProfileForm(1);
    }
}
