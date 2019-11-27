package com.ns.carrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ns.carrental.Interfaces.ILoginServiceInterface;
import com.ns.carrental.Repository.LoginRepo;
import com.ns.carrental.exception.ImageOverSizeException;
import com.ns.carrental.exception.RecordExistException;
import com.ns.carrental.exception.RecordNotFoundException;
import com.ns.carrental.model.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    LoginRepo loginRepo;

    @PostMapping(value = "/customers")
    public void createMember(@RequestParam("image") MultipartFile file, @RequestParam("data") String data) throws Exception{
        LoginBean loginBean = new ObjectMapper().readValue(data, LoginBean.class);
        if(loginRepo.findByPhonenumber(loginBean.getPhonenumber()).isPresent())
        {
            throw new RecordExistException("Already Registered");
        }
        else {
            if (file.getSize() > 1048576)
                throw new ImageOverSizeException("Provide photo less than 1MB");
            loginBean.setImage(file.getBytes());
            loginService.newData(loginBean);
        }
    }

    @PostMapping(value = "/customers/authenticate")
    public LoginBean checkPassword(@RequestBody LoginBean loginBean)  {

        Optional<LoginBean> result = loginService.findPassword(loginBean);
        if (result.isPresent())
            return result.get();
        else
            throw new RecordNotFoundException("Username or Password not exist");
    }

    @PostMapping(value = "/customers/reauthenticate")
    public boolean forgotPassword(@RequestBody LoginBean loginBean) throws Exception {
        return loginService.forgotPassword(loginBean);
    }

    @GetMapping(value = "/customers/{otp}")
    public boolean otpVerify(@PathVariable int otp) {
        return loginService.checkOtp(otp);
    }

    @PostMapping(value = "/customers/password")
    public void updatePassword(@RequestBody LoginBean loginBean) {
        Optional<LoginBean> lgnbean = loginRepo.findByPhonenumberAndUsername(loginBean.getPhonenumber(),loginBean.getUsername());
        loginBean.setImage(lgnbean.get().getImage());
        loginBean.setEmail(lgnbean.get().getEmail());
        loginService.newData(loginBean);
    }
}
