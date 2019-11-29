package com.ns.carrental.service;

import com.ns.carrental.interfaces.ICarsListService;
import com.ns.carrental.repository.CarsListRepo;
import com.ns.carrental.model.CarsListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsListService implements ICarsListService {

    @Autowired
    CarsListRepo carsListRepo;

    public void newData(CarsListBean reg) {
        CarsListBean r = carsListRepo.save(reg);
    }

    public List<CarsListBean> getCars(String reg) {
        return carsListRepo.findByAvailability(reg);
    }
}
