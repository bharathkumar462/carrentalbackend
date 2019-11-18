package com.ns.carrental.Interfaces;
import com.ns.carrental.model.EmailSendingModel;

import javax.mail.MessagingException;

public interface IMailSendingService {
    void sendMessage(final EmailSendingModel EmailSendingModel) throws MessagingException;

}
