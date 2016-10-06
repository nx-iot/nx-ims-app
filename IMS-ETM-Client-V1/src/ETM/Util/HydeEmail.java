/*
 * HydeEmail Module
 *  Version 0.4 (01/05/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class HydeEmail
{
    private String smtpServer;
    private String user;
    private String pass;

    private int server = 0;

    public HydeEmail(String smtpServer, String user, String pass)
    {
        this.smtpServer = smtpServer;
        this.user = user;
        this.pass = pass;

        if (smtpServer.toLowerCase().equals("gmail"))
        {
            server = 1;
        }
    }

    public boolean sendMail(String server, String toEmail, String fromEmail,String subject, String msg)
    {
      String to = toEmail;
      String from = fromEmail;
      String host = server;

      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);

      Session session = Session.getDefaultInstance(properties);

      try{
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         message.setSubject(subject);
         message.setText(msg);

         Transport.send(message);
         return false;
      }
      catch (MessagingException mex)
      {
         mex.printStackTrace();
         return true;
      }
   }

    public boolean sendMailSsl(String from, String to, String subject, String msg)
    {
        switch (server)
        {
            case 1:
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator()
                    {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(user, pass);
                        }
                    }
                );
                try
                {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse(to));
                    message.setSubject(subject);
                    message.setText(msg);

                    Transport.send(message);
                    return true;
                }
                catch (MessagingException e)
                {
                    return false;
                }
        }
        return false;
    }

    public boolean sendMailTLS(String from, String to, String subject, String msg)
    {
        switch (server)
        {
            case 1:
            String host = "smtp.gmail.com";
            int port = 587;
            String username = user;
            String password = pass;

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props);

            try
            {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));
                message.setSubject(subject);
                message.setText(msg);

                Transport transport = session.getTransport("smtp");
                transport.connect(host, port, username, password);

                Transport.send(message);

                System.out.println("Done");
                return true;
            }
            catch (MessagingException e)
            {
                return false;
            }
        }
        return false;
    }

}


