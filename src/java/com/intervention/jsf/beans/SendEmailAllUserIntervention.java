/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jsf.beans;

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

/**
 *
 * @author pc_ahmed
 */
@ManagedBean
@SessionScoped
public class SendEmailAllUserIntervention {
    
      intervenant inter = new intervenant();
    public String getMails() throws Exception{
        StringBuilder builder = new StringBuilder();
        
        Iterator<intervenant> iter = inter.getMails().iterator();
        
        while(iter.hasNext()){
            builder.append(iter.next().getEmail() +",");
        }
        builder.replace(builder.toString().lastIndexOf(','), builder.toString().lastIndexOf(',')+ 1, "");
        return builder.toString();
    }
	public  void send(String user) throws Exception {

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
                        
                             String cc = this.getMails();

                            message.setRecipients(Message.RecipientType.CC,
				InternetAddress.parse(cc));

			message.setSubject("nouvelle Intervention");
			message.setText("nouvelle Intervention fait par intervenant : '"+user +"'");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
    
}
