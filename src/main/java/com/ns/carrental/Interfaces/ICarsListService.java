package com.ns.carrental.Interfaces;

import com.ns.carrental.model.CarsListBean;
import com.ns.carrental.model.LoginBean;

import java.util.List;

public interface ICarsListService {

     void newdata(CarsListBean reg);

     List<CarsListBean> getcars(String reg);
}
