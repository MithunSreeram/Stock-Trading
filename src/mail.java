package stock.trading;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class mail 
{
    mail(String n,String m)
    {
        final String username="bootproject2023@gmail.com";
        final String password="Java@123";
        
        final String from=username;
        final String to=n;
        
        Properties P=new Properties();
        
        P.put("mail.smtp.host", "smtp.gmail.com");
	P.put("mail.smtp.socketFactory.port", "465");
	P.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	P.put("mail.smtp.auth", "true");
	P.put("mail.smtp.port", "465");
        
        Authenticator A=new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username,password);
            }
        };
        
        Session S=Session.getInstance(P,A);
        try
        {
            Message M=new MimeMessage(S);
            M.setFrom(new InternetAddress(from));
            M.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            M.setSubject("Stock Trading System");
            M.setText(m);
            
            Transport.send(M);
            
            System.out.println("Done");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String ar[])
    {
        
    }
}
