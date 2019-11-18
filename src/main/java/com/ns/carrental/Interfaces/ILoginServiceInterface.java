package com.ns.carrental.Interfaces;

import com.ns.carrental.model.LoginBean;

import java.util.Optional;

public interface ILoginServiceInterface {

    Optional<LoginBean> findpassword(LoginBean login);

     void newdata(LoginBean reg);

    boolean forgotpassword(LoginBean login)throws Exception;

     int getRandomInteger(double min, double max);

    boolean checkotp(int userotp);
}
