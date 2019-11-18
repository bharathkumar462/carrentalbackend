package com.ns.carrental.Interfaces;

import com.ns.carrental.model.BookedCarsList;
import com.ns.carrental.model.CarsListBean;

import java.util.List;

public interface IBookedCarsService {
    void newdata(BookedCarsList reg);

    List<CarsListBean> getbookedlist (long phonenumber);

     List<BookedCarsList> getalllist (String numberplate);

    List<BookedCarsList> mytrips (long phonenumber);

}
