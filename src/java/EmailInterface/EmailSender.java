/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailInterface;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Tasli
 */
public class EmailSender {

    private static String host = "smtp.gmail.com";
    private static String port = "587";
    private static final String userName = "carpoolappaus@gmail.com";
    private static final String password = "CarAus1234";



    private static Session getSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        return session;
    }
    
      public static void sendEmail(String toAddress) throws MessagingException {
        Session session = getSession();

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toAddress)
            );
            message.setSubject("Hello from Carpool Website");
            message.setText("Dear Admins,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Email Sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
