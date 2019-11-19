package com.ns.carrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ns.carrental.Interfaces.ILoginServiceInterface;
import com.ns.carrental.Service.LoginService;
import com.ns.carrental.Service.MailSendingService;
import com.ns.carrental.exception.RecordNotFoundException;
import com.ns.carrental.model.EmailSendingModel;
import com.ns.carrental.model.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    ILoginServiceInterface loginService;

    @Autowired
    HttpSession session;

    @PostMapping(value = "/customers")
    public void createMember(@RequestParam("image") MultipartFile file, @RequestParam("data") String data) throws IOException {
        LoginBean loginBean = new ObjectMapper().readValue(data, LoginBean.class);
        loginBean.setImage(file.getBytes());
        loginService.newData(loginBean);
    }


    @PostMapping(value = "/customers/authenticate")
    public LoginBean checkPassword(@RequestBody LoginBean loginBean) throws Exception {

        Optional<LoginBean> result = loginService.findPassword(loginBean);
        if (result.isPresent())
            return result.get();
        else
            throw new RecordNotFoundException("Username or Password not exist");
    }

    @PostMapping(value = "/customers/reauthenticate")
    public boolean forgotPassword(@RequestBody LoginBean loginBean) throws Exception {

        boolean result = loginService.forgotPassword(loginBean);
        return result;
    }

    @GetMapping(value = "/customers/otpverify/{otp}")
    public boolean otpVerify(@PathVariable int otp) {
        System.out.println(otp);
        boolean result = loginService.checkOtp(otp);
        return result;
    }

    @PostMapping(value = "/customers/password")
    public void updatePassword(@RequestBody LoginBean loginBean) {
        LoginBean lgnbean = (LoginBean) session.getAttribute("customer");
        loginBean.setImage(lgnbean.getImage());
        loginBean.setEmail(lgnbean.getEmail());
        loginService.newData(loginBean);
    }
}
