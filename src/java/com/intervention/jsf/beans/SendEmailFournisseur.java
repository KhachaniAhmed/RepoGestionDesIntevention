package com.intervention.jsf.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@ManagedBean
@SessionScoped
public class SendEmailFournisseur {
    private String ToEmail;
    private String Subject;
    private String message;

    public String getToEmail() {
        return ToEmail;
    }

    public String getSubject() {
        return Subject;
    }

    public String getMessage() {
        return message;
    }

    public void setToEmail(String ToEmail) {
        this.ToEmail = ToEmail;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }
  
    
    
    
   
                     
  
	public  void send() throws Exception {

		final String username = "ahmedkhachani@gmail.com";
		final String password = "ahmed estm";// awdi a l pass tzz

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ahmedkhachani@gmail.com"));
                        
                             Iterator<intervenant> listemail=intervenant.getMails().listIterator();
                          
                            message.setRecipients(Message.RecipientType.CC,
				InternetAddress.parse(this.ToEmail));
                          
			message.setSubject(this.Subject);
			message.setText(this.message);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
