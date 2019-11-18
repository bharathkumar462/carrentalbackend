package com.ns.carrental.controller;

import com.ns.carrental.Interfaces.IBookedCarsService;
import com.ns.carrental.Interfaces.ICarsListService;
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

    @PostMapping(value = "/bookcars")
    public void addcars(@RequestBody BookedCarsList bookedCarsList) {
        bookedCarsService.newdata(bookedCarsList);
    }

    @PostMapping(value = "/admin/carslist")
    public List<CarsListBean> bookedcarslist(@RequestBody long phonenumber) {
       List<CarsListBean> carlist=bookedCarsService.getbookedlist(phonenumber);
    return carlist;
    }
    @PostMapping(value = "/admin/triplists")
    public List<BookedCarsList> triplist(@RequestBody String numberplate) {
        List<BookedCarsList> carlist=bookedCarsService.getalllist(numberplate);
        return carlist;
    }
    @PostMapping(value = "/customers/triplists")
    public List<BookedCarsList> customertriplist(@RequestBody long phonenumber) {
        List<BookedCarsList> carlist=bookedCarsService.mytrips(phonenumber);
        return carlist;
    }
}
