package stock.trading;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*; 
import connection.datatbase;
public class UpdateForm extends JFrame implements ActionListener,ItemListener
{
    Container c;
    JLabel name,dob,gender,aadhar,pin,state,phone,account,ifsc,email,password,cpassword;
    JTextField Name,Dob,Aadhar,Pin,State,Phone,Account,Ifsc,Email,Password,Cpassword;
    String Gen="";
    JRadioButton Bmale,Bfemale;
    ButtonGroup Button;
    JButton update;
    int Id;
    public UpdateForm(int n)
    {
        c=getContentPane();
        c.setLayout(null);
        setTitle("UPDATE YOUR DETAILS");
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\viewi.png");
        setIconImage(icon);
       name=new JLabel("Name");
        dob=new JLabel("Date of Birth");
        gender=new JLabel("Gender");
        aadhar=new JLabel("Aadhar");
        pin=new JLabel("Pincode");
        state=new JLabel("State");
        phone=new JLabel("Phone");
        account=new JLabel("Bank Account");
        ifsc=new JLabel("IFSC Code");
        email=new JLabel("Email");
        password=new JLabel("Password");
        cpassword=new JLabel("Confirm Password");
        
        Name=new JTextField();
        Dob=new JTextField();
        Aadhar=new JTextField();
        Pin=new JTextField();
        State=new JTextField();
        Phone=new JTextField();
        Account=new JTextField();
        Ifsc=new JTextField();
        Email=new JTextField();
        
        Password=new JTextField();
        Cpassword=new JTextField();
        
        
        Button=new ButtonGroup();
        Bmale=new JRadioButton("Male");
        Bfemale=new JRadioButton("Female");
        
        Button.add(Bmale);
        Button.add(Bfemale);
        
        update=new JButton("CONFIRM");
       
        
        Bmale.addItemListener(this);
        Bfemale.addItemListener(this);
        update.addActionListener(this);
        
        name.setBounds(60, 50, 140, 25);
        dob.setBounds(60, 100, 140, 25);
        gender.setBounds(60, 150, 140, 25);
        aadhar.setBounds(60, 200, 140, 25);
        pin.setBounds(60, 250, 140, 25);
        state.setBounds(60, 300, 140, 25);
        phone.setBounds(60, 350, 140, 25);
        account.setBounds(60, 400,250, 25);
        ifsc.setBounds(60, 450, 140, 25);
        email.setBounds(60, 500, 140, 25);
        password.setBounds(60, 550, 140, 25);
        cpassword.setBounds(40, 600, 180, 25);
        
        update.setBounds(130, 750, 220, 50);
        
        Name.setBounds(230, 50, 170, 25);
        Dob.setBounds(230, 100, 170, 25);
        Bmale.setBounds(230, 150, 70, 25);
        Bfemale.setBounds(320, 150, 90, 25);
        Aadhar.setBounds(230, 200, 170, 25);
        Pin.setBounds(230, 250, 170, 25);
        State.setBounds(230, 300, 170, 25);
        Phone.setBounds(230, 350, 170, 25);
        Account.setBounds(230, 400, 170, 25);
        Ifsc.setBounds(230, 450, 170, 25);
        Email.setBounds(230, 500, 170, 25);
        Password.setBounds(230, 550, 170, 25);
        Cpassword.setBounds(230, 600, 170, 25);
        
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
        cpassword.setFont(new Font("Arial",Font.PLAIN,20));
        
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
        cpassword.setForeground(Color.WHITE);
        
        update.setForeground(Color.WHITE);
        update.setFont(new Font("TimesRoman",Font.PLAIN|Font.BOLD,20));
        update.setOpaque(false);
        update.setContentAreaFilled(false);
        
        Name.setOpaque(false);
        Dob.setOpaque(false);
        Bmale.setOpaque(false);
        Bfemale.setOpaque(false);
        Aadhar.setOpaque(false);
        Pin.setOpaque(false);
        State.setOpaque(false);
        Phone.setOpaque(false);
        Account.setOpaque(false);
        Ifsc.setOpaque(false);
        Email.setOpaque(false);
        Password.setOpaque(false);
        Cpassword.setOpaque(false);
        
        Name.setFont(new Font("Arial",Font.PLAIN,15));
        Dob.setFont(new Font("Arial",Font.PLAIN,15));
        Bmale.setFont(new Font("Arial",Font.PLAIN,15));
        Bfemale.setFont(new Font("Arial",Font.PLAIN,15));
        Aadhar.setFont(new Font("Arial",Font.PLAIN,15));
        Pin.setFont(new Font("Arial",Font.PLAIN,15));
        State.setFont(new Font("Arial",Font.PLAIN,15));
        Phone.setFont(new Font("Arial",Font.PLAIN,15));
        Account.setFont(new Font("Arial",Font.PLAIN,15));
        Ifsc.setFont(new Font("Arial",Font.PLAIN,15));
        Email.setFont(new Font("Arial",Font.PLAIN,15));
        Password.setFont(new Font("Arial",Font.PLAIN,15));
        Cpassword.setFont(new Font("Arial",Font.PLAIN,15));
        
        Name.setForeground(Color.WHITE);
        Dob.setForeground(Color.WHITE);
        Bmale.setForeground(Color.WHITE);
        Bfemale.setForeground(Color.WHITE);
        Aadhar.setForeground(Color.WHITE);
        Pin.setForeground(Color.WHITE);
        State.setForeground(Color.WHITE);
        Phone.setForeground(Color.WHITE);
        Account.setForeground(Color.WHITE);
        Ifsc.setForeground(Color.WHITE);
        Email.setForeground(Color.WHITE);
        Password.setForeground(Color.WHITE);
        Cpassword.setForeground(Color.WHITE);
        
        Name.setCaretColor(Color.WHITE);
        Dob.setCaretColor(Color.WHITE);
        Aadhar.setCaretColor(Color.WHITE);
        Pin.setCaretColor(Color.WHITE);
        State.setCaretColor(Color.WHITE);
        Phone.setCaretColor(Color.WHITE);
        Account.setCaretColor(Color.WHITE);
        Ifsc.setCaretColor(Color.WHITE);
        Email.setCaretColor(Color.WHITE);
        Password.setCaretColor(Color.WHITE);
        Cpassword.setCaretColor(Color.WHITE);

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
        c.add(cpassword);
        
        
        c.add(update);
        
        c.add(Name);
        c.add(Dob);
        c.add(Bmale);
        c.add(Bfemale);
        c.add(Aadhar);
        c.add(Pin);
        c.add(State);
        c.add(Phone);
        c.add(Account);
        c.add(Ifsc);
        c.add(Email);
        c.add(Password);
        c.add(Cpassword);

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
                Dob.setText(R.getString("dob"));
                if(R.getString("Gender").equals("Male"))
                {
                    Bmale.setSelected(true);
                    Bfemale.setSelected(false);
                }   
                else
                {
                    Bmale.setSelected(false);
                    Bfemale.setSelected(true);
                } 
                Aadhar.setText(R.getString("aadhar"));
                Pin.setText(R.getString("pin"));
                State.setText(R.getString("state"));
                Phone.setText(R.getString("phone"));
                Account.setText(R.getString("account"));
                Ifsc.setText(R.getString("ifsc"));
                Email.setText(R.getString("email"));
                Password.setText(R.getString("password"));
                Cpassword.setText(R.getString("password"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"View Failed!");
        }
        
        setSize(500,900);
        ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/update.jpg"));
        JLabel back=new JLabel("",img,JLabel.CENTER);
        back.setBounds(0,0,500,900);
        add(back);
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent u)
    {
        ItemSelectable a=u.getItemSelectable();
        if(a==Bmale)
            Gen="Male";
        else if(a==Bfemale)
            Gen="Female";
    }
    public void actionPerformed(ActionEvent v)
    {
        Object obj=v.getSource();
        if(obj==update)
        {
            int ID = Id,c=0;
            String NAME = Name.getText();
            if(NAME.matches("^[a-zA-Z ]+$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid Name!");
                Name.setText("");
            }    
            String DOB = Dob.getText();
            if(DOB.matches("([0]?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid D.O.B in dd/mm/yyyy form!");
                Dob.setText("");
            }    
            String AADHAR = Aadhar.getText();
            if(AADHAR.matches("^[0-9]{12}$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid 12 Digit Aadhar Number!");
                Aadhar.setText("");
            }   
            String PIN = Pin.getText();
            if(PIN.matches("^[0-9]{6}$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid 6 Digit Pincode!");
                Pin.setText("");
            }    
            String STATE = State.getText();
            if(STATE.matches("^[a-zA-Z ]+$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid State Name!");
                State.setText("");
            }   
            String PHONE = Phone.getText();
            if(PHONE.matches("^[0-9]{10}$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid 10 Digit Phone Number!");
                Phone.setText("");
            }    
            String ACCOUNT = Account.getText();
            if(ACCOUNT.matches("^[0-9]{16}$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid Account Number!");
                Account.setText("");
            }    
            String IFSC = Ifsc.getText();
            if(IFSC.matches("^[A-Z]{4}0[A-Z0-9]{6}$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter Valid IFSC code!");
                Ifsc.setText("");
            }    
            String EMAIL = Email.getText();
            if(EMAIL.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
                c++;
            else
            {
                JOptionPane.showMessageDialog(this,"Enter a valid Email!");
                Email.setText("");
            }    
            String PASSWORD = Password.getText();
            String CPASSWORD = Cpassword.getText();
            if(c==9&&PASSWORD.equals(CPASSWORD))
            {
                
                    try
                    {
                        Connection con=datatbase.getConnection();
                        String S="update UserPro set name=?,dob=?,gender=?,aadhar=?,pin=?,state=?,phone=?,account=?,ifsc=?,email=?,password=? where id=?";
                        PreparedStatement P=con.prepareStatement(S);
                        P.setString(1,NAME);
                        P.setString(2,DOB);
                        P.setString(3,Gen);
                        P.setString(4,AADHAR);
                        P.setString(5,PIN);
                        P.setString(6,STATE);
                        P.setString(7,PHONE);
                        P.setString(8,ACCOUNT);
                        P.setString(9,IFSC);
                        P.setString(10,EMAIL);
                        P.setString(11,PASSWORD);
                        P.setInt(12,ID);
                        try
                        {
                            P.executeUpdate();
                            con.setAutoCommit(true);
                            JOptionPane.showMessageDialog(this,"Updation Success!");
                            dispose();
                            Name.setText("");
                            Dob.setText("");
                            Bmale.setSelected(false);
                            Bfemale.setSelected(false);
                            Aadhar.setText("");
                            Pin.setText("");
                            State.setText("");
                            Phone.setText("");
                            Account.setText("");
                            Ifsc.setText("");
                            Email.setText("");
                            Password.setText("");
                            Cpassword.setText("");
                            new ProfileForm(ID);
                        }
                        catch(SQLIntegrityConstraintViolationException exg)
                        {
                            JOptionPane.showMessageDialog(null,"Id Already Available!");
                        }
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(this,"Updation Failed!");
                    }
                
               
            }
            else
            {
                if(c==9)
                {
                    JOptionPane.showMessageDialog(this,"Enter valid Information!");
                }
                else
                {
                    Password.setText("");
                    Cpassword.setText("");
                    JOptionPane.showMessageDialog(this,"Password Confirmation failed!");
                }
            }
        }
    }
    public static void main(String ar[])
    {
       
    }
}

