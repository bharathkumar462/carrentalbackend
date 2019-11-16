package com.ns.carrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ns.carrental.Service.CarsListService;
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
    CarsListService carsListService;

    @PostMapping(value = "/cars/add")
    public void addcars(@RequestParam("image") MultipartFile file, @RequestParam("data") String data) throws IOException {

        CarsListBean carslist = new ObjectMapper().readValue(data, CarsListBean.class);
        carslist.setImage(file.getBytes());
        carslist.setBookstatus(false);
        carsListService.newdata(carslist);
    }
    @PostMapping(value = "/cars/updatestatus")
    public void updatestatus(@RequestBody CarsListBean data) {

        data.setBookstatus(true);
        System.out.println(data.toString());
        carsListService.newdata(data);
    }
    @PostMapping(value = "/cars/getbyavailability")
    public List<CarsListBean> getbyavailability(@RequestBody String availability) {
        return carsListService.getcars(availability);
    }
}
