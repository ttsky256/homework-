package com.mall.service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Date;

public class SendEmail {
    private String from = "13029566807m@sina.cn";
    private String to;
    private String host = "smtp.sina.cn";
    private final String subject;
    private final String content;
    private Session session;

    public SendEmail(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public void send() throws MessagingException {
        Properties properties =  new Properties();
        properties.setProperty("mail.transport.protocol","SMTP");
        properties.setProperty("mail.smtp.host", host);
        //properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.ssl.enable", "true");
        final String smtpPort = "465";
        properties.setProperty("mail.smtp.port", smtpPort);

        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
        properties.setProperty("mail.debug", "false");
        this.session = Session.getInstance(properties);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(this.to));
        message.setSubject(subject, "UTF-8");
        message.setContent(content,"text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        Transport transport = session.getTransport();
        String password = "ea24335c56409136";
        transport.connect(from, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        //Transport.send(message);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
