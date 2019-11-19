package com.ns.carrental.Repository;

import com.ns.carrental.model.LoginBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<LoginBean, Long> {

    Optional<LoginBean> findByPhonenumberAndPassword(long phonenumber, String password);
    Optional<LoginBean> findByPhonenumberAndUsername(long phonenumber,String username);
}
