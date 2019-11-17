package com.ns.carrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ns.carrental.Service.LoginService;
import com.ns.carrental.Service.MailSendingService;
import com.ns.carrental.model.EmailSendingModel;
import com.ns.carrental.model.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    HttpSession session;

    @PostMapping(value = "/customers")
    public void createMember(@RequestParam("image") MultipartFile file, @RequestParam("data") String data) throws IOException {
        LoginBean loginBean = new ObjectMapper().readValue(data, LoginBean.class);
        loginBean.setImage(file.getBytes());
        loginService.newdata(loginBean);
    }

    @PostMapping(value = "/customers/authenticate")
    public LoginBean checkPassword(@RequestBody LoginBean loginBean) {

        LoginBean result = loginService.findpassword(loginBean);
        return result;
    }

    @PostMapping(value = "/customers/reauthenticate")
    public boolean forgotpassword(@RequestBody LoginBean loginBean) throws Exception {

        boolean result = loginService.forgotpassword(loginBean);
        return result;
    }

    @GetMapping(value = "/customers/otpverify/{otp}")
    public boolean otpverify(@PathVariable int otp) {
        System.out.println(otp);
        boolean result = loginService.checkotp(otp);
        return result;
    }

    @PostMapping(value = "/customers/password")
    public void updatepassword(@RequestBody LoginBean loginBean) {
        LoginBean lgnbean = (LoginBean) session.getAttribute("customer");
        loginBean.setImage(lgnbean.getImage());
        loginBean.setEmail(lgnbean.getEmail());
        loginService.newdata(loginBean);
    }
}
