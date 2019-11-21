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


    public void newData(BookedCarsList reg) {
        BookedCarsList r = bookedCarsRepo.save(reg);

    }

    public List<CarsListBean> getBookedList(long phonenumber) {
        return carsListRepo.findByPhonenumber(phonenumber);
    }

    public List<BookedCarsList> getAllList(String numberplate) {
        return bookedCarsRepo.findByNumberplate(numberplate);
    }

    public List<BookedCarsList> myTrips(long phonenumber) {
        return bookedCarsRepo.findByPhonenumber(phonenumber);
    }

   public BookedCarsList tripClose(String numberplate){
       return bookedCarsRepo.findByNumberplateAndBookstatus(numberplate,true);
   }
}
