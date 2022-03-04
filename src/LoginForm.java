package stock.trading;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import connection.datatbase;
public class LoginForm extends JFrame implements ActionListener 
{
    JLabel email,password;
    JTextField Email;
    JPasswordField Password;
    JButton Login,Register,Admin;
    Container c;
    public LoginForm()
    {
        c=getContentPane();
        c.setLayout(null);
        Image icon=Toolkit.getDefaultToolkit().getImage("src\\image\\logini.png");
        setIconImage(icon);
        setTitle("LOGIN PAGE");
        email=new JLabel("USER MAIL");
        password=new JLabel("PASSWORD");
        Email=new JTextField();
        Password=new JPasswordField();
        Password.setEchoChar('*');
        Login=new JButton("LOGIN");
        Login.addActionListener(this);
        Register=new JButton("REGISTER");
        Register.addActionListener(this);
        Admin=new JButton("ADMIN");
        Admin.addActionListener(this);
        email.setBounds(350, 90, 120, 25);
        email.setForeground(Color.WHITE);
        Email.setBounds(480, 90, 120, 25);
        Email.setForeground(Color.WHITE);
        password.setBounds(350, 140, 120, 25);
        password.setForeground(Color.WHITE);
        Password.setForeground(Color.WHITE);
        Password.setBounds(480, 140, 120, 25);
        Login.setBounds(480, 190, 110, 25);
        Register.setBounds(350, 190, 110, 25);
        Admin.setBounds(418, 240, 110, 25);
        Email.setOpaque(false);
        Password.setOpaque(false);
        Login.setForeground(Color.WHITE);
        Login.setOpaque(false);
        Login.setContentAreaFilled(false);
        Admin.setForeground(Color.WHITE);
        Admin.setOpaque(false);
        Admin.setContentAreaFilled(false);
        Register.setForeground(Color.WHITE);
        Register.setOpaque(false);
        Register.setContentAreaFilled(false);
        Email.setCaretColor(Color.white);
        Password.setCaretColor(Color.white);
        c.add(email);
        c.add(Email);
        c.add(password);
        c.add(Password);
        c.add(Login);
        c.add(Register);
        c.add(Admin);
        
        setSize(1000, 600);
        ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("image/login.jpg"));
         JLabel back=new JLabel("",img,JLabel.CENTER);
         back.setBounds(0,0,1000,600);
         add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Object v = e.getSource();
        if(v==Login)
        {
            try
            {
                String EMAIL = Email.getText();
                String PASSWORD = Password.getText(),TPASSWORD="*";
                int ID=1;
                Connection con = datatbase.getConnection();
                String S = "select id,password from UserPro where email=?";
                PreparedStatement P = con.prepareStatement(S);
                P.setString(1,EMAIL);
                ResultSet R = P.executeQuery();
                if(R.next())
                {
                    ID=R.getInt("id");
                    TPASSWORD=R.getString("Password");
                }
                if(PASSWORD.equals(TPASSWORD))
                {
                    new StockTrading(ID);
                    dispose();
                }
                else
                {
                    Email.setText("");
                    Password.setText("");
                    if(TPASSWORD.equals("*"))
                        JOptionPane.showMessageDialog(this,"Register ID not Available!");
                    else
                        JOptionPane.showMessageDialog(this,"Invalid Password!");
                }
            }
            catch(Exception ex)
            {
                Email.setText("");
                Password.setText("");
                JOptionPane.showMessageDialog(this,"Register ID not Available!");
            }
        }
        else if(v==Register)
        {
            new UserForm();
        }
        else if(v==Admin)
        {
            String ad=Email.getText();
            String Email="admin";
            String pass=Password.getText();
            String checkpass="boot";
            if(pass.equals(checkpass)&&ad.equals(Email))
            {
               new Admin();
               dispose();
            }
            else
                JOptionPane.showMessageDialog(this,"Incorrect Password and User Mail");
        }
    }
    public static void main(String ar[])
    {
        new LoginForm();
    }
}
