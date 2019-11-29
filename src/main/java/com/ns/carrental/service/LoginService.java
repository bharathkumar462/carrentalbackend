package com.ns.carrental.service;

import com.ns.carrental.interfaces.ILoginServiceInterface;
import com.ns.carrental.repository.LoginRepo;
import com.ns.carrental.exception.RecordNotFoundException;
import com.ns.carrental.model.EmailSendingModel;
import com.ns.carrental.model.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class LoginService implements ILoginServiceInterface {
    public static int otp=0;
    @Autowired
    LoginRepo loginRepo;

    @Autowired
    MailSendingService mailSendingService;

    @Autowired
    HttpSession session;

    public Optional<LoginBean> findPassword(LoginBean login)  {
        return loginRepo.findByPhonenumberAndPassword(login.getPhonenumber(), login.getPassword());
    }

    public void newData(LoginBean reg) {
        loginRepo.save(reg);
    }

    public boolean forgotPassword(LoginBean login) throws Exception {
        Optional<LoginBean> loginBean = loginRepo.findByPhonenumberAndUsername(login.getPhonenumber(), login.getUsername());
        if (loginBean.isPresent()) {
            session.setAttribute("customer",loginBean);
            EmailSendingModel mail = new EmailSendingModel();
            String mailAddress = loginBean.get().getEmail();
            mail.setFrom("budayakumar@nextsphere.com");
            mail.setTo(mailAddress);
            mail.setSubject("forgot password");
            otp = getRandomInteger(200,500);
            mail.setContent("your one time password is: "+otp);
            ClassPathResource file = new ClassPathResource("");
            mailSendingService.sendMessage(mail);
            return true;
        } else {
            throw new RecordNotFoundException("Username or Password not exist");
        }
    }

    public int getRandomInteger(double min, double max){
        int x = (int)((Math.random()*((max-min)+1))+min);
        return x;
    }

    public boolean checkOtp(int userotp) {
        if (userotp == otp) {
            otp = 0;
            return true;
        }
        else{
            return false;
        }
    }
}

