package com.ns.carrental.interfaces;
import com.ns.carrental.model.EmailSendingModel;

import javax.mail.MessagingException;

public interface IMailSendingService {

    void sendMessage(final EmailSendingModel EmailSendingModel) throws MessagingException;

}
