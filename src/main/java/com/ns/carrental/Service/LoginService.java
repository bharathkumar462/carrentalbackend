package com.ns.carrental.Service;

import com.ns.carrental.Repository.LoginRepo;
import com.ns.carrental.model.EmailSendingModel;
import com.ns.carrental.model.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    public static int otp=0;
    @Autowired
    LoginRepo loginRepo;
    @Autowired
    MailSendingService mailSendingService;
    @Autowired
    HttpSession session;
    public LoginBean findpassword(LoginBean login) {
        LoginBean l = loginRepo.findByPhonenumberAndPassword(login.getPhonenumber(), login.getPassword());
        return l;
    }

    public void newdata(LoginBean reg) {
        reg.setPassword(reg.getRepassword());
        LoginBean r = loginRepo.save(reg);

    }

    public boolean forgotpassword(LoginBean login) throws Exception {
        LoginBean l = loginRepo.findByPhonenumberAndUsername(login.getPhonenumber(), login.getUsername());
        if (l != null) {
            session.setAttribute("customer",l);
            EmailSendingModel mail = new EmailSendingModel();
            String mailAddress = l.getEmail();
            mail.setFrom("budayakumar@nextsphere.com");
            mail.setTo(mailAddress);
            mail.setSubject("forgot password");
            otp = getRandomInteger(200,500);
            mail.setContent("your one time password is: "+otp);
            ClassPathResource file = new ClassPathResource("");
            mailSendingService.sendMessage(mail);
            return true;
        } else {
            return false;
        }
    }
    public int getRandomInteger(double min, double max){
        int x = (int)((Math.random()*((max-min)+1))+min);
        return x;
    }
    public boolean checkotp(int userotp) {
        if (userotp == otp) {
            otp = 0;
            return true;
        }
        else{
            return false;
        }
    }
}

