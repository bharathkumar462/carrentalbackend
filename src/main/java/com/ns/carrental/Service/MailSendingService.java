package com.ns.carrental.Service;


import com.ns.carrental.model.EmailSendingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSendingService {
    @Autowired
    private JavaMailSender javaMailSender;


    public void sendMessage(final EmailSendingModel EmailSendingModel) throws MessagingException {
        MimeMessage messageData = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messageData, true);
        helper.setSubject(EmailSendingModel.getSubject());
        helper.setText(EmailSendingModel.getContent());
        helper.setTo(EmailSendingModel.getTo());
        helper.setFrom(EmailSendingModel.getFrom());
        javaMailSender.send(messageData);
    }
}
