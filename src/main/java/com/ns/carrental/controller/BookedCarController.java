package com.ns.carrental.controller;

import com.ns.carrental.Interfaces.IBookedCarsService;
import com.ns.carrental.Interfaces.ICarsListService;
import com.ns.carrental.Repository.CarsListRepo;
import com.ns.carrental.Service.BookedCarsService;
import com.ns.carrental.Service.CarsListService;
import com.ns.carrental.model.BookedCarsList;
import com.ns.carrental.model.CarsListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class BookedCarController {
    @Autowired
    IBookedCarsService bookedCarsService;

    @Autowired
    ICarsListService carsListService;

    @Autowired
    CarsListRepo carsListRepo;

    @PostMapping(value = "/bookcars")
    public void addCars(@RequestBody BookedCarsList bookedCarsList) {
        bookedCarsService.newData(bookedCarsList);
    }

    @PostMapping(value = "/admin/carslist")
    public List<CarsListBean> bookedCarsList(@RequestBody long phonenumber) {
        List<CarsListBean> carlist = bookedCarsService.getBookedList(phonenumber);
        return carlist;
    }

    @PostMapping(value = "/admin/triplists")
    public List<BookedCarsList> tripList(@RequestBody String numberplate) {
        List<BookedCarsList> carlist = bookedCarsService.getAllList(numberplate);
        return carlist;
    }

    @PostMapping(value = "/customers/triplists")
    public List<BookedCarsList> customerTriplist(@RequestBody long phonenumber) {
        List<BookedCarsList> carlist = bookedCarsService.myTrips(phonenumber);
        return carlist;
    }

    @PutMapping(value = "/cars/{numberplate}")
    public void bookStatus(@PathVariable("numberplate") String numberplate, @RequestBody BookedCarsList bookedCarsList){
        System.out.println(numberplate);
        BookedCarsList car=bookedCarsService.tripClose(numberplate);
        car.setBookstatus(false);
        bookedCarsService.newData(car);
      CarsListBean c=carsListRepo.findByNumberplate(numberplate);
      c.setBookstatus(false);
      carsListRepo.save(c);
    }
}
