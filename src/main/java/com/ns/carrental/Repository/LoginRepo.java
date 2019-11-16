package com.ns.carrental.Repository;

import com.ns.carrental.model.LoginBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<LoginBean, Long> {
    LoginBean findByPhonenumberAndPassword(long phonenumber,String password);
    LoginBean findByPhonenumberAndUsername(long phonenumber,String username);
}
