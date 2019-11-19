package com.ns.carrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ns.carrental.Interfaces.ICarsListService;
import com.ns.carrental.model.CarsListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CarsListController {
    @Autowired
    ICarsListService carsListService;

    @PostMapping(value = "/cars")
    public void addCars(@RequestParam("image") MultipartFile file, @RequestParam("data") String data) throws IOException
    {
        CarsListBean carslist = new ObjectMapper().readValue(data, CarsListBean.class);
        carslist.setImage(file.getBytes());
        carslist.setBookstatus(false);
        carsListService.newData(carslist);
    }

    @PostMapping(value = "/cars/status")
    public void updateStatus(@RequestBody CarsListBean data) {

        data.setBookstatus(true);
        System.out.println(data.toString());
        carsListService.newData(data);
    }

    @PostMapping(value = "/cars/availability")
    public List<CarsListBean> getByAvailability(@RequestBody String availability) {
        return carsListService.getCars(availability);
    }
}
