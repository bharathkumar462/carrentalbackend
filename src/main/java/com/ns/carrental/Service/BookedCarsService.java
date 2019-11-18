package com.ns.carrental.Service;

import com.ns.carrental.Interfaces.IBookedCarsService;
import com.ns.carrental.Repository.BookedCarsRepo;
import com.ns.carrental.Repository.CarsListRepo;
import com.ns.carrental.model.BookedCarsList;
import com.ns.carrental.model.CarsListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedCarsService implements IBookedCarsService {
    @Autowired
    BookedCarsRepo bookedCarsRepo;
    @Autowired
    CarsListRepo carsListRepo;
    public void newdata(BookedCarsList reg){
        BookedCarsList r= bookedCarsRepo.save(reg);
    }

    public List<CarsListBean> getbookedlist (long phonenumber){
        List<CarsListBean> r= carsListRepo.findByPhonenumber(phonenumber);
        return r;
    }
    public List<BookedCarsList> getalllist (String numberplate){
        List<BookedCarsList> r= bookedCarsRepo.findByNumberplate(numberplate);
        return r;
    }
    public List<BookedCarsList> mytrips (long phonenumber){
        List<BookedCarsList> r= bookedCarsRepo.findByPhonenumber(phonenumber);
        return r;
    }
}
