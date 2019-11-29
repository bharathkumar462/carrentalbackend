package com.ns.carrental.interfaces;

import com.ns.carrental.model.LoginBean;

import java.util.Optional;

public interface ILoginServiceInterface {

    Optional<LoginBean> findPassword(LoginBean login);

     void newData(LoginBean reg);

    boolean forgotPassword(LoginBean login)throws Exception;

     int getRandomInteger(double min, double max);

    boolean checkOtp(int userotp);
}
