package com.kafka.kafkapoc.service;

import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Service
public class EmailService {

    String to = "himabindu.kalavakuntla@gmail.com";

    String from = "himabindu.kalavakuntla@gmail.com";

    String host = "localhost";

    String port = "587";

    public void sendMail() {
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("smtp.gmail.host", host);
        properties.setProperty("mail.smtp.port", port);
/*
        spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=spasupuleti@nisum.com
spring.mail.password=XXXXXXXXX
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
         */

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


}
