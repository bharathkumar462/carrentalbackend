package com.ns.carrental.interfaces;

import com.ns.carrental.model.CarsListBean;

import java.util.List;

public interface ICarsListService {

     void newData(CarsListBean reg);

     List<CarsListBean> getCars(String reg);
}
