package com.ns.carrental.Interfaces;

import com.ns.carrental.model.BookedCarsList;
import com.ns.carrental.model.CarsListBean;

import java.util.List;

public interface IBookedCarsService {
    void newData(BookedCarsList reg);

    List<CarsListBean> getBookedList (long phonenumber);

     List<BookedCarsList> getAllList (String numberplate);

    List<BookedCarsList> myTrips (long phonenumber);

    BookedCarsList tripClose(String numberplate);
}
