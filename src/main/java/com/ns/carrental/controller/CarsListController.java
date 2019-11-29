package com.ns.carrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ns.carrental.interfaces.ICarsListService;
import com.ns.carrental.repository.CarsListRepo;
import com.ns.carrental.exception.ImageOverSizeException;
import com.ns.carrental.exception.RecordExistException;
import com.ns.carrental.model.CarsListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CarsListController {
    @Autowired
    ICarsListService carsListService;

    @Autowired
    CarsListRepo carsListRepo;

    @PostMapping(value = "/cars")
    public void addCars(@RequestParam("image") MultipartFile file, @RequestParam("data") String data) throws Exception
    {
        CarsListBean carslist = new ObjectMapper().readValue(data, CarsListBean.class);
        if(carsListRepo.findByNumberplate(carslist.getNumberplate())==null) {
            if (file.getSize() > 1048576)
                throw new ImageOverSizeException("Provide photo less than 1MB");
            carslist.setImage(file.getBytes());
            carslist.setBookstatus(false);
            carsListService.newData(carslist);
        }
        else
        {
            throw new RecordExistException("Already Car Registered");
        }
    }

    @PostMapping(value = "/cars/status")
    public void updateStatus(@RequestBody CarsListBean data) {
        data.setBookstatus(true);
        carsListService.newData(data);
    }

    @PostMapping(value = "/cars/availability")
    public List<CarsListBean> getByAvailability(@RequestBody String availability) {
        return carsListService.getCars(availability);
    }
}
