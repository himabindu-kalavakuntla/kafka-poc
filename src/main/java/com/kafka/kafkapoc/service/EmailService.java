package com.kafka.kafkapoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Service
public class EmailService {


    private static final String HOST = "smtp.gmail.com";

    private static final String FROM_ADDRESS = "noreplykafka@gmail.com";

    private static final String NO_REPLY_123 = "noreply@123";
    private static final String SUBJECT = "Welcome!";
    private static final String TEXT = "Hello! Welcome to Nisum!!";
    private static final String PROTOCOL = "smtp";

    @Autowired
    private JavaMailSender sender;

    public void sendMail(String toAddresses) {

        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", HOST);
        props.put("", FROM_ADDRESS);
        props.put("mail.smtp.password", NO_REPLY_123);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(FROM_ADDRESS, NO_REPLY_123);
                    }
                });

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(FROM_ADDRESS));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toAddresses));
            message.setSubject(SUBJECT);

            message.setText(TEXT);

            Transport transport = session.getTransport(PROTOCOL);

            transport.connect(HOST, FROM_ADDRESS, NO_REPLY_123);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
