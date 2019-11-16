package com.ns.carrental.controller;

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
    BookedCarsService bookedCarsService;
    @Autowired
    CarsListService carsListService;
    @PostMapping(value = "/bookcars/add")
    public void addcars(@RequestBody BookedCarsList bookedCarsList) {
        bookedCarsService.newdata(bookedCarsList);
    }
    @PostMapping(value = "/cars/bookedcarslist")
    public List<CarsListBean> bookedcarslist(@RequestBody long phonenumber) {
       List<CarsListBean> carlist=bookedCarsService.getbookedlist(phonenumber);
    return carlist;
    }
    @PostMapping(value = "/cars/triplists")
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
