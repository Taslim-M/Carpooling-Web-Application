/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailInterface;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Tasli
 */
public class EmailSender {

    public static void sendEmail(String toAddress) throws MessagingException {
        Session session = EmailConfiguration.getSession();
        String userName = EmailConfiguration.getUserName();
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

    public static void notifyAdminNewApplicant(String toAddress, String emailDriver) throws MessagingException {
        Session session = EmailConfiguration.getSession();
        String userName = EmailConfiguration.getUserName();
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toAddress)
            );
            message.setSubject("New Driver Applicant: Needs Review");
            message.setText("Dear Admin,"
                    + "\n\n Please review a new driver application which is pending!"
                    + "\n The email address of the driver is: "+ emailDriver);

            Transport.send(message);
            System.out.println("Email Sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
