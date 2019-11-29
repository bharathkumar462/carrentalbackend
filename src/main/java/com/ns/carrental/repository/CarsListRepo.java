package com.ns.carrental.repository;

import com.ns.carrental.model.CarsListBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsListRepo extends JpaRepository<CarsListBean, Long> {
        List<CarsListBean> findByAvailability(String availability);
        List<CarsListBean> findByPhonenumber(long phonenumber);
        CarsListBean findByNumberplate(String numberplate);
}
